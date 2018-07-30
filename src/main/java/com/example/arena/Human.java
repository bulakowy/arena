package com.example.arena;

import java.util.Collection;

public class Human extends Creature {

    public Human(Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints,
                 Collection<ProtectionItem> protectionItems) {
        super(CreatureType.HUMAN, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
