package com.example.arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                return new Dwarf(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100));
            case ELF:
                return new Elf(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100));
            case HALFING:
                return new Halfing(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100));
            case HUMAN:
                return new Human(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100));
            case ORC:
                return new Orc(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100));
            case TROLL:
            default:
                return new Troll(random(1, 3), random(1, 10), random(1, 3), random(1, 3), random(100, 100));
        }
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
