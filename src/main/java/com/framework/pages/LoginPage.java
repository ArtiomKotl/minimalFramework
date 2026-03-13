package com.framework.pages;

import com.codeborne.selenide.SelenideElement;
import com.framework.forms.LoginForm;
import com.framework.forms.LoginFormInterface;
import com.framework.models.UserDto;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage<LoginPage> {

    // Селекторы как константы


    private final LoginFormInterface loginForm;

    public LoginPage(LoginFormInterface loginForm){
        this.loginForm = loginForm;
    }

    @Override
    protected String getUrl() {
        return "/login";
    }

    @Override
    protected SelenideElement getPageLoadedElement() {
        return loginForm.getUserNameInput();
    }

    @Step("Ввести логин: {username}")
    public LoginPage enterUsername(String username) {
        loginForm.getUserNameInput().setValue(username);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        loginForm.getPasswordInput().setValue(password);
        return this;
    }

    @Step("Нажать кнопку входа")
    public LoginPage clickLoginButton() {
        loginForm.getLoginButton().click();
        return this;
    }

    @Step("Выполнить вход с учетными данными: {username}/{password}")
    public LoginPage loginAs(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Step("Выполнить вход с пользователем")
    public LoginPage loginAs(UserDto user) {
        return loginAs(user.getUsername(), user.getPassword());
    }

    @Step("Отметить чекбокс 'Запомнить меня'")
    public LoginPage checkRememberMe() {
        loginForm.getRememberMe().click();
        return this;
    }

    @Step("Проверить сообщение об ошибке")
    public String getErrorMessage() {
        return loginForm.getErrorMessage().shouldBe(visible).getText();
    }

    @Step("Проверить, что отображается ошибка: {expectedError}")
    public LoginPage shouldHaveError(String expectedError) {
        loginForm.getErrorMessage().shouldHave(text(expectedError));
        return this;
    }
}
