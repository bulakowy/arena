package com.example.excercise;

import com.example.arena.Creature;
import com.example.arena.CreatureFactory;
import com.example.arena.CreatureType;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaExcercises {

    public static void main(String[] args) {
        sortCreaturesByLifePoints(new CreatureFactory().randomCreatureList(10));
        findCreatureWithMaxPoints(new CreatureFactory().randomCreatureList(10));
        groupByType(new CreatureFactory().randomCreatureList(10));
    }

    static void sortCreaturesByLifePoints(List<Creature> creatures) {
        List<Creature> sorted = creatures.stream()
                .sorted(Comparator.comparing(Creature::getLifePoints))
                .collect(Collectors.toList());
        sorted.stream().forEach(c -> System.out.println(c.getLifePoints()));
    }

    private static void findCreatureWithMaxPoints(List<Creature> creatures) {
        Creature withMaxPoints = creatures.stream()
                .sorted(Comparator.comparing(LambdaExcercises::pointsSum).reversed())
                .findFirst().get();
        System.out.println(withMaxPoints);
    }

    private static Map<CreatureType, List<Creature>> groupByType(List<Creature> creatures) {
        Map<CreatureType, List<Creature>> ret = creatures.stream()
                .collect(Collectors.groupingBy(Creature::getCreatureType));
        for (CreatureType type : ret.keySet()) {
            System.out.println(type + " : " + ret.get(type));
        }
        return ret;
    }

    private static int pointsSum(Creature c) {
        return c.getLifePoints() + c.getDefence() + c.getDexterity() + c.getEndurance() + c.getStrength();
    }

}
