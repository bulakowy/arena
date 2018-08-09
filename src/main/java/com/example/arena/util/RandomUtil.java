package com.example.arena.util;

import com.github.javafaker.Faker;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUtil {

    private static Faker faker = new Faker();
    private static Set<String> names = new HashSet<>();

    public static int random(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static String randomName() {
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
