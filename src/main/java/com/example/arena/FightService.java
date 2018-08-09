package com.example.arena;

import java.util.*;

public class FightService {

    private CreatureFactory creatureFactory = new CreatureFactory();

    FightResult fight(Creature f1, Creature f2) {

        Map<Creature, List<AttackResult>> attacks = new HashMap<>();
        attacks.put(f1, new ArrayList<>());
        attacks.put(f2, new ArrayList<>());

        System.out.println("Starting a fight between:\n" + f1 + "\nand\n" + f2);
        while (f1.isAlive() && f2.isAlive()) {
            AttackResult res = attack(f1, f2);
            attacks.get(f1).add(res);
            if (f2.isAlive()) {
                res = attack(f2, f1);
                attacks.get(f2).add(res);
            }
        }

        printStats(attacks);

        return new FightResult(f1, f2, f1.isAlive() ? f1 : f2);
    }

    void fightAll(List<Creature> creatures) {
        List<CreaturePair> creaturePairs = generateDistinctCreaturePairs(creatures);
        final List<FightResult> figthResults = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (CreaturePair pair : creaturePairs) {
            Thread t = new Thread(() -> {
                FightResult result = fight(creatureFactory.copyCreature(pair.getLeft()),
                        creatureFactory.copyCreature(pair.getRight()));
                figthResults.add(result);
            });
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printResults(figthResults);
    }

    private AttackResult attack(Creature f1, Creature f2) {
        AttackResult res = f1.attack();
        if (res.getPotentialDamage() > 0) {
            res = f2.dodge(res);
        }
        return res;
    }

    private void printStats(Map<Creature, List<AttackResult>> attacks) {
        printHitBodyPartsStats(attacks);
        printStrongestHit(attacks);
    }

    private void printHitBodyPartsStats(Map<Creature, List<AttackResult>>
                                                attacks) {
        Map<BodyPart, Integer> hitBodyParts = new TreeMap<>();
        for (List<AttackResult> l : attacks.values()) {
            for (AttackResult attack : l) {
                BodyPart hitBodyPart = attack.getHitBodyPart();
                if (hitBodyPart != null) {
                    Integer hits = hitBodyParts.get(hitBodyPart);
                    if (hits == null) {
                        hitBodyParts.put(hitBodyPart, 1);
                    } else {
                        hitBodyParts.put(hitBodyPart, hits + 1);
                    }
                }
            }
        }
        System.out.println("Hit body parts statistics: " + hitBodyParts);

        BodyPart mostHit = null;
        int hits = 0;
        for (Map.Entry<BodyPart, Integer> entry : hitBodyParts.entrySet()) {
            if (entry.getValue() > hits) {
                mostHit = entry.getKey();
                hits = entry.getValue();
            }
        }
        System.out.println("Body part hit most often: " + mostHit + ". Hits: " + hits);
    }

    private void printStrongestHit(Map<Creature, List<AttackResult>> attacks) {
        int strongestHit = 0;
        Creature strongestHitter = null;
        for (Map.Entry<Creature, List<AttackResult>> entry : attacks.entrySet()) {
            for (AttackResult attack : entry.getValue()) {
                int potentialDamage = attack.getPotentialDamage();
                if (potentialDamage > strongestHit) {
                    strongestHit = potentialDamage;
                    strongestHitter = entry.getKey();
                }
            }
        }
        System.out.println("Strongest hit (by potential damage): " +
                strongestHit + " by " + strongestHitter.getName());
    }

    List<CreaturePair> generateDistinctCreaturePairs(List<Creature> creatures) {
        validateInput(creatures);
        List<CreaturePair> ret = new ArrayList<>();
        for (int i = 0; i < creatures.size() - 1; i++) {
            for (int j = i + 1; j < creatures.size(); j++) {
                ret.add(new CreaturePair(creatures.get(i), creatures.get(j)));
            }
        }
        return ret;
    }

    private void validateInput(Collection<Creature> creatures) {
        if (creatures == null) {
            throw new NullPointerException("Creature collection must not be null.");
        }
        if (creatures.size() < 2) {
            throw new IllegalArgumentException("Too few creatures. Minimum required: 2.");
        }
        if (containsDuplicates(creatures)) {
            throw new IllegalArgumentException("Creature collections must not contain duplicates.");
        }
    }

    private <T> boolean containsDuplicates(Collection<T> collection) {
        return collection.size() != new HashSet<>(collection).size();
    }

    private void printResults(List<FightResult> fightResults) {
        Map<String, Integer> points = new HashMap<>();
        fightResults.forEach(fr -> {
            points.put(fr.getFirst().getName(), 0);
            points.put(fr.getSecond().getName(), 0);
        });

        fightResults.forEach(fr -> points.put(fr.getWinner().getName(), points.get(fr.getWinner().getName()) + 1));

        points.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue())).forEach(entry -> System.out
                .println(entry.getKey() + " : " + entry.getValue()));
    }

}
