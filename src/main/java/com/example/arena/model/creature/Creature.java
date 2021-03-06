package com.example.arena.model.creature;

import com.example.arena.model.*;
import com.example.arena.util.IRandomUtil;
import com.example.arena.util.RandomUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Data
public abstract class Creature implements Fightable, Cloneable {

    IRandomUtil randomUtil = new RandomUtil();

    private final CreatureType creatureType;
    private final String name;
    private final Integer strength;
    private final Integer dexterity;
    private final Integer defence;
    private final Integer endurance;
    private final Integer lifePoints;
    private Integer lifePointsLeft;


    private final Set<ProtectionItem> protectionItems = new HashSet<>();

    private int MAX_ATTACK_ATTEMPTS = 2;

    public Creature(CreatureType creatureType,
                    String name,
                    Integer strength,
                    Integer dexterity,
                    Integer defence,
                    Integer endurance,
                    Integer lifePoints,
                    Collection<ProtectionItem> protectionItems) {
        this.creatureType = creatureType;
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.defence = defence;
        this.endurance = endurance;
        this.lifePoints = lifePoints;
        this.lifePointsLeft = lifePoints;
        this.protectionItems.addAll(protectionItems);
    }

    @Override
    public AttackResult attack() {
        return attack(1);
    }

    private AttackResult attack(int attempt) {
        info("Attack! Attempt " + attempt);
        if (successfulAttack(attempt)) {
            Optional<BodyPart> hitBodyPart = hitBodyPart();
            if (hitBodyPart.isPresent()) {
                BodyPart bodyPart = hitBodyPart.get();
                int potentialDamage = calculatePotentialDamage(bodyPart);
                info("Attacking " + bodyPart + " with potential damage: " + potentialDamage);
                return new AttackResult(bodyPart, attempt, potentialDamage);
            } else {
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
        return attempt == 1 || dexterity > randomUtil.random(1, 10);
    }

    int calculatePotentialDamage(BodyPart hitBodyPart) {
        return strength + randomUtil.random(0, 3) + hitBodyPart
                .getHitBonus();
    }

    @Override
    public AttackResult dodge(AttackResult attack) {
        int effectiveDamage = 0;

        boolean successfulDodge = defence > randomUtil.random(1, 10);
        if (successfulDodge) {
            info("Attack succefully dodged");
        } else {
            effectiveDamage = calculateEffectiveDamage(attack);
            if (effectiveDamage > 0) {
                attack.setEffectiveDamage(effectiveDamage);
                info("Got hit. Damage: " + effectiveDamage);
                lifePointsLeft = Math.max(0, lifePointsLeft - effectiveDamage);
                if (lifePointsLeft > 0) {
                    info("Life points left: " + lifePointsLeft);
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
                .mapToInt(ProtectionItem::getProtection)
                .sum();
    }

    public boolean isAlive() {
        return lifePointsLeft > 0;
    }

    public Optional<BodyPart> hitBodyPart() {
        int random = randomUtil.random(1, 100);
        int offset = 0;
        for (BodyPart bodyPart : BodyPart.values()) {
            if (offset + bodyPart.getHitProbability() >= random) {
                return Optional.of(bodyPart);
            } else {
                offset += bodyPart.getHitProbability();
            }
        }
        return Optional.empty();
    }

    private void info(String s) {
        System.out.println(name + " (" + creatureType + ") : " + s);
    }

}
