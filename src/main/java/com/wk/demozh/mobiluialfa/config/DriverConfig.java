package com.wk.demozh.mobiluialfa.config;

import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class DriverConfig {

    private static String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " - not found");
        return file.getAbsolutePath();
    }

    public static WebDriver createDriver() throws Exception {

        WebDriver appiumDriverp;

        ConfigProperties cfg = ConfigFactory.create(ConfigProperties.class);

        DesiredCapabilities cap = new DesiredCapabilities();

        URL serverUrl = new URL(cfg.appiumRemoteUrl());
        cap.setCapability("platformName", cfg.appiumPlatformName());
        cap.setCapability("platformVersion", cfg.appiumPlatformVersion());
        cap.setCapability("deviceName", cfg.appiumDeviceName());
        cap.setCapability("app", getAbsolutePath(cfg.appiumApp()));
        cap.setCapability("noReset", true);
        cap.setCapability("fullReset", false);

        appiumDriverp = new AndroidDriver(serverUrl, cap);
        appiumDriverp.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //System.out.println("Application started");

        return appiumDriverp;
    }


}
