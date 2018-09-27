package com.example.arena.model.creature;

import com.example.arena.model.ProtectionItem;

import java.util.Collection;

public class Human extends Creature {

    public Human(String name,
                 Integer strength,
                 Integer dexterity,
                 Integer defence,
                 Integer endurance,
                 Integer lifePoints,
                 Collection<ProtectionItem> protectionItems) {
        super(CreatureType.HUMAN, name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
