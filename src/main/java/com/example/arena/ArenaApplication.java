package com.example.arena;

import java.util.List;

public class ArenaApplication {

    public static void main(String[] args) {
        List<Creature> creatures = new CreatureFactory().randomCreatureList(100);
        new FightService().fightAll(creatures);
    }
}
