package com.wk.demozh.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wk.demozh.ui.webdriver.BaseWebDriver;

public class AutorizationLoginPassword {
    private WebDriver driver;

    public AutorizationLoginPassword(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "username")
    private WebElement inputUserLogin;

    @FindBy(name = "password")
    private WebElement inputUserPassword;

    @FindBy(name = "submit")
    private WebElement buttonSubmit;

    @FindBy(className = "ErrorBox")
    private WebElement errorBox;

    @FindBy(linkText = "Заполните это поле.")
    private WebElement emptyBox;

    public void enterTextUserLogin(String text) {
        BaseWebDriver.inputText(inputUserLogin, text);
    }

    public void enterTextUserPassword(String text) {
        BaseWebDriver.inputText(inputUserPassword, text);
    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }

    public boolean checkingPresenceErrorline() {
        String errorBoxText = errorBox.getText().trim();
        String nameError = "User or password is incorrect.";
        return (errorBoxText.equals(nameError));
    }

    public boolean waitPageAutorizationLoginPassword() {
        return BaseWebDriver.waitWebElementInPage(driver, By.name("username"));
    }

}
