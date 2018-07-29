package com.example.arena;

public abstract class Creature implements Fightable {

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
    public int attack() {
        boolean successfulAttack = dexterity > CreatureFactory.random(1, 10);
        if (successfulAttack) {
            int potentialDamage = strength + CreatureFactory.random(0, 3);
            info("Attacking with potential damage: " + potentialDamage);
            return potentialDamage;
        } else {
            info("Attack failed");
            return 0;
        }
    }

    @Override
    public void dodge(int potentialDamage) {
        boolean successfulDodge = defence > CreatureFactory.random(1, 10);
        if (successfulDodge) {
            info("Attack succefully dodged");
        } else {
            int effectiveDamage = potentialDamage - endurance;
            if (effectiveDamage > 0) {
                info("Got hit. Damages: " + effectiveDamage);
                lifePoints = Math.max(0, lifePoints - effectiveDamage);
                if (lifePoints > 0) {
                    info("Life points left: " + lifePoints);
                } else {
                    info("I'm dead :(");
                }
            } else {
                info("Ha ha! Your hit was too weak: " + effectiveDamage);
            }
        }
    }

    public boolean isAlive() {
        return lifePoints > 0;
    }

    private void info(String s) {
        System.out.println(creatureType + " : " + s);
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
