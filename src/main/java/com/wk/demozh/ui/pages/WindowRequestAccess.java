package com.wk.demozh.ui.pages;

import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowRequestAccess {
    private WebDriver driver;

    public WindowRequestAccess(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div[2]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboCustomersRequired;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div[3]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboServiceRequired;


    @FindBy(xpath = "//div[@id='Info-tabpanel']//span[normalize-space(.) = 'Request by Services Group(s)']") // /div/div/button[2]
    private WebElement TabGetByServicesGroups;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div[2]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboServicesGroups;


    @FindBy(id = "Description-tab")
    private WebElement TabDescription;

    @FindBy(xpath = "//div[@id='Description-tabpanel']//textarea[@aria-invalid='false' and @rows='5']")
    private WebElement textareaJustification;


    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Cancel']")
    private WebElement buttonCansel;

    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Request']")
    private WebElement buttonRequest;


    public void choiceServiceRequiredThroughCustomers(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboCustomersRequired,  pozList, null, true);
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboServiceRequired,  pozList, null, true);
    }

    public void choiceServiceRequiredThroughServicesGroups() {
        BaseWebDriver.clickUntilSecondElementVisibility(driver, TabGetByServicesGroups, openComboServicesGroups, null, true);
    }

    public void choiceServicesGroups(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboServicesGroups,  pozList, null, true);
    }

    public void openTabDescriptionAndEnterTextInJustification(String text) {
        BaseWebDriver.clickUntilSecondElementVisibility(driver, TabDescription, textareaJustification, null, false);
        BaseWebDriver.inputText(textareaJustification, text);
    }

    public void clickButtonRequest() {
        BaseWebDriver.clickElementWaitDisappear(driver, buttonRequest,  buttonCansel);
    }


}
