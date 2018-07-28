package com.example.arena;

public class Dwarf extends Creature {

    public Dwarf(Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints) {
        super(CreatureType.DWARF, strength, dexterity, defence, endurance, lifePoints);
    }
}
