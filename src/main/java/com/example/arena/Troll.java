package com.example.arena;

public class Troll extends Creature {

    public Troll(Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints) {
        super(CreatureType.TROLL, strength, dexterity, defence, endurance, lifePoints);
    }
}
