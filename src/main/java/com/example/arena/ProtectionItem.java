package com.example.arena;

import java.util.Arrays;
import java.util.List;

import static com.example.arena.BodyPart.*;
import static com.example.arena.BodyPart.RIGHT_ARM;

public enum ProtectionItem {
    HELM(Arrays.asList(HEAD), 0, 2),
    ARMOUR(Arrays.asList(TRUNK), 0, 4),
    GLOVES(Arrays.asList(LEFT_ARM, RIGHT_ARM), 0, 3),
    SHINGUARDS(Arrays.asList(LEFT_LEG, RIGHT_LEG), 0, 2),
    SHIELD(Arrays.asList(BodyPart.values()), 0, 1);

    private List<BodyPart> protectedParts;
    private int minProtection;
    private int maxProtection;

    ProtectionItem(List<BodyPart> protectedParts, int minProtection, int maxProtection) {
        this.protectedParts = protectedParts;
        this.minProtection = minProtection;
        this.maxProtection = maxProtection;
    }

    public List<BodyPart> getProtectedParts() {
        return protectedParts;
    }

    public int getMinProtection() {
        return minProtection;
    }

    public int getMaxProtection() {
        return maxProtection;
    }
}
