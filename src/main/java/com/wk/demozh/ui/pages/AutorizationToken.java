package com.wk.demozh.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wk.demozh.ui.webdriver.BaseWebDriver;

public class AutorizationToken {
    private WebDriver driver;

    public AutorizationToken(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "psw")
    private WebElement inputUserToken;

    @FindBy(name = "submitt")
    private WebElement buttonSubmitToken;

    public void enterTextUserToken(String text) {
        BaseWebDriver.inputText(inputUserToken, text);
    }

    public void clickButtonToken() {
        buttonSubmitToken.click();
    }

    public boolean waitPageAutorizationToken() {
        return BaseWebDriver.waitWebElementInPage(driver, By.id("psw"));
    }

}
