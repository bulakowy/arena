package com.example.arena.service;

import com.example.arena.model.Creature;
import com.example.arena.model.CreaturePair;
import com.example.arena.service.CreatureFactory;
import com.example.arena.service.FightService;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FightServiceTest {

    private FightService sut = new FightService();

    @Test(expected = NullPointerException.class)
    public void generateDistinctCreaturePairsThrowsNpeForNullInput() {
        sut.generateDistinctCreaturePairs(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateDistinctCreaturePairsThrowsIllegalArgumentExceptionForEmptyList() {
        sut.generateDistinctCreaturePairs(Collections.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateDistinctCreaturePairsThrowsIllegalArgumentExceptionForListOfSizeOne() {
        sut.generateDistinctCreaturePairs(Arrays.asList(randomCreature()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateDistinctCreaturePairsThrowsIllegalArgumentExceptionForListWithDuplicates() {
        Creature c = randomCreature();
        sut.generateDistinctCreaturePairs(Arrays.asList(c, c));
    }

    @Test
    public void generateDistinctCreaturePairs() {
        // given
        List<Creature> creatures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            creatures.add(randomCreature());
        }

        // when
        List<CreaturePair> pairs = sut.generateDistinctCreaturePairs(creatures);

        // then
        long expectedSize = CombinatoricsUtils.binomialCoefficient(10, 2);
        assertEquals(expectedSize, pairs.size());
        assertTrue(noDuplicates(pairs));
    }

    private boolean noDuplicates(List<CreaturePair> pairs) {
        Set<CreaturePair> noDuplicates = new HashSet<>();
        noDuplicates.addAll(pairs);
        return pairs.size() == noDuplicates.size();
    }

    private Creature randomCreature() {
        return new CreatureFactory().randomCreature();
    }
}
