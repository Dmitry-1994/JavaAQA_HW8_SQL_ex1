package ru.netology.test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataGenerator.getRandomUser;
import static ru.netology.data.DataGenerator.getRandomVerCode;
import static ru.netology.data.SQLHelper.*;


public class LoginTest {
    LoginPage loginPage;
    DataGenerator.loginInfo loginInfo = DataGenerator.getTestUser();

    @BeforeEach
    void setUp() {
        loginPage = open("http://localhost:9999", LoginPage.class);
    }

    @AfterEach
    void clear() {
        clearAuthCodes();
    }

    @AfterAll
    static void clearAll() {
        clearDataBase();
    }

    @Test
    void successLoginWithTestData() {
        var VerPage = loginPage.validLogin(loginInfo);
        VerPage.validVer(getVerCode());
    }

    @Test
    void negativeLoginWithRandomData() {
        loginPage.noValidlogin(getRandomUser());
        loginPage.massageError("Ошибка! Неверно указан логин или пароль");
    }

    @Test
    void negativeWithInvalidVerCode() {
        var VerPage = loginPage.validLogin(loginInfo);
        VerPage.notValidVer(getRandomVerCode().getCode());
        VerPage.massageError("Ошибка! Неверно указан код! Попробуйте ещё раз.");
    }
}