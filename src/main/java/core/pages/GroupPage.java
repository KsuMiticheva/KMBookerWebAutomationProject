package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage {
    private SelenideElement groupHeader = $("#group-name");
    private SelenideElement groupReference  = $(".group-slug");
    private SelenideElement membersCounter  = $("#members-count");
    private SelenideElement joinButton = $(".btn-primary");
    private SelenideElement returnButton = $(".btn-secondary");

    {
        verifyPageElements();
    }

    @Step("Check visibility for all page elements")
    private void verifyPageElements() {
        groupHeader.shouldBe(visible);
        groupReference.shouldBe(visible);
        membersCounter.shouldBe(visible);
        joinButton.shouldBe(visible);
        returnButton.shouldBe(visible);
    }

    @Step("Check group name")
    public String checkGroupName() {
        groupHeader.shouldBe(visible);
        String groupName = groupHeader.getText();
        return groupName;
    }

    @Step("Return to the previous page")
    public void goBack() {
        returnButton.shouldBe(visible).click();
    }
}
