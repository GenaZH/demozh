package com.wk.demozh.ui.pages;

import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuAdminBaseLeft extends MenuBaseTopDown {
    private WebDriver driver;

    public MenuAdminBaseLeft(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='Accesses-menu']//preceding-sibling::div[1]")
    private WebElement adminMenuAccesses;

    @FindBy(xpath = "//div[@id='Accesses-menu']//span[normalize-space(.) = 'Requested accesses']")
    private WebElement adminMenuRequestedAccesses;


    @FindBy(xpath = "//div[@id='Customers-menu']//preceding-sibling::div[1]")
    private WebElement adminMenuCustomers;

    @FindBy(xpath = "//div[@id='Customers-menu']//span[normalize-space(.) = 'Add customer']")
    private WebElement adminMenuAddCustomer;


    @FindBy(xpath = "//div[@id='Services-menu']//preceding-sibling::div[1]")
    private WebElement adminMenuServices;

    @FindBy(xpath = "//div[@id='Services-menu']//span[normalize-space(.) = 'Add service']")
    private WebElement adminMenuAddService;


    public void clickAdminMenuRequestedAccesses() {
        adminMenuAccesses.click();
        adminMenuRequestedAccesses.click();
        BaseWebDriver.waitDownloadPage(driver);
    }

    public void clickAdminMenuCustomers() {
        adminMenuCustomers.click();
        BaseWebDriver.waitDownloadPage(driver);
    }

    public void clickAdminMenuAddCustomer() {
        clickAdminMenuCustomers();
        adminMenuAddCustomer.click();
        BaseWebDriver.waitDownloadPage(driver);
    }

    public void clickAdminMenuServices() {
        adminMenuServices.click();
        BaseWebDriver.waitDownloadPage(driver);
    }

    public void clickAdminMenuAddService() {
        clickAdminMenuServices();
        adminMenuAddService.click();
        BaseWebDriver.waitDownloadPage(driver);
    }


}

