package com.framework.forms;

import com.codeborne.selenide.SelenideElement;

/**
 * Интерфейс формы логина - абстракция, от которой будут зависеть другие классы
 */
public interface LoginFormInterface {
    SelenideElement getUserNameInput();
    SelenideElement getPasswordInput();
    SelenideElement getLoginButton();
    SelenideElement getErrorMessage();
    SelenideElement getRememberMe();
}