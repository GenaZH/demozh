package com.wk.demozh.mobiluialfa;

import com.wk.demozh.mobiluialfa.config.DriverConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver appiumDriver;

    @BeforeMethod
    public void setUp() throws Exception {
        appiumDriver = DriverConfig.createDriver();
    }

    @AfterMethod
    public void teardown(){
        appiumDriver.quit();
    }
}