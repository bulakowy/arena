package com.example.arena;

import java.util.Collection;

public class Orc extends Creature {

    public Orc(Integer strength,
               Integer dexterity,
               Integer defence,
               Integer endurance,
               Integer lifePoints,
               Collection<ProtectionItem> protectionItems) {
        super(CreatureType.ORC, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
