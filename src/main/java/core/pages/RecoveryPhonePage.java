package core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryPhonePage extends BasePage {
    private SelenideElement phoneEntryField = $("[data-test-id='phone-input']");
    private SelenideElement countrySelectDropdown = $("[data-test-id='country-select']");
    private SelenideElement getCodeButton = $("[data-test-id='phone-submit-btn']");

    {
        verifyPageElements();
    }

    @Step("Check that all elements are present")
    private void verifyPageElements() {
        phoneEntryField.shouldBe(visible);
        countrySelectDropdown.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Set phone number")
    public void setPhoneNumber(String phone) {
        phoneEntryField.setValue(phone);
    }

    @Step("Select country from the list by name: {countryName}")
    public String selectCountry(String countryName) {
        countrySelectDropdown.click();
        SelenideElement countryItem = $x(String.format("//option[text()='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.attr("value");
        countryItem.click();
        return countryCode;
    };

    @Step("Submit phone number")
    public void submitPhoneNumber() {
        getCodeButton.click();
    }
}
