package com.wk.demozh.mobiluialfa;

import com.wk.demozh.mobiluialfa.config.ConfigProperties;
import com.wk.demozh.mobiluialfa.steps.AutorizationAlfaSteps;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AutorizationAlfaTest extends BaseTest {

    ConfigProperties cfg = ConfigFactory.create(ConfigProperties.class);
    private String validLogin = cfg.validLogin();
    private String validPassword = cfg.validPassword();
    private String noValidLogin = RandomStringUtils.randomAlphabetic(15);
    private String noValidPassword = RandomStringUtils.randomAlphanumeric(15);

    @DataProvider(name = "noValidLogPas")
    public Object[][] dpMethod(){
        return new Object[][] {
                {noValidLogin, noValidPassword},
                {"", ""},
                {noValidLogin, ""},
                {"", noValidPassword}
        };
    }

    @Test(dataProvider = "noValidLogPas", description = "Тест на авторизацию с НЕвалидными Логинами и Паролями")
    public void autorizationAdminNoCorrectLoginsPasswords(String noValidLog, String noValidPass) {
        AutorizationAlfaSteps autorizationAlfaSteps = new AutorizationAlfaSteps(appiumDriver);

        autorizationAlfaSteps.enterTextLogin(noValidLog)
                .enterTextPassword(noValidPass)
                .clickConfirm();

        Assert.assertTrue(autorizationAlfaSteps.presentError());
    }

    @Test(description = "Тест на авторизацию валидными Логином и Паролем")
    public void autorizationAdminCorrectLoginPassword() {
        AutorizationAlfaSteps autorizationAlfaSteps = new AutorizationAlfaSteps(appiumDriver);

        autorizationAlfaSteps.enterTextLogin(validLogin)
                .enterTextPassword(validPassword)
                .clickConfirm();

        Assert.assertTrue(autorizationAlfaSteps.presentReady());
        //Thread.sleep(5000);
    }

    /*
    int count = 0;
    String[] NoCorrectLogin = {noValidLogin, "", "", noValidLogin};
    String[] NoCorrectPassword = {noValidPassword, "", noValidPassword, ""};


    @Test(invocationCount = 4, description = "Тест на авторизацию с НЕвалидными Логинами и Паролями")
    public void autorizationAdminNoCorrectLoginPassworddd() {
        AutorizationAlfaSteps autorizationAlfaSteps = new AutorizationAlfaSteps(appiumDriver);

        autorizationAlfaSteps.enterTextLogin(NoCorrectLogin[count]);
        autorizationAlfaSteps.enterTextPassword(NoCorrectPassword[count]);
        autorizationAlfaSteps.clickConfirm();
        count++;
        Assert.assertTrue(autorizationAlfaSteps.presentError());
    }*/

/*
    @Test(description = "Тест на авторизацию Невалидными Логином и Паролем")
    public void autorizationAdminNoCorrectLoginPassword() {
        AutorizationAlfaSteps autorizationAlfaSteps = new AutorizationAlfaSteps(appiumDriver);

        autorizationAlfaSteps.enterTextLogin(noValidLogin);
        autorizationAlfaSteps.enterTextPassword(noValidPassword);
        autorizationAlfaSteps.clickConfirm();

        Assert.assertTrue(autorizationAlfaSteps.presentError());
    }

    @Test(description = "Тест на авторизацию с Пустым Логином и Паролем")
    public void autorizationAdminNoLoginPassword() {
        AutorizationAlfaSteps autorizationAlfaSteps = new AutorizationAlfaSteps(appiumDriver);

        autorizationAlfaSteps.enterTextLogin("");
        autorizationAlfaSteps.enterTextPassword("");
        autorizationAlfaSteps.clickConfirm();

        Assert.assertTrue(autorizationAlfaSteps.presentError());
    }

    @Test(description = "Тест на авторизацию с Пустым Логином и Невалидным Пароля")
    public void autorizationAdminNoLoginNoCorrectPassword() {
        AutorizationAlfaSteps autorizationAlfaSteps = new AutorizationAlfaSteps(appiumDriver);

        autorizationAlfaSteps.enterTextLogin("");
        autorizationAlfaSteps.enterTextPassword(noValidPassword);
        autorizationAlfaSteps.clickConfirm();

        Assert.assertTrue(autorizationAlfaSteps.presentError());
    }

    @Test(description = "Тест на авторизацию с Пустым Паролем и Невалидным Логином")
    public void autorizationAdminNoPasswordNoCorrectLogin() {
        AutorizationAlfaSteps autorizationAlfaSteps = new AutorizationAlfaSteps(appiumDriver);

        autorizationAlfaSteps.enterTextLogin(noValidLogin);
        autorizationAlfaSteps.enterTextPassword("");
        autorizationAlfaSteps.clickConfirm();

        Assert.assertTrue(autorizationAlfaSteps.presentError());
    }*/

}