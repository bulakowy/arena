package com.example.arena;

import java.util.List;

public class ArenaApplication {

    public static void main(String[] args) {
        List<Creature> creatures = new CreatureFactory().randomCreatureList(2);
        new FightService().fight(creatures.get(0), creatures.get(1));
    }
}
