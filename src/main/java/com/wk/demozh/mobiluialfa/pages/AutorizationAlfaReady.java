package com.wk.demozh.mobiluialfa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutorizationAlfaReady {

    private final WebDriver appiumDriver;
    public AutorizationAlfaReady(WebDriver appiumDriver){
        PageFactory.initElements(appiumDriver, this);
        this.appiumDriver = appiumDriver;
    }

    @FindBy(xpath = "//*[matches(@text, 'выполнен')]")
    private WebElement textViewReady;

    public boolean AutorizationAlfaReady() {
        return BasePage.waitForElementToBePresent(appiumDriver, textViewReady, 10);
    }


}