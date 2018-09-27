package com.example.arena.model.creature;

import com.example.arena.model.ProtectionItem;

import java.util.Collection;

public class Elf extends Creature {

    public Elf(String name,
               Integer strength,
               Integer dexterity,
               Integer defence,
               Integer endurance,
               Integer lifePoints,
               Collection<ProtectionItem> protectionItems) {
        super(CreatureType.ELF, name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }
}
