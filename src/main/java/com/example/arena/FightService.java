package com.example.arena;

import java.util.*;

public class FightService {

    void fight(Creature f1, Creature f2) {

        Map<Creature, List<AttackResult>> attacks = new HashMap<>();
        attacks.put(f1, new ArrayList<>());
        attacks.put(f2, new ArrayList<>());

        System.out.println("Starting a fight between " + f1 + " and " + f2);
        while (f1.isAlive() && f2.isAlive()) {
            AttackResult res = attack(f1, f2);
            attacks.get(f1).add(res);
            if (f2.isAlive()) {
                res = attack(f2, f1);
                attacks.get(f2).add(res);
            }
        }

        printStats(attacks);
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
                strongestHit + " by " + strongestHitter.getCreatureType());
    }

}
