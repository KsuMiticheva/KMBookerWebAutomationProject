package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("[data-test-id='enter-action']");
    private SelenideElement loginByQr = $("[label='Войти по QR-коду']");
    private SelenideElement accessRecovery = $("[aria-label='Не получается войти?']");
    private SelenideElement registerButton = $x("//button//span[text()='Зарегистрироваться']");
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement mailRuButton = $("[data-l='t,mailru']");
    private SelenideElement yandexButton = $("[data-l='t,yandex']");

    private SelenideElement errorMessage = $x("//span[contains(text(), 'Неправильно указан логин и/или пароль')]");
    private SelenideElement missingUsername = $x("//span[contains(text(), 'Введите логин')]");
    private SelenideElement missingPassword = $x("//span[contains(text(), 'Введите пароль')]");

    {
        verifyPageElements();
    }

    @Step("Check visibility for all page elements")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        loginByQr.shouldBe(visible);
        accessRecovery.shouldBe(visible);
        registerButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }

    @Step("Check that login error message appears")
    public boolean isErrorMessagePresent() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Check that missing username error message appears")
    public boolean isMissingUsernameMessagePresent() {
        return missingUsername.shouldBe(visible).exists();
    }

    @Step("Check that missing password error message appears")
    public boolean isMissingPasswordMessagePresent() {
        return missingPassword.shouldBe(visible).exists();
    }

    @Step("Obtain login error text")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Obtain missing username error text")
    public String getMissingUsernameErrorMessage() {
        return missingUsername.shouldBe(visible).getText();
    }

    @Step("Obtain missing password error text")
    public String getMissingPasswordErrorMessage() {
        return missingPassword.shouldBe(visible).getText();
    }

    @Step("Enter the site with login details: {username} and {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Try to enter the site with username only")
    public void loginByUsernameOnly(String username){
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Try to enter the site with password only")
    public void loginByPasswordOnly(String password){
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Open password recovery page")
    public void openPasswordRecoveryPage() {
        accessRecovery.shouldBe(visible).click();
    }

    @Step("Open registration page")
    public void openRegistrationPage() {
        registerButton.shouldBe(visible).click();
    }

    @Step("Enter using VK")
    public void enterByVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Enter using Mail.ru")
    public void enterByMailRu() {
        mailRuButton.shouldBe(visible).click();
    }

    @Step("Enter using Yandex")
    public void enterByYandex() {
        yandexButton.shouldBe(visible).click();
    }

    @Step("Open entry by QR screen")
    public void enterByQr() {
        loginByQr.shouldBe(visible).click();
    }




}
