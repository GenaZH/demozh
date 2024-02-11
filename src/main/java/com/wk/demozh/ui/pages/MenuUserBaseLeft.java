package com.wk.demozh.ui.pages;

import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuUserBaseLeft extends MenuBaseTopDown {
    private WebDriver driver;

    public MenuUserBaseLeft(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='Opened accesses-menu']//preceding-sibling::div[1]")
    private WebElement userMenuOpenedAcceses;

    @FindBy(xpath = "//div[@id='Opened accesses-menu']//span[normalize-space(.) = 'Get access']")
    private WebElement userMenuGetAccess;

    @FindBy(xpath = "//div[@id='Opened accesses-menu']//span[normalize-space(.) = 'Request access']")
    private WebElement userMenuRequestAccess;

    @FindBy(xpath = "//div[@id='Requested accesses-menu']//preceding-sibling::div[1]")
    private WebElement userMenuRequestedAccesses;


    public void clickUserMenuOpenedAcceses() {
        userMenuOpenedAcceses.click();
    }

    public void clickUserMenuGetAccess() {
        userMenuOpenedAcceses.click();
        userMenuGetAccess.click();
        BaseWebDriver.waitDownloadPage(driver);
    }

    public void clickUserMenuRequestAccess() {
        userMenuOpenedAcceses.click();
        userMenuRequestAccess.click();
        BaseWebDriver.waitDownloadPage(driver);
    }

    public void clickUserMenuRequestedAccesses() {
        userMenuRequestedAccesses.click();
    }


}
