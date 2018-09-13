package com.example.arena.model;

import com.example.arena.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tournament {

    @Autowired
    FightService fightService;

    private final int capacity;
    private final int points;
    private final int id;

    private final List<Creature> fighters = new ArrayList<>();

    public Tournament(int capacity, int points, int id) {
        this.capacity = capacity;
        this.points = points;
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPoints() {
        return points;
    }

    public int getId() {
        return id;
    }

    public List<Creature> getFighters() {
        return Collections.unmodifiableList(fighters);
    }

    public List<Creature> addFighter(Creature creature) {
        fighters.add(creature);
        return getFighters();
    }

    public void start() {
        fightService.fightAll(getFighters());
    }
}
