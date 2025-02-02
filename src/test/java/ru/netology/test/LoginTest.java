package ru.netology.test;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.data.SQLHelper;

import java.sql.DriverManager;
import java.util.Locale;

import static ru.netology.data.DataGenerator.getRandomLogin;
import static ru.netology.data.DataGenerator.getRandomPass;

public class LoginTest {
    @BeforeEach
    public void setUp() {
        SQLHelper.addUser(getRandomLogin(), getRandomPass());
    }

    @Test
    @SneakyThrows
    public void returnCountUser() {

    }
}
