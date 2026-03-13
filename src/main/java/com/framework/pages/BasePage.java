package com.framework.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage<T extends BasePage<T>> {

    public T openPage() {
        open(getUrl());
        return (T) this;
    }

    protected abstract String getUrl();

    public T waitForPageLoaded() {
        $(getPageLoadedElement()).shouldBe(visible);
        return (T) this;
    }

    protected abstract SelenideElement getPageLoadedElement();

    public T addCookie(String name, String value) {
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(name, value));
        return (T) this;
    }

    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }
}
