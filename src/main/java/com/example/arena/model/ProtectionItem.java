package com.example.arena.model;

import com.example.arena.util.RandomUtil;

import java.util.Arrays;
import java.util.List;

import static com.example.arena.model.BodyPart.*;
import static com.example.arena.model.BodyPart.RIGHT_ARM;

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

    public int getProtection() {
        return RandomUtil.random(minProtection, maxProtection);
    }
}
