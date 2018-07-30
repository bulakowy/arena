package com.example.arena;

import java.util.Random;

public class RandomUtil {

    static int random(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
