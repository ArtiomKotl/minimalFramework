package com.framework.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;



public class SelenideConfig {
    public interface FrameworkConfig extends Config {
        @Key("browser")
        @Config.DefaultValue("chrome")
        String browser();

        @Key("baseUrl")
        @DefaultValue("http://83.222.21.30:5173")
        String baseUrl();

        @Key("timeout")
        @DefaultValue("10000")
        int timeout();

        @Key("headless")
        @DefaultValue("false")
        boolean headless();

        @Key("remote")
        String remote();
    }

    public static void init() {
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

        Configuration.browser = config.browser();
        Configuration.baseUrl = config.baseUrl();
        Configuration.timeout = config.timeout();
        Configuration.headless = config.headless();

        if (config.remote() != null) {
            Configuration.remote = config.remote();
        }

        // Логирование для Allure
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
