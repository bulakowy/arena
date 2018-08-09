package com.example.arena;

import com.example.arena.model.Creature;
import com.example.arena.service.CreatureFactory;
import com.example.arena.service.FightService;

import java.util.List;

public class ArenaApplication {

    public static void main(String[] args) {
        List<Creature> creatures = new CreatureFactory().randomCreatureList(100);
        new FightService().fightAll(creatures);
    }
}
