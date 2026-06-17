package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryPage extends BasePage {
    private SelenideElement recoveryPhoneButton = $("[data-test-id='recovery-phone-btn']");
    private SelenideElement recoveryEmailButton = $("[data-test-id='recovery-email-btn']");
    private SelenideElement goToSupportButton = $("[data-test-id='support-contact-btn']");

    {
        verifyPageElements();
    }

    @Step("Check that necessary page elements are available")
    private void verifyPageElements() {
        recoveryPhoneButton.shouldBe(visible);
        recoveryEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("Go to recovery by phone number")
    public void recoveryByPhone() {
        recoveryPhoneButton.shouldBe(visible).click();
    }

    @Step("Go to recovery by email address")
    public void recoveryByEmail() {
        recoveryEmailButton.shouldBe(visible).click();
    }

    @Step("Refer to support service")
    public void referToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }
}
