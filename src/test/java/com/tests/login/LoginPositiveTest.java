package com.tests.login;

import com.framework.forms.LoginForm;
import com.framework.forms.form.UIform;
import com.framework.models.UserDto;
import com.framework.models.UserModel;
import com.framework.pages.DashboardPage;
import com.framework.pages.LoginPage;
import com.tests.base.BaseUiTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Авторизация")
@Feature("Позитивные сценарии")
@DisplayName("Тесты успешной авторизации")
public class LoginPositiveTest extends BaseUiTest {


//    public LoginPositiveTest(LoginForm loginForm) {
//        super(loginForm);
//    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Tag("smoke")
    @DisplayName("Успешный вход с валидными учетными данными")
    @Description("Проверка, что пользователь может войти с правильным логином/паролем")
    public void shouldLoginWithValidCredentials() {
        // Arrange
        UserDto validUser = UserDto.builder()
                .username("admin")
                .password("admin123")
                .build();

       // System.out.println();


        loginPage.enterUsername(validUser.getUsername())
        .enterPassword(validUser.getPassword())
        .clickLoginButton();



        System.out.println();

        // Act
//        DashboardPage dashboardPage = loginPage.loginAs(validUser);
//
//        // Assert
//        assertThat(dashboardPage.isUserLoggedIn()).isTrue();
//        dashboardPage.shouldHaveWelcomeMessage(validUser.getUsername());
    }

//    @Test
//    @Severity(SeverityLevel.NORMAL)
//    @Tag("regression")
//    @DisplayName("Успешный вход с сохранением сессии")
//    public void shouldRememberUserSession() {
//        User user = User.createRandomUser(); // TODO: создать через API
//
//        loginPage.loginAs(user)
//                .shouldBeLoaded();
//
//        // Проверяем, что куки установлены
//        assertThat(loginPage.getCurrentUrl()).contains("/dashboard");
//    }
}
