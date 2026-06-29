package tests;

import core.base.BaseTest;
import core.pages.GroupPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitGroupPageTest extends BaseTest {
    private static LoginPage loginPage;
    private static GroupPage groupPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();
    }

    @Test
    public void testVisitGroupPage() {
        String testGroupName = "Тестировщик автоматизации";

        loginPage.getSearchResults("тестировщик");
        loginPage.selectResultFromLIst(testGroupName);

        groupPage = new GroupPage();

        assertEquals(testGroupName, groupPage.checkGroupName(), "Group name on the page does not match the expectation");

        groupPage.goBack();
    }
}
