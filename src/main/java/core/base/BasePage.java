package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected SelenideElement headerLogo = $("[data-test-id='logo-icon']");
    protected SelenideElement searchField = $("[id='search-input']");
//    Services not yet actionable in the sandbox, variable disabled until Services become available
//    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    protected SelenideElement cookiesAccept = $("[data-test-id='cookie-accept-btn']");

    @Step("Return to main page by clicking on logo")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    @Step("Search within the site by {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    /* Method disabled as Services button is not yet actionable in the sandbox
    @Step("Open VK Services")
    public void openVKServices() {
        vkServices.shouldBe(visible).click();
    }*/

    @Step("Accept all cookies at the site")
    public void acceptCookies() {
        cookiesAccept.shouldBe(visible).click();
    }
}
