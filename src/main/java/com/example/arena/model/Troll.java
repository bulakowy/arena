package com.example.arena.model;

import java.util.Collection;

public class Troll extends Creature {

    public Troll(String name,
                 Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints,
                 Collection<ProtectionItem> protectionItems) {
        super(CreatureType.TROLL, name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
