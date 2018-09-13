package com.example.arena.service;

import com.example.arena.util.IRandomUtil;
import com.example.arena.util.RandomUtil;
import com.example.arena.model.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CreatureFactory {

    @Autowired
    IRandomUtil randomUtil;

    private CreatureType randomCreatureType() {
        int typesCount = CreatureType.values().length;
        int randomIdx = new Random().nextInt(typesCount);
        return CreatureType.values()[randomIdx];
    }

    public Creature newCreature(CreatureType creatureType, String name, Integer strength, Integer dexterity, Integer
            defence, Integer endurance, Integer lifePoints, Collection<ProtectionItem> protectionItems) {
        switch (creatureType) {
            case DWARF:
                return new Dwarf(name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
            case ELF:
                return new Elf(name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
            case HALFING:
                return new Halfing(name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
            case HUMAN:
                return new Human(name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
            case ORC:
                return new Orc(name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
            case TROLL:
            default:
                return new Troll(name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
        }
    }

    public Creature randomCreature() {
        CreatureType creatureType = randomCreatureType();
        String name = randomUtil.randomName();
        int strength = random(3, 3);
        int dexterity = random(3, 3);
        int defence = random(3, 3);
        int endurance = random(3, 3);
        int lifePoints = random(10, 10);
        Collection<ProtectionItem> protectionItems = randomProtection();
        return newCreature(creatureType, name, strength, dexterity, defence, endurance, lifePoints, protectionItems);
    }

    private Collection<ProtectionItem> randomProtection() {
        List<ProtectionItem> protectionItems = new ArrayList<>(Arrays.asList(ProtectionItem.values()));
        List<ProtectionItem> ret = new ArrayList<>();
        int howMany = random(1, ProtectionItem.values().length);
        for (int i = 0; i < howMany; i++) {
            ProtectionItem item = randomProtectionItem(protectionItems);
            ret.add(item);
            protectionItems.remove(item);
        }
        return ret;
    }

    private ProtectionItem randomProtectionItem(Collection<ProtectionItem> items) {
        int typesCount = items.size();
        int randomIdx = new Random().nextInt(typesCount);
        return ProtectionItem.values()[randomIdx];
    }

    private int random(int min, int max) {
        return randomUtil.random(min, max);
    }

    public List<Creature> randomCreatureList(int listSize) {
        List<Creature> ret = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            ret.add(randomCreature());
        }
        return ret;
    }

    public Creature copyCreature(Creature c) {
        return newCreature(c.getCreatureType(), c.getName(), c.getStrength(), c.getDexterity(), c.getDefence(), c
                .getEndurance(), c.getLifePoints(), c.getProtectionItems());
    }

    public Creature newCreature(FighterParams fighterParams) {
        return newCreature(fighterParams.getCreatureType(), fighterParams.getName(), fighterParams.getStrength(),
                fighterParams.getDexterity(), fighterParams.getDefence(), fighterParams.getEndurance(), fighterParams.getLifePoints(),
                Arrays.asList(ProtectionItem.valueOf(fighterParams.getProtectionItem())));
    }
}
