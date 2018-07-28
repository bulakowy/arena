package com.example.arena;

public class Halfing extends Creature {

    public Halfing(Integer strength,
                   Integer dexterity,
                   Integer defence,
                   Integer endurance,
                   Integer lifePoints) {
        super(CreatureType.HALFING, strength, dexterity, defence, endurance, lifePoints);
    }
}
