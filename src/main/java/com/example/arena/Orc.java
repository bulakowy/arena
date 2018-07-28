package com.example.arena;

public class Orc extends Creature {

    public Orc(Integer strength,
               Integer dexterity,
               Integer defence,
               Integer endurance,
               Integer lifePoints) {
        super(CreatureType.ORC, strength, dexterity, defence, endurance, lifePoints);
    }
}
