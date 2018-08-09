package com.example.arena;

public class FightResult {

    private final Creature first;
    private final Creature second;
    private final Creature winner;

    public FightResult(Creature first, Creature second, Creature winner) {
        this.first = first;
        this.second = second;
        this.winner = winner;
    }

    public Creature getFirst() {
        return first;
    }

    public Creature getSecond() {
        return second;
    }

    public Creature getWinner() {
        return winner;
    }
}
