package com.wk.demozh.mobiluialfa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutorizationAlfa {

    public WebDriver appiumDriver;

    public AutorizationAlfa(WebDriver appiumDriver){
        PageFactory.initElements(appiumDriver, this);
        this.appiumDriver = appiumDriver;
    }

    @FindBy(id = "com.alfabank.qapp:id/etUsername")
    public WebElement etLogin;

    @FindBy(id = "com.alfabank.qapp:id/etPassword")
    public WebElement etPassword;

    @FindBy(xpath = "//*[@class='android.widget.Button']")
    public WebElement btnConfirm;

    @FindBy(id = "com.alfabank.qapp:id/tvError")
    public WebElement tvError;

    private static final int TIME_WAIT = 10;

    public void enterTextLogin(String text) {
        BasePage.waitForElementAndSendKeys(appiumDriver, etLogin, text, TIME_WAIT);
    }

    public void enterTextPassword(String text) {
        BasePage.waitForElementAndSendKeys(appiumDriver, etPassword, text, TIME_WAIT);
    }

    public void clickConfirm() {
        BasePage.waitForElementAndClick(appiumDriver, btnConfirm, TIME_WAIT);
    }

    public boolean presentError() {
        return BasePage.waitForElementToBePresent(appiumDriver, tvError, TIME_WAIT);
    }


}
