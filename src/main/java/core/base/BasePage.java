package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {
    protected SelenideElement headerLogo = $("[data-test-id='logo-icon']");
    protected SelenideElement searchField = $("[id='search-input']");
//    Services not yet actionable in the sandbox, variable disabled until Services become available
//    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    protected SelenideElement cookiesAccept = $("[data-test-id='cookie-accept-btn']");
    protected SelenideElement searchResultPane = $("[data-test-id='search-results']");

    @Step("Return to main page by clicking on logo")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    /* Method disabled as search option works differently in the sandbox
    @Step("Search within the site by {query}")
    public void search(String query) {
        searchField.shouldBe(visible).click();
        searchField.setValue(query).pressEnter();
    }*/

    @Step("Get search results pane by entering {query}")
    public void getSearchResults(String query) {
        searchField.shouldBe(visible).click();
        searchField.setValue(query);
        searchResultPane.shouldBe(visible);
    }

    @Step("Select a result from the search pane list by {option}")
    public void selectResultFromLIst(String option) {
        SelenideElement listItem = $x(String.format("//span[@class='search-result-name'][text()='%s']", option));
        listItem.scrollTo();
        listItem.click();
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
