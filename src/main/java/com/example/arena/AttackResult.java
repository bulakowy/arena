package com.example.arena;

public class AttackResult {

    private final BodyPart hitBodyPart;
    private final int attempts;
    private final int potentialDamage;
    private int effectiveDamage;

    public AttackResult(BodyPart hitBodyPart, int attempts, int potentialDamage) {
        this.hitBodyPart = hitBodyPart;
        this.attempts = attempts;
        this.potentialDamage = potentialDamage;
    }

    public BodyPart getHitBodyPart() {
        return hitBodyPart;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getPotentialDamage() {
        return potentialDamage;
    }

    public int getEffectiveDamage() {
        return effectiveDamage;
    }

    public void setEffectiveDamage(int effectiveDamage) {
        this.effectiveDamage = effectiveDamage;
    }
}
