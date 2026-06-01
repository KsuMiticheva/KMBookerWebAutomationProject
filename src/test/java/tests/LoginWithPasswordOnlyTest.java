package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithPasswordOnlyTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void testLoginWithPasswordOnly() {
        loginPage.loginByPasswordOnly("test_pass");

        assertTrue(loginPage.isMissingUsernameMessagePresent());

        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPage.getMissingUsernameErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Received error message text does not match");
    }
}
