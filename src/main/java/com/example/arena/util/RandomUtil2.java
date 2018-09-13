package com.example.arena.util;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component("dumbRandom")
@Primary
public class RandomUtil2 implements IRandomUtil {

    private static Faker faker = new Faker();
    private static Set<String> names = new HashSet<>();

    @Override
    public int random(int min, int max) {
        return 1;
    }

    @Override
    public String randomName() {
        return "Wiesiek";
    }

}
