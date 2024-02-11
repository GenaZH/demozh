package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.WindowAreYouSureDeleteSelected;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;

public class WindowAreYouSureDeleteSelectedSteps {
    private WebDriver driver;
    private WindowAreYouSureDeleteSelected windowAreYouSureDeleteSelected;

    public WindowAreYouSureDeleteSelectedSteps(WebDriver driver) {
        this.driver = driver;
        windowAreYouSureDeleteSelected = new WindowAreYouSureDeleteSelected(driver);
    }

    public void confirmationDeleteAllService() {
        windowAreYouSureDeleteSelected.confirmationDeleteAllService();
        BaseWebDriver.waitDownloadPage(driver);
    }
}
