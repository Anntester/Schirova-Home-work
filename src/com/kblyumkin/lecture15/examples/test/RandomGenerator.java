package com.kblyumkin.lecture15.examples.test;

import com.kblyumkin.lecture15.examples.jdbc.beans.UserType;

import java.util.Random;

import static com.kblyumkin.lecture15.examples.jdbc.beans.UserType.*;

public class RandomGenerator {

    public static String getRandomString() {
        Random random = new Random();
        int length = random.nextInt(5) + 3;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) ((random.nextInt(26) + 65) + (random.nextInt(2) * 32)) ;
        }
        return String.valueOf(result);
    }

    public static UserType getRandomUserType() {
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                return ADMIN;
            case 1:
                return USER;
            case 2:
                return EMPLOYEE;
            default:
                return null;
        }
    }
}
