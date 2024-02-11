package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.MenuAdminBaseLeft;
import org.openqa.selenium.WebDriver;

public class MenuAdminBaseLeftSteps {
    private MenuAdminBaseLeft menuAdminBaseLeft;
    private WindowsCustomerSteps windowsCustomerSteps;
    private WindowsServiceSteps windowsServiceSteps;

    public MenuAdminBaseLeftSteps(WebDriver driver) {
        menuAdminBaseLeft = new MenuAdminBaseLeft(driver);
        windowsCustomerSteps = new WindowsCustomerSteps(driver);
        windowsServiceSteps = new WindowsServiceSteps(driver);
    }


    public void clickAdminMenuAddCustomer() {
        menuAdminBaseLeft.clickAdminMenuAddCustomer();
    }

    public void fillAndAddCustomer(String name, String country, String city, int pozList, String comment) {
        windowsCustomerSteps.fillCustomerAndSave(name, country, city, pozList, comment);
    }

    public void clickAdminMenuAddService() {
        menuAdminBaseLeft.clickAdminMenuAddService();
    }

    public void fillAndAddServiceAndSave(String fullName, String alias, int pozList, String iPService, String portService, String proxyPort, String description, String comment) {
        windowsServiceSteps.fillAndAddServiceAndSave(fullName, alias, pozList, iPService, portService, proxyPort, description, comment);
    }

}
