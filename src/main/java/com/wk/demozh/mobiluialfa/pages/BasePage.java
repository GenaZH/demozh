package com.wk.demozh.mobiluialfa.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage {

    public static WebDriver appiumDriver;
    private static final int TIME_WAIT_APP = 1;

    public BasePage(WebDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    private static void fluentWait(WebDriver appiumDriver, WebElement element, long timeoutInSeconds) {
        Wait wait = new FluentWait(appiumDriver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(TIME_WAIT_APP))
                .ignoring(java.util.NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));  // visibilityOfElementLocated
    }

    public static boolean waitForElementToBePresent(WebDriver appiumDriver, WebElement element, long timeoutInSeconds) {
        Wait wait = new FluentWait(appiumDriver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(TIME_WAIT_APP))
                .ignoring(java.util.NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.visibilityOf(element));  // visibilityOfElementLocated
        return element.isDisplayed();
    }

    public static String waitForElementAndGetText(WebDriver appiumDriver, WebElement element, long timeoutInSeconds) {
        waitForElementToBePresent(appiumDriver, element, timeoutInSeconds);
        return element.getText();
    }

    public static WebElement waitForElementAndClick(WebDriver appiumDriver, WebElement element, long timeoutInSeconds) {
        try {
            fluentWait(appiumDriver, element, timeoutInSeconds);
            element.click();
        } catch (ElementNotInteractableException e){
        }
        return element;
    }
    public static void inputText(WebElement element, String text) {
        element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), text);
    }
    public static WebElement waitForElementAndSendKeys(WebDriver appiumDriver, WebElement element, String value, long timeoutInSeconds) {
        try {
            fluentWait(appiumDriver, element, timeoutInSeconds);
            element.click();
        } catch (ElementNotInteractableException e){
        }
        element.sendKeys(value);
        return element;
    }


}
