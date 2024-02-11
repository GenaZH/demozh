package com.wk.demozh.ui.pages;

import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsService {
    private WebDriver driver;

    public WindowsService(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div/div[1]//input[@type='text']")
    private WebElement inputFullNameService;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div/div[2]//input[@type='text']")
    private WebElement inputAliasService;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div/div[3]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboCustomerService;

    @FindBy(xpath = "//div[@id='Info-tabpanel']/div/div/div[4]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboManagerService;


    @FindBy(id = "Connection-tab")
    private WebElement TabConnectionService;

    @FindBy(xpath = "//div[@id='Connection-tabpanel']/div/div/div[3]/div[1]//input[@type='text']")
    private WebElement inputIPService;

    @FindBy(xpath = "//div[@id='Connection-tabpanel']/div/div/div[3]/div[2]//input[@type='text']")
    private WebElement inputPortService;

    @FindBy(xpath = "//div[@id='Connection-tabpanel']/div/div/div[3]/div[3]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboOtherService;

    @FindBy(xpath = "//div[@id='Connection-tabpanel']/div/div/div[4]/div[1]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboGatewayService;

    @FindBy(xpath = "//div[@id='Connection-tabpanel']/div/div/div[4]/div[2]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]")
    private WebElement openComboProxyTypeService;

    @FindBy(xpath = "//div[@id='Connection-tabpanel']//input[@type='number']")
    private WebElement inputProxyPortService;


    @FindBy(id = "Description-tab")
    private WebElement TabDescriptionService;

    @FindBy(xpath = "//div[@id='Description-tabpanel']/div/div/div[1]//textarea[@aria-invalid='false' and @rows='5']")
    private WebElement textareaDescriptionService;

    @FindBy(xpath = "//div[@id='Description-tabpanel']/div/div/div[2]//textarea[@aria-invalid='false' and @rows='5']")
    private WebElement textareaCommentService;

    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Cancel']")
    private WebElement buttonCansel;

    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Save']")
    private WebElement buttonSaveService;


    public void enterTextInputFullNameService(String text) {
        BaseWebDriver.inputText(inputFullNameService, text);
    }

    public void enterTextInputAliasService(String text) {
        BaseWebDriver.inputText(inputAliasService, text);
    }

    public void choiceCustomerService(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboCustomerService,  pozList, null,  true);
    }

    public void choiceManagerService(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboManagerService,  pozList, null, true);
    }


    public void clickTabConnectionService() {
        BaseWebDriver.clickUntilSecondElementClick(driver, TabConnectionService, inputIPService, null, true);
    }

    public void enterTextInputIPService(String text) {
        BaseWebDriver.inputText(inputIPService, text);
    }

    public void enterTextInputPortService(String text) {
        BaseWebDriver.inputText(inputPortService, text);
    }

    public void choiceOtherService(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboOtherService,  pozList, null, true);
    }

    public void choiceGatewayService(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboGatewayService,  pozList, null, true);
    }

    public void choiceProxyTypeService(int pozList) {
        BaseWebDriver.choiceInComboListContainsIdOption(driver, openComboProxyTypeService,  pozList, null, true);
    }

    public void enterTextInputProxyPortService(String text) {
        BaseWebDriver.inputText(inputProxyPortService, text);
    }


    public void openTabDescriptionAndEnterTextInDescriptionAndCommentService(String description, String comment) {
        BaseWebDriver.clickUntilSecondElementVisibility(driver, TabDescriptionService, textareaDescriptionService, null, false);
        BaseWebDriver.inputText(textareaDescriptionService, description);
        BaseWebDriver.inputText(textareaCommentService, comment);
    }

    public void clickButtonSaveService() {
        BaseWebDriver.clickElementWaitDisappear(driver, buttonSaveService,  buttonCansel);
    }

}
