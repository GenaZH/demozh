package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.MenuUserBaseLeft;
import org.openqa.selenium.WebDriver;

public class MenuUserBaseLeftSteps {
    private MenuUserBaseLeft menuUserBaseLeft;
    private WindowGetAccessSteps windowGetAccessSteps;
    private WindowRequestAccessSteps windowRequestAccessSteps;

    public MenuUserBaseLeftSteps(WebDriver driver) {
        menuUserBaseLeft = new MenuUserBaseLeft(driver);
        windowGetAccessSteps = new WindowGetAccessSteps(driver);
        windowRequestAccessSteps = new WindowRequestAccessSteps(driver);
    }


    public void fillAndAddGetAccessThroughChoiceCustomers(int pozList, String text) {
        menuUserBaseLeft.clickUserMenuGetAccess();
        windowGetAccessSteps.fillAndAddGetAccessThroughChoiceCustomers(pozList, text);
    }

    public void clickUserMenuGetAccessAndAddGetAccessThroughChoiceServicesGroups(int pozList, String text) {
        menuUserBaseLeft.clickUserMenuGetAccess();
        windowGetAccessSteps.fillAndAddGetAccessThroughChoiceServicesGroups(pozList, text);
    }

    public void clickUserMenuRequestAccessAndAddRequestAccessThroughCustomers(int pozList, String text) {
        menuUserBaseLeft.clickUserMenuRequestAccess();
        windowRequestAccessSteps.fillAndAddRequestAccessThroughCustomers(pozList, text);
    }

    public void clickUserMenuRequestAccessAndAddRequestAccessThroughServicesGroups(int pozList, String text) {
        menuUserBaseLeft.clickUserMenuRequestAccess();
        windowRequestAccessSteps.fillAndAddRequestAccessThroughServicesGroups(pozList, text);
    }

    public void clickUserMenuRequestedAccesses() {
        menuUserBaseLeft.clickUserMenuRequestedAccesses();
    }
}
