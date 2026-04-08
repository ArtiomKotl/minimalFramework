package com.tests.base;

import com.codeborne.selenide.Selenide;
import com.framework.config.SelenideConfig;
import com.framework.forms.LoginForm;
import com.framework.forms.LoginFormInterface;
import com.framework.forms.form.UIform;
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
    protected LoginForm loginForm;

    /**
     * Конструктор по умолчанию - использует реальную форму
     */
    public BaseUiTest() {
        this(new LoginForm());
    }

    /**
     * Конструктор с параметром для внедрения зависимости
     * @param loginForm форма логина (может быть реальной или моком)
     */
    public BaseUiTest(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    @BeforeAll
    static void setUpAll() {
        SelenideConfig.init();
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        log.info("Начинаем тест: {}", testInfo.getDisplayName());
//        clearBrowserCookies();
//        clearBrowserLocalStorage();
        loginPage = new LoginPage(loginForm).openPage();
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        log.info("Тест завершен: {}", testInfo.getDisplayName());
        Selenide.closeWebDriver();
    }
}