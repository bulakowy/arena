package com.example.arena;

public class Human extends Creature {

    public Human(Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints) {
        super(CreatureType.HUMAN, strength, dexterity, defence, endurance, lifePoints);
    }
}
