package com.wk.demozh.ui.pages;

import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsCustomer {
    private WebDriver driver;

    public WindowsCustomer(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(id = "free-solo-with-text-demo")
    private WebElement inputNameCustomer;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div/div[2]//input[@type='text']")
    private WebElement inputCountryCustomer;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div/div[3]//input[@type='text']")
    private WebElement inputCityCustomer;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div/div[4]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboManagerCustomer;


    @FindBy(id = "Comment-tab")
    private WebElement TabCommentCustomer;

    @FindBy(xpath = "//div[@id='Comment-tabpanel']//textarea[@aria-invalid='false' and @rows='10']")
    private WebElement textareaCommentCustomer;


    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Cancel']")
    private WebElement buttonCansel;

    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Save']")
    private WebElement buttonSaveCustomer;


    public void enterTextInputNameCustomer(String text) {
        BaseWebDriver.inputText(inputNameCustomer, text);
    }

    public void enterTextInputCountryCustomer(String text) {
        BaseWebDriver.inputText(inputCountryCustomer, text);
    }

    public void enterTextInputCityCustomer(String text) {
        BaseWebDriver.inputText(inputCityCustomer, text);
    }

    public void choiceManagerCustomer(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboManagerCustomer,  pozList, null, true);
    }

    public void openTabCommentAndEnterTextInCommentCustomer(String text) {
        BaseWebDriver.clickUntilSecondElementVisibility(driver, TabCommentCustomer, textareaCommentCustomer, null, false);
        BaseWebDriver.inputText(textareaCommentCustomer, text);
    }

    public void clickButtonSaveCustomer() {
        BaseWebDriver.clickElementWaitDisappear(driver, buttonSaveCustomer,  buttonCansel);
    }


}
