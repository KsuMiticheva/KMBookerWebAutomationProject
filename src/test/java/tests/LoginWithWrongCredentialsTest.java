package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredentialsTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void loginWithWrongCredentialsTest() {
        loginPage.login("invalidLogin", "invalidPassword");

        assertTrue(loginPage.isInvalidCredentialsMessagePresent(), "Error message had not appeared");

        String expectedErrorMessage = "Пользователь с таким телефоном, почтой или логином не найден. Проверьте данные и попробуйте снова.";
        String actualErrorMessage = loginPage.getInvalidCredentialsErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Error message text does not match");

    }
}
