package com.example.arena;

import java.util.*;

public class CreatureFactory {

    private CreatureType randomCreatureType() {
        int typesCount = CreatureType.values().length;
        int randomIdx = new Random().nextInt(typesCount);
        return CreatureType.values()[randomIdx];
    }

    public Creature randomCreature() {
        CreatureType creatureType = randomCreatureType();
        switch (creatureType) {
            case DWARF:
                return new Dwarf(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100),
                        randomProtection());
            case ELF:
                return new Elf(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100), randomProtection());
            case HALFING:
                return new Halfing(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100), randomProtection());
            case HUMAN:
                return new Human(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100), randomProtection());
            case ORC:
                return new Orc(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100), randomProtection());
            case TROLL:
            default:
                return new Troll(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100), randomProtection());
        }
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
        return RandomUtil.random(min, max);
    }

    public List<Creature> randomCreatureList(int listSize) {
        List<Creature> ret = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            ret.add(randomCreature());
        }
        return ret;
    }
}
