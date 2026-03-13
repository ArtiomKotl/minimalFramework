package com.framework.forms;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginForm implements LoginFormInterface{
    public final SelenideElement userNameInput = $("#email");

    public final SelenideElement passwordInput = $("#password");
    public final SelenideElement loginButton = $x("//button[text()='Войти']");
    public final SelenideElement errorMessage = $(".error-message");
    public final SelenideElement rememberMe = $("#remember");

    @Override
    public SelenideElement getUserNameInput() {
        return $("#email");
    }

    @Override
    public SelenideElement getPasswordInput() {
        return $("#password");
    }

    @Override
    public SelenideElement getLoginButton() {
        return $x("//button[text()='Войти']");
    }

    @Override
    public SelenideElement getErrorMessage() {
        return $(".error-message");
    }

    @Override
    public SelenideElement getRememberMe() {
        return $("#remember");
    }
}
