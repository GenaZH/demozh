package com.wk.demozh.ui;

import com.wk.demozh.ui.config.BaseTest;
import com.wk.demozh.ui.config.PropertiesUI;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutorizationTest extends BaseTest {
    private String noCorrectUserLogin = RandomStringUtils.randomAlphabetic(15);
    private String noCorrectUserPasswordToken = RandomStringUtils.randomAlphanumeric(15);

    @Test
    public void autorizationAdminCorrectLoginPassword() {
        authorizationSteps.autorizationEnterLoginPassword
                (PropertiesUI.getInstance().getAdminLogin(), PropertiesUI.getInstance().getAdminPassword());
        Assert.assertTrue(authorizationSteps.waitPageAutorizationToken());
    }

    @Test
    public void autorizationAdminNoCorrectPassword() {
        authorizationSteps.autorizationEnterLoginPassword(PropertiesUI.getInstance().getAdminLogin(), noCorrectUserPasswordToken);
        Assert.assertTrue(authorizationSteps.checkingPresenceErrorline());
    }

    @Test
    public void autorizationAdminEmptyPassword() {
        authorizationSteps.autorizationEnterLoginPassword(PropertiesUI.getInstance().getAdminLogin(), "");
        Assert.assertTrue(authorizationSteps.waitPageAutorizationLoginPassword());
    }

    @Test
    public void autorizationAdminEmptyLogin() {
        authorizationSteps.autorizationEnterLoginPassword("", PropertiesUI.getInstance().getAdminPassword());
        Assert.assertTrue(authorizationSteps.waitPageAutorizationLoginPassword());
    }

    @Test
    public void autorizationAdminNoCorrectLoginPassword() {
        authorizationSteps.autorizationEnterLoginPassword(noCorrectUserLogin, noCorrectUserPasswordToken);
        Assert.assertTrue(authorizationSteps.checkingPresenceErrorline());
    }

    @Test
    public void autorizationAdminEmptyLoginPassword() {
        authorizationSteps.autorizationEnterLoginPassword("", "");
        Assert.assertTrue(authorizationSteps.waitPageAutorizationLoginPassword());
    }

    @Test
    public void autorizationAdminNoCorrectLogin() {
        authorizationSteps.autorizationEnterLoginPassword(noCorrectUserLogin, PropertiesUI.getInstance().getAdminPassword());
        Assert.assertTrue(authorizationSteps.checkingPresenceErrorline());
    }

    @Test
    public void autorizationAdminCorrectToken() {
        autorizationAdminCorrectLoginPassword();
        authorizationSteps.autorizationEnterToken(PropertiesUI.getInstance().getAdminToken());
        Assert.assertTrue(authorizationSteps.waitPageUserOpenedAccesses());
        Assert.assertEquals(authorizationSteps.getTitleUserOpenedAccesses(), "demozh");
        authorizationSteps.clickButtonLogout();
    }

    @Test
    public void autorizationAdminEmptyToken() {
        autorizationAdminCorrectLoginPassword();
        authorizationSteps.autorizationEnterToken("");
        Assert.assertTrue(authorizationSteps.waitPageAutorizationToken());
    }

    @Test(priority = 999) // чтоб последним запускался - тут баг при любом токене происходит вход
    public void autorizationAdminNoCorrectToken() {
        autorizationAdminCorrectLoginPassword();
        authorizationSteps.autorizationEnterToken(noCorrectUserPasswordToken);
        Assert.assertTrue(authorizationSteps.waitPageAutorizationToken());
    }

}
