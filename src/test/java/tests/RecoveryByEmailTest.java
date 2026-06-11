package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.RecoveryEmailPage;
import core.pages.RecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RecoveryByEmailTest extends BaseTest {
    private static LoginPage loginPage;
    private static RecoveryPage recoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();
    }

    @Test
    public void testRecoveryByEmail() {
        loginPage.login("incorrect_username", "incorrect_pass");

        for (int i=0; i<2; i++) {
            loginPage.loginByPasswordOnly("z");
        }

        loginPage.goToRecoveryPage();
        recoveryPage = new RecoveryPage();

        recoveryPage.recoveryByEmail();
        new RecoveryEmailPage();
    }
}
