package com.example.arena;

public enum BodyPart {
    HEAD(5, 3),
    LEFT_ARM(10, 1),
    RIGHT_ARM(10, 1),
    TRUNK(30, 0),
    LEFT_LEG(5, 2),
    RIGHT_LEG(5, 2);

    private int hitProbability;
    private int hitBonus;

    BodyPart(int hitProbability, int hitBonus) {
        this.hitProbability = hitProbability;
        this.hitBonus = hitBonus;
    }

    public int getHitProbability() {
        return hitProbability;
    }

    public int getHitBonus() {
        return hitBonus;
    }
}
