package com.example.arena.model.creature;

import com.example.arena.model.ProtectionItem;

import java.util.Collection;

public class Halfing extends Creature {

    public Halfing(String name,
                   Integer strength,
                   Integer dexterity,
                   Integer defence,
                   Integer endurance,
                   Integer lifePoints,
                   Collection<ProtectionItem> protectionItems) {
        super(CreatureType.HALFING, name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
