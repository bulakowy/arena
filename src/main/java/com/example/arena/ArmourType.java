package com.example.arena;

import java.util.Arrays;
import java.util.Collection;

public enum ArmourType {

    HELM(0, 2, Arrays.asList(BodyPart.HEAD)),
    ARMOUR(0, 4, Arrays.asList(BodyPart.TRUNK)),
    GLOVES(0, 3, Arrays.asList(BodyPart.LEFT_ARM, BodyPart.RIGHT_ARM)),
    SHINGUARDS(0, 2, Arrays.asList(BodyPart.LEFT_LEG, BodyPart.RIGHT_LEG)),
    SHIELD(0, 1, Arrays.asList(BodyPart.values())),;

    private int minProtection;
    private int maxProtection;
    private Collection<BodyPart> protectedBodyParts;

    ArmourType(int minProtection, int maxProtection, Collection<BodyPart> protectedBodyParts) {
        this.minProtection = minProtection;
        this.maxProtection = maxProtection;
        this.protectedBodyParts = protectedBodyParts;
    }
}
