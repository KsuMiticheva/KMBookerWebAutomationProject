package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.RecoveryPage;
import core.pages.RecoveryPhonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryByPhoneTest extends BaseTest {
    private static LoginPage loginPage;
    private static RecoveryPage recoveryPage;
    private static RecoveryPhonePage recoveryPhonePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();
    }

    @Test
    public void testRecoveryByPhone() {
        loginPage.login("invalid_user", "invalid_pass");

        for (int i=0; i<2; i++) {
            loginPage.loginByPasswordOnly("x");
        }

        loginPage.goToRecoveryPage();
        recoveryPage = new RecoveryPage();

        recoveryPage.recoveryByPhone();
        recoveryPhonePage = new RecoveryPhonePage();

        String countryCode = recoveryPhonePage.selectCountry("Греция");
        assertEquals("+30", countryCode, "Received code does not match");

        recoveryPhonePage.submitPhoneNumber();
    }
}
