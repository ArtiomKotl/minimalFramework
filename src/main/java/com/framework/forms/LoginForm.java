package com.framework.forms;

import com.codeborne.selenide.SelenideElement;
import com.framework.forms.form.UIform;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginForm implements UIform {


    public SelenideElement getUserNameInput() {
        return $("#email");
    }


    public SelenideElement getPasswordInput() {
        return $("#password");
    }


    public SelenideElement getLoginButton() {
        return $x("//button[text()='Войти']");
    }


    public SelenideElement getErrorMessage() {
        return $(".error-message");
    }


    public SelenideElement getRememberMe() {
        return $("#remember");
    }
}
