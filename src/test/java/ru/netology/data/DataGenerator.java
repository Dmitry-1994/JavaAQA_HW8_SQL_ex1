package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    private static final Faker faker = new Faker(new Locale("en"));

    public static String getRandomLogin() {
        return faker.name().username();
    }

    public static String getRandomPass() {
        return faker.internet().password();
    }
}
