package com.wk.demozh.mobiluialfa.steps;

import com.wk.demozh.mobiluialfa.pages.AutorizationAlfa;
import com.wk.demozh.mobiluialfa.pages.AutorizationAlfaReady;
import org.openqa.selenium.WebDriver;

public class AutorizationAlfaSteps {

    private WebDriver appiumDriver;
    public AutorizationAlfa autorizationAlfa;
    public AutorizationAlfaReady autorizationAlfaReady;
    public AutorizationAlfaSteps(WebDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        autorizationAlfa = new AutorizationAlfa(appiumDriver);
        autorizationAlfaReady = new AutorizationAlfaReady(appiumDriver);
    }
    public AutorizationAlfaSteps enterTextLogin(String text) {
        autorizationAlfa.enterTextLogin(text);
        return this;
    }

    public AutorizationAlfaSteps enterTextPassword(String text) {
        autorizationAlfa.enterTextPassword(text);
        return this;
    }

    public AutorizationAlfaSteps clickConfirm() {
        autorizationAlfa.clickConfirm();
        return this;
    }

    public boolean presentError() {
        return autorizationAlfa.presentError();
    }
    public boolean presentReady() {
        return autorizationAlfaReady.AutorizationAlfaReady();
    }


}
