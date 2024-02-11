package com.wk.demozh.mobiluialfa.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/main/resources/system.properties"
})
public interface ConfigProperties extends Config {

    @Key("appium.platformName")
    @DefaultValue("Android")
    String appiumPlatformName();

    @Key("appium.platformVersion")
    String appiumPlatformVersion();

    @Key("appium.deviceName")
    String appiumDeviceName();

    @Key("appium.app")
    String appiumApp();

    @Key("appium.package")
    String appiumPackage();

    @Key("appium.activity")
    String appiumActivity();

    @Key("appium.remoteUrl")
    String appiumRemoteUrl();

    @Key("alfabank.validLogin")
    String validLogin();

    @Key("alfabank.validPassword")
    String validPassword();

}

