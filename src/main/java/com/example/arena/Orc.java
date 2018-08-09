package com.example.arena;

import java.util.Collection;

public class Orc extends Creature {

    public Orc(String name,
               Integer strength,
               Integer dexterity,
               Integer defence,
               Integer endurance,
               Integer lifePoints,
               Collection<ProtectionItem> protectionItems) {
        super(CreatureType.ORC, name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
