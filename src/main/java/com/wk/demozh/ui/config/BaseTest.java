package com.wk.demozh.ui.config;

import com.wk.demozh.ui.steps.AutorizationSteps;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public WebDriver driver;
    public AutorizationSteps authorizationSteps;

    @BeforeSuite
    public void beginAutorizationTest() {
        driver = BaseWebDriver.openBrowser();
        authorizationSteps = new AutorizationSteps(driver);
        authorizationSteps.openPageAutorization();
    }

    @AfterSuite
    public void endAutorizationTest() {
        BaseWebDriver.closeBrowser(driver);
    }

}
