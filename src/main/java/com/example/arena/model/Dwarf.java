package com.example.arena.model;

import java.util.Collection;

public class Dwarf extends Creature {

    public Dwarf(String name,
                 Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints,
                 Collection<ProtectionItem> protectionItems) {
        super(CreatureType.DWARF, name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
