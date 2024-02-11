package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.WindowsCustomer;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;

public class WindowsCustomerSteps {
    private WebDriver driver;
    public WindowsCustomer windowsCustomer;

    public WindowsCustomerSteps(WebDriver driver) {
        this.driver = driver;
        windowsCustomer = new WindowsCustomer(driver);
    }


    public void fillCustomerAndSave(String name, String country, String city, int pozList, String comment) {
        windowsCustomer.enterTextInputNameCustomer(name);
        windowsCustomer.enterTextInputCountryCustomer(country);
        windowsCustomer.enterTextInputCityCustomer(city);
        windowsCustomer.choiceManagerCustomer(pozList);
        windowsCustomer.openTabCommentAndEnterTextInCommentCustomer(comment);
        windowsCustomer.clickButtonSaveCustomer();
        BaseWebDriver.waitDownloadPage(driver);
    }


}
