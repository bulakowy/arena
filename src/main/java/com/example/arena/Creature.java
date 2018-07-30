package com.example.arena;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Creature implements Fightable {

    private CreatureType creatureType;
    private Integer strength;
    private Integer dexterity;
    private Integer defence;
    private Integer endurance;
    private Integer lifePoints;
    private Set<ProtectionItem> protectionItems = new HashSet<>();

    private int MAX_ATTACK_ATTEMPTS = 2;

    public Creature(CreatureType creatureType,
                    Integer strength,
                    Integer dexterity,
                    Integer defence,
                    Integer endurance,
                    Integer lifePoints,
                    Collection<ProtectionItem> protectionItems) {
        this.creatureType = creatureType;
        this.strength = strength;
        this.dexterity = dexterity;
        this.defence = defence;
        this.endurance = endurance;
        this.lifePoints = lifePoints;
        this.protectionItems.addAll(protectionItems);
    }

    @Override
    public AttackResult attack() {
        return attack(1);
    }

    private AttackResult attack(int attempt) {
        info("Attack! Attempt " + attempt);
        if (successfulAttack(attempt)) {
            try {
                BodyPart hitBodyPart = hitBodyPart();
                int potentialDamage = calculatePotentialDamage(hitBodyPart);
                info("Attacking " + hitBodyPart + " with potential damage: " + potentialDamage);
                return new AttackResult(hitBodyPart, attempt, potentialDamage);
            } catch (NoBodyPartHitException e) {
                if (attempt < MAX_ATTACK_ATTEMPTS) {
                    info("Trying to attack again");
                    return attack(attempt + 1);
                } else {
                    info("No more attempts left. Attack failed.");
                    return new AttackResult(null, attempt, 0);
                }
            }
        } else {
            info("Attack failed");
            return new AttackResult(null, attempt, 0);
        }
    }

    private boolean successfulAttack(int attempt) {
        return attempt == 1 || dexterity > RandomUtil.random(1, 10);
    }

    int calculatePotentialDamage(BodyPart hitBodyPart) {
        return strength + RandomUtil.random(0, 3) + hitBodyPart
                .getHitBonus();
    }

    @Override
    public AttackResult dodge(AttackResult attack) {
        int effectiveDamage = 0;
        boolean successfulDodge = defence > RandomUtil.random(1, 10);
        if (successfulDodge) {
            info("Attack succefully dodged");
        } else {
            effectiveDamage = calculateEffectiveDamage(attack);
            if (effectiveDamage > 0) {
                attack.setEffectiveDamage(effectiveDamage);
                info("Got hit. Damage: " + effectiveDamage);
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
        return attack;
    }

    private int calculateEffectiveDamage(AttackResult attack) {
        int potentialDamage = attack.getPotentialDamage();
        int protection = calculateProtection(attack.getHitBodyPart());
        info("Protection: " + protection);
        return potentialDamage - protection - endurance;
    }

    protected int calculateProtection(BodyPart hitBodyPart) {
        return protectionItems.stream()
                .filter(item -> item.getProtectedParts().contains(hitBodyPart))
                .map(item -> item.getMaxProtection())
                .reduce(0, (x, y) -> x + y);
    }

    public boolean isAlive() {
        return lifePoints > 0;
    }

    public static BodyPart hitBodyPart() throws NoBodyPartHitException {
        int random = RandomUtil.random(1, 100);
        int offset = 0;
        for (BodyPart bodyPart : BodyPart.values()) {
            if (offset + bodyPart.getHitProbability() >= random) {
                return bodyPart;
            } else {
                offset += bodyPart.getHitProbability();
            }
        }
        throw new NoBodyPartHitException();
    }

    private void info(String s) {
        System.out.println(creatureType + " : " + s);
    }

    public CreatureType getCreatureType() {
        return creatureType;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public Integer getDefence() {
        return defence;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "creatureType=" + creatureType +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", defence=" + defence +
                ", endurance=" + endurance +
                ", lifePoints=" + lifePoints +
                ", protectionItems=" + protectionItems +
                '}';
    }
}
