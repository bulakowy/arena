package com.example.arena;

import com.example.arena.model.Creature;
import com.example.arena.service.CreatureFactory;
import com.example.arena.service.FightService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ArenaApplication {

//    public static void main(String[] args) {
//        List<Creature> creatures = new CreatureFactory().randomCreatureList(100);
//        new FightService().fightAll(creatures);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ArenaApplication.class, args);
    }
}
