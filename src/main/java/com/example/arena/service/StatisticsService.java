package com.example.arena.service;

import com.example.arena.model.AttackResult;
import com.example.arena.model.BodyPart;
import com.example.arena.model.Creature;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticsService {

    String getStatistics(Map<Creature, List<AttackResult>> attacks) {
        return getHitBodyPartsStats(attacks) + "\n" + getStrongestHit(attacks);
    }

    private String getHitBodyPartsStats(Map<Creature, List<AttackResult>>
                                                attacks) {
        Map<BodyPart, Integer> hitBodyParts = new TreeMap<>();
        for (List<AttackResult> l : attacks.values()) {
            for (AttackResult attack : l) {
                BodyPart hitBodyPart = attack.getHitBodyPart();
                if (hitBodyPart != null) {
                    Integer hits = hitBodyParts.get(hitBodyPart);
                    if (hits == null) {
                        hitBodyParts.put(hitBodyPart, 1);
                    } else {
                        hitBodyParts.put(hitBodyPart, hits + 1);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Hit body parts statistics: " + hitBodyParts);

        BodyPart mostHit = null;
        int hits = 0;
        for (Map.Entry<BodyPart, Integer> entry : hitBodyParts.entrySet()) {
            if (entry.getValue() > hits) {
                mostHit = entry.getKey();
                hits = entry.getValue();
            }
        }
        sb.append("Body part hit most often: " + mostHit + ". Hits: " + hits);

        return sb.toString();
    }

    private String getStrongestHit(Map<Creature, List<AttackResult>> attacks) {
        int strongestHit = 0;
        Creature strongestHitter = null;
        for (Map.Entry<Creature, List<AttackResult>> entry : attacks.entrySet()) {
            for (AttackResult attack : entry.getValue()) {
                int potentialDamage = attack.getPotentialDamage();
                if (potentialDamage > strongestHit) {
                    strongestHit = potentialDamage;
                    strongestHitter = entry.getKey();
                }
            }
        }
        return ("Strongest hit (by potential damage): " + strongestHit + " by " + strongestHitter.getName());
    }
}
