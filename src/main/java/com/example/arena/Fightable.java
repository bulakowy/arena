package com.example.arena;

public interface Fightable {

    int attack();

    void dodge(int potentialDamage);

    boolean isAlive();

}
