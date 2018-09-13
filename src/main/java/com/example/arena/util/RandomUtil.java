package com.example.arena.util;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component("trueRandom")
public class RandomUtil implements IRandomUtil {

    private static Faker faker = new Faker();
    private static Set<String> names = new HashSet<>();

    public int random(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public String randomName() {
        String name = null;
        while (name == null) {
            name = faker.name().firstName();
            if (names.contains(name)) {
                System.out.println("DUPLICATE: " + name);
                name = null;
            } else {
                names.add(name);
            }
        }
        return name;
    }

}
