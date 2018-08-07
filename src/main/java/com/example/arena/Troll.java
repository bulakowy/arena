package com.example.arena;

import java.util.Collection;

public class Troll extends Creature {

    public Troll(Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints,
                 Collection<ProtectionItem> protectionItems) {
        super(CreatureType.TROLL, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
