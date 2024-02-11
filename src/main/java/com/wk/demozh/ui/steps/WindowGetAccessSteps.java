package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.WindowGetAccess;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;

public class WindowGetAccessSteps {
    private WebDriver driver;
    public WindowGetAccess windowGetAccess;

    public WindowGetAccessSteps(WebDriver driver) {
        this.driver = driver;
        windowGetAccess = new WindowGetAccess(driver);
    }

    public void fillJustificationAndAddGetAccess(String text) {
        windowGetAccess.openTabDescriptionAndEnterTextInJustification(text);
        windowGetAccess.clickButtonGetAccess();
        BaseWebDriver.waitDownloadPage(driver);
    }

    public void fillAndAddGetAccessThroughChoiceCustomers(int pozList, String text) {
        windowGetAccess.choiceServicesThroughCustomers(pozList);
        fillJustificationAndAddGetAccess(text);
    }

    public void fillAndAddGetAccessThroughChoiceServicesGroups(int pozList, String text) {
        windowGetAccess.clickTabGetByServicesGroups();
        windowGetAccess.choiceServicesGroups(pozList);
        fillJustificationAndAddGetAccess(text);
    }


}
