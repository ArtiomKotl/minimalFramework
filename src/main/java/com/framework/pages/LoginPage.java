package com.framework.pages;

import com.framework.models.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage<LoginPage> {

    // Селекторы как константы
    private static final String USERNAME_INPUT = "#email";
    private static final String PASSWORD_INPUT = "#password";
    private static final String LOGIN_BUTTON = "//button[text()='Войти']";
    private static final String ERROR_MESSAGE = ".error-message";
    private static final String REMEMBER_ME = "#remember";

    @Override
    protected String getUrl() {
        return "/login";
    }

    @Override
    protected String getPageLoadedElement() {
        return USERNAME_INPUT;
    }

    @Step("Ввести логин: {username}")
    public LoginPage enterUsername(String username) {
        $(USERNAME_INPUT).setValue(username);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        $(PASSWORD_INPUT).setValue(password);
        return this;
    }

    @Step("Нажать кнопку входа")
    public LoginPage clickLoginButton() {
        $x(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Выполнить вход с учетными данными: {username}/{password}")
    public LoginPage loginAs(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Step("Выполнить вход с пользователем")
    public LoginPage loginAs(User user) {
        return loginAs(user.getUsername(), user.getPassword());
    }

    @Step("Отметить чекбокс 'Запомнить меня'")
    public LoginPage checkRememberMe() {
        $(REMEMBER_ME).click();
        return this;
    }

    @Step("Проверить сообщение об ошибке")
    public String getErrorMessage() {
        return $(ERROR_MESSAGE).shouldBe(visible).getText();
    }

    @Step("Проверить, что отображается ошибка: {expectedError}")
    public LoginPage shouldHaveError(String expectedError) {
        $(ERROR_MESSAGE).shouldHave(text(expectedError));
        return this;
    }
}
