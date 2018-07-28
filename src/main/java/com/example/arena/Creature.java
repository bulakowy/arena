package com.example.arena;

public abstract class Creature {

    private CreatureType creatureType;
    private Integer strength;
    private Integer dexterity;
    private Integer defence;
    private Integer endurance;
    private Integer lifePoints;

    public Creature(CreatureType creatureType,
                    Integer strength,
                    Integer dexterity,
                    Integer defence,
                    Integer endurance,
                    Integer lifePoints) {
        this.creatureType = creatureType;
        this.strength = strength;
        this.dexterity = dexterity;
        this.defence = defence;
        this.endurance = endurance;
        this.lifePoints = lifePoints;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "creatureType='" + creatureType + '\'' +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", defence=" + defence +
                ", endurance=" + endurance +
                ", lifePoints=" + lifePoints +
                '}';
    }
}
