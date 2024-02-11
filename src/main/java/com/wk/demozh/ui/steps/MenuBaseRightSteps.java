package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.MenuBaseRight;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;

public class MenuBaseRightSteps {
    private WebDriver driver;
    private MenuBaseRight adminCustomers;

    public MenuBaseRightSteps(WebDriver driver) {
        this.driver = driver;
        adminCustomers = new MenuBaseRight(driver);
    }

    public void clickButtonEditRow() {
        adminCustomers.clickButtonEditRow();
        BaseWebDriver.waitDownloadPage(driver);
    }

}
