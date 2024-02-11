package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.config.PropertiesUI;
import com.wk.demozh.ui.pages.MenuUserBaseLeft;
import com.wk.demozh.ui.pages.AutorizationLoginPassword;
import com.wk.demozh.ui.pages.AutorizationToken;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AutorizationSteps {
    private WebDriver driver;
    private AutorizationLoginPassword autorizationLoginPassword;
    private AutorizationToken autorizationToken;
    private MenuUserBaseLeft menuUserBaseLeft;


    public AutorizationSteps(WebDriver driver) {
        this.driver = driver;
        autorizationLoginPassword = new AutorizationLoginPassword(driver);
        autorizationToken = new AutorizationToken(driver);
        menuUserBaseLeft = new MenuUserBaseLeft(driver);
    }

    public void openPageAutorization() {
        String urlAutorization = PropertiesUI.getInstance().getUrlAutorization();
        BaseWebDriver.openPage(driver, urlAutorization);
    }

    public boolean waitPageAutorizationLoginPassword() {
        return autorizationLoginPassword.waitPageAutorizationLoginPassword();
    }

    public void enterTextUserLogin(String login) {
        autorizationLoginPassword.enterTextUserLogin(login);
    }

    public void enterTextUserPassword(String password) {
        autorizationLoginPassword.enterTextUserPassword(password);
    }

    public void clickButtonSubmit() {
        autorizationLoginPassword.clickButtonSubmit();
    }

    public boolean waitPageAutorizationToken() {
        return autorizationToken.waitPageAutorizationToken();
    }

    public boolean checkingPresenceErrorline() {
        return autorizationLoginPassword.checkingPresenceErrorline();
    }

    public void enterTextUserToken(String token) {
        autorizationToken.enterTextUserToken(token);
    }

    public void clickButtonToken() {
        autorizationToken.clickButtonToken();
    }

    public boolean waitPageUserOpenedAccesses() {
        return menuUserBaseLeft.waitPageTableTitleInPage("Opened accesses");
    }

    public String getTitleUserOpenedAccesses() {
        return BaseWebDriver.getTitlePage(driver);
    }

    public boolean comeInUserOpenedAccesses() {
        return (getTitleUserOpenedAccesses().equals("Demozh"));
    }

    public void clickButtonLogout() {
        menuUserBaseLeft.clickButtonLogout();
    }

    public void autorizationEnterLoginPassword(String login, String password){
        openPageAutorization();
        Assert.assertTrue(waitPageAutorizationLoginPassword());  // ждём появление страницы ввода логина и пароля
        enterTextUserLogin(login);
        enterTextUserPassword(password);
        clickButtonSubmit();
    }

    public void autorizationEnterToken(String token) {
        enterTextUserToken(token);
        clickButtonToken();
    }

    public void autorizationEnterLoginPasswordTokenFull(String login, String password, String token){
        autorizationEnterLoginPassword(login, password);
        if( !comeInUserOpenedAccesses() ) {
            autorizationEnterToken(token);
        }
        waitPageUserOpenedAccesses();
        Assert.assertTrue(comeInUserOpenedAccesses());
    }

}
