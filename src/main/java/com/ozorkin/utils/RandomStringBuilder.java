package com.ozorkin.utils;

import java.util.Random;

public class RandomStringBuilder {

    private static final Random random = new Random();

    public static String createString() {
        StringBuilder sb = new StringBuilder();
        int stringLength = random.nextInt(1, 10);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < stringLength; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
