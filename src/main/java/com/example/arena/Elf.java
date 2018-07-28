package com.example.arena;

public class Elf extends Creature {

    public Elf(Integer strength,
               Integer dexterity,
               Integer defence,
               Integer endurance,
               Integer lifePoints) {
        super(CreatureType.ELF, strength, dexterity, defence, endurance, lifePoints);
    }
}
