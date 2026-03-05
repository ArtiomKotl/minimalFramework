package com.tests.base;

import com.codeborne.selenide.Selenide;
import com.framework.config.SelenideConfig;
import com.framework.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;

public abstract class BaseUiTest {
    protected static final Logger log = LoggerFactory.getLogger(BaseUiTest.class);
    protected LoginPage loginPage;

    @BeforeAll
    static void setUpAll() {
        SelenideConfig.init();
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        log.info("Начинаем тест: {}", testInfo.getDisplayName());
//        clearBrowserCookies();
//        clearBrowserLocalStorage();
        loginPage = new LoginPage().openPage();
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        log.info("Тест завершен: {}", testInfo.getDisplayName());
        Selenide.closeWebDriver();
    }
}