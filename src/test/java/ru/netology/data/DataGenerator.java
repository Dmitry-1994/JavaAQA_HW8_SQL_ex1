package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    private static final Faker faker = new Faker(new Locale("en"));

    private static String getRandomLogin() {
        return faker.name().username();
    }

    private static String getRandomPass() {
        return faker.internet().password();
    }

    public static loginInfo getRandomUser() {
        return new loginInfo(getRandomLogin(), getRandomPass());
    }

    public static loginInfo getTestUser() {
        return new loginInfo("vasya", "qwerty123");
    }

    public static VerificationCode getRandomVerCode() {
        return new VerificationCode(faker.numerify("######"));
    }

    @Value
    public static class loginInfo {
        String login;
        String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VerificationCode {
        String code;
    }
}