package com.example.arena;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.example.arena.*")
public class CreatureTest {

    @Test
    public void dodgeShouldReturnProperEffectiveDamageWhenHit() {
        // given
        int potentialDamage = 10;
        int endurance = 5;

        PowerMockito.mockStatic(RandomUtil.class);
        Mockito.when(RandomUtil.random(anyInt(), anyInt())).thenReturn(10);

        AttackResult attackResult = new AttackResult(BodyPart.HEAD, 1,
                potentialDamage);
        Creature c = new Human(1, 1, 1, endurance, 10, Collections.emptyList());

        // when
        AttackResult ar = c.dodge(attackResult);

        // then
        assertEquals(potentialDamage - endurance, ar.getEffectiveDamage());
    }

    @Test
    public void dodgeShouldSubtractEffectiveDamageFromLifePoints() {
        // given
        int potentialDamage = 10;
        int endurance = 5;
        int lifePoints = 10;

        PowerMockito.mockStatic(RandomUtil.class);
        Mockito.when(RandomUtil.random(anyInt(), anyInt())).thenReturn(10);

        AttackResult attackResult = new AttackResult(BodyPart.HEAD, 1,
                potentialDamage);
        Creature c = new Human(1, 1, 1, endurance, lifePoints, Collections.emptyList());

        // when
        AttackResult ar = c.dodge(attackResult);

        // then
        assertTrue(lifePoints - (potentialDamage - endurance) == c.getLifePoints());
    }

    @Test
    public void dodgeSuccesful() {
        // given
        int potentialDamage = 10;
        int lifePoints = 10;
        int randomInt = 4;
        int defence = 5;

        PowerMockito.mockStatic(RandomUtil.class);
        Mockito.when(RandomUtil.random(anyInt(), anyInt())).thenReturn(randomInt);

        AttackResult attackResult = new AttackResult(BodyPart.HEAD, 1,
                potentialDamage);
        Creature c = new Human(1, 1, defence, 1, lifePoints, Collections.emptyList());

        // when
        AttackResult ar = c.dodge(attackResult);

        // then
        assertTrue(lifePoints == c.getLifePoints());
        assertTrue(ar.getEffectiveDamage() == 0);
    }
}