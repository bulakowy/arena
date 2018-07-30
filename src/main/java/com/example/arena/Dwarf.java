package com.example.arena;

import java.util.Collection;

public class Dwarf extends Creature {

    public Dwarf(Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints,
                 Collection<ProtectionItem> protectionItems) {
        super(CreatureType.DWARF, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
