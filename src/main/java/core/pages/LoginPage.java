package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("[data-test-id='login-phone-email']");
    private SelenideElement passwordField = $("[data-test-id='login-password']");
    private SelenideElement loginButton = $("[data-test-id='login-submit-btn']");
    private SelenideElement loginByQr = $("[data-test-id='tab-qr']");
    private SelenideElement accessRecovery = $("[data-test-id='forgot-password-link']");
//    This is just to train XPath, better version would be css $("[id='hero-register-btn']")
    private SelenideElement registerButton = $x("//div[@id='hero-buttons']//button[@id='hero-register-btn']");
    /* Disabled as social login is not available in the sandbox
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement mailRuButton = $("[data-l='t,mailru']");
    private SelenideElement yandexButton = $("[data-l='t,yandex']");
    */

//    No specific error message for cases whe no login or password entered; variable disabled
//    private SelenideElement errorMessage = $("[data-test-id='login-error']");
    private SelenideElement missingCredentials = $x("//form[@id='loginForm']//div[contains(text(), 'Введите телефон, email или логин и пароль.')]");
    private SelenideElement invalidCredentials = $x("//form[@id='loginForm']//div[contains(text(), 'Пользователь с таким телефоном, почтой или логином не найден.')]");

    private SelenideElement recoveryButton = $("[data-test-id='lockout-recover-btn']");

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
        /* Disabled as social login is not available yet
        vkButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
        */
    }

    @Step("Check that login error message appears on entry with no credentials at all")
    public boolean isErrorMessagePresent() {
        return missingCredentials.shouldBe(visible).exists();
    }

    @Step("Check that missing username error message appears")
    public boolean isMissingUsernameMessagePresent() {
        return missingCredentials.shouldBe(visible).exists();
    }

    @Step("Check that missing password error message appears")
    public boolean isMissingPasswordMessagePresent() {
        return missingCredentials.shouldBe(visible).exists();
    }

    @Step("Check that invalid credentials error message appears")
    public boolean isInvalidCredentialsMessagePresent() {
        return invalidCredentials.shouldBe(visible).exists();
    }

    @Step("Obtain missing credentials error text")
    public String getErrorMessageText() {
        return missingCredentials.shouldBe(visible).getText();
    }

    @Step("Obtain missing username error text")
    public String getMissingUsernameErrorMessage() {
        return missingCredentials.shouldBe(visible).getText();
    }

    @Step("Obtain missing password error text")
    public String getMissingPasswordErrorMessage() {
        return missingCredentials.shouldBe(visible).getText();
    }

    @Step("Obtain invalid credentials error text")
    public String getInvalidCredentialsErrorMessage() {
        return invalidCredentials.shouldBe(visible).getText();
    }

    @Step("Try to login with no credentials entered")
    public void loginWithNoCredentials() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible).click();
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

    @Step("Forgot password - go to recovery page by link")
    public void openPasswordRecoveryPage() {
        accessRecovery.shouldBe(visible).click();
    }

    @Step("Open registration page")
    public void openRegistrationPage() {
        registerButton.shouldBe(visible).click();
    }

    /* Disabled as VK entry is not available yet
    @Step("Enter using VK")
    public void enterByVK() {
        vkButton.shouldBe(visible).click();
    }
    */

    /* Disabled as Mail.ru entry is not available yet
    @Step("Enter using Mail.ru")
    public void enterByMailRu() {
        mailRuButton.shouldBe(visible).click();
    }
    */

   /* Disabled as Yandex entry is not available yet
   @Step("Enter using Yandex")
    public void enterByYandex() {
        yandexButton.shouldBe(visible).click();
    }
    */

    @Step("Open entry by QR screen")
    public void enterByQr() {
        loginByQr.shouldBe(visible).click();
    }

    @Step("Go to recovery page by button")
    public void goToRecoveryPage() {
        recoveryButton.shouldBe(visible).click();
    }

    @Step("Just click login button")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }
}
