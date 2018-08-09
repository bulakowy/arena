package com.example.arena.service;

import ch.qos.logback.core.util.ExecutorServiceUtil;
import com.example.arena.model.AttackResult;
import com.example.arena.model.Creature;
import com.example.arena.model.CreaturePair;
import com.example.arena.model.FightResult;
import org.springframework.core.task.TaskExecutor;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FightService {

    private StatisticsService statisticsService = new StatisticsService();
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

        System.out.println(statisticsService.getStatistics(attacks));

        return new FightResult(f1, f2, f1.isAlive() ? f1 : f2);
    }

    public void fightAll(List<Creature> creatures) {
        List<CreaturePair> creaturePairs = generateDistinctCreaturePairs(creatures);
        System.out.println("DUPA: " + creaturePairs.size());
        final List<FightResult> figthResults = Collections.synchronizedList(new ArrayList<>());

        runInSeparateThreadsUsingExecutor(creaturePairs, figthResults);

        printResults(figthResults);
    }

    private void runInSeparateThreads(List<CreaturePair> creaturePairs, List<FightResult> figthResults) {
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
    }

    private void runInSeparateThreadsUsingExecutor(List<CreaturePair> creaturePairs, List<FightResult> figthResults) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<Callable<FightResult>> fights = new ArrayList<>();
        for (CreaturePair pair : creaturePairs) {
            Callable c = () -> {
                FightResult result = fight(creatureFactory.copyCreature(pair.getLeft()),
                        creatureFactory.copyCreature(pair.getRight()));
                figthResults.add(result);
                return result;
            };
            fights.add(c);
        }

        try {
            List<Future<FightResult>> futures = executorService.invokeAll(fights);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private AttackResult attack(Creature f1, Creature f2) {
        AttackResult res = f1.attack();
        if (res.getPotentialDamage() > 0) {
            res = f2.dodge(res);
        }
        return res;
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

        System.out.println("SUM = " + points.values().stream().mapToInt(i -> i).sum());

        System.out.println(points.keySet().size());

        points.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue())).forEach(entry -> System.out
                .println(entry.getKey() + " : " + entry.getValue()));
    }

}
