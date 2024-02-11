package com.wk.demozh.ui.pages;

import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowGetAccess {
    private WebDriver driver;

    public WindowGetAccess(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='Info-tabpanel']//span[normalize-space(.) = 'Get by Customer(s)']") // /div/div/button[1]
    private WebElement TabGetByCustomers;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div[2]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboCustomers;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div[3]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboService;


    @FindBy(xpath = "//div[@id='Info-tabpanel']//span[normalize-space(.) = 'Get by Services Group(s)']") // /div/div/button[2]
    private WebElement TabGetByServicesGroups;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div[2]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboServicesGroups;


    @FindBy(id = "Description-tab")
    private WebElement TabDescription;

    @FindBy(xpath = "//div[@id='Description-tabpanel']//textarea[@aria-invalid='false' and @rows='5']")
    private WebElement textareaJustification;


    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Cancel']")
    private WebElement buttonCansel;

    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Get access']")
    private WebElement buttonGetAccess;


    public void choiceServicesThroughCustomers(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboCustomers,  pozList, null,  true);
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboService,  pozList, null, true);
    }

    public void clickTabGetByServicesGroups() {
        BaseWebDriver.clickUntilSecondElementVisibility(driver, TabGetByServicesGroups, openComboServicesGroups, null, true);
    }

    public void choiceServicesGroups(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboServicesGroups,  pozList, null, true);
    }

    public void openTabDescriptionAndEnterTextInJustification(String text) {
        BaseWebDriver.clickUntilSecondElementVisibility(driver, TabDescription, textareaJustification, null, false);
        BaseWebDriver.inputText(textareaJustification, text);
    }

    public void clickButtonGetAccess() {
        BaseWebDriver.clickElementWaitDisappear(driver, buttonGetAccess,  buttonCansel);
    }


}
