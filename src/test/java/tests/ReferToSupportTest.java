package tests;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.RecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ReferToSupportTest extends BaseTest {
    private static LoginPage loginPage;
    private static RecoveryPage recoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();
    }

    @Test
    public void testReferToSupport() {
        loginPage.goToRecoveryPageByLink();
        recoveryPage = new RecoveryPage();

        recoveryPage.referToSupport();
        recoveryPage.closeChat();
        recoveryPage.checkChatClosed();
    }
}
