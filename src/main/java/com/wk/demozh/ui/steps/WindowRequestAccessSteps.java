package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.WindowRequestAccess;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;

public class WindowRequestAccessSteps {
    private WebDriver driver;
    public WindowRequestAccess windowRequestAccess;

    public WindowRequestAccessSteps(WebDriver driver) {
        this.driver = driver;
        windowRequestAccess = new WindowRequestAccess(driver);
    }

    public void fillJustificationAndAddRequestAccess(String text) {
        windowRequestAccess.openTabDescriptionAndEnterTextInJustification(text);
        windowRequestAccess.clickButtonRequest();
        BaseWebDriver.waitDownloadPage(driver);
    }

    public void fillAndAddRequestAccessThroughCustomers(int pozList, String text) {
        windowRequestAccess.choiceServiceRequiredThroughCustomers(pozList);
        fillJustificationAndAddRequestAccess(text);
    }

    public void fillAndAddRequestAccessThroughServicesGroups(int pozList, String text) {
        windowRequestAccess.choiceServiceRequiredThroughServicesGroups();
        windowRequestAccess.choiceServicesGroups(pozList);
        fillJustificationAndAddRequestAccess(text);
    }


}
