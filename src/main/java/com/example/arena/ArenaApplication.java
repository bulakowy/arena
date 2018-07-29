package com.example.arena;

import java.util.List;

public class ArenaApplication {

    public static void main(String[] args) {
        List<Creature> creatureList = new CreatureFactory().randomCreatureList(2);
        new FightService().fight(creatureList.get(0), creatureList.get(1));
    }
}
