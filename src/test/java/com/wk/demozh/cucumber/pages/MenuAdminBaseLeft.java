package com.wk.demozh.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;

import static com.codeborne.selenide.Selenide.$x;

public class MenuAdminBaseLeft {

    private final SelenideElement adminMenuGateways = $x("//div[@id='Gateways-menu']//preceding-sibling::div[1]");
    private final SelenideElement adminMenuAddGateways = $x("//div[@id='Gateways-menu']//span[normalize-space(.) = 'Add gateway']");

    @Когда("Нажимаем пункт меню Gateways")
    public void clickAdminMenuGateways() {
        adminMenuGateways.click();
    }

    @И("Нажимаем пункт меню Add Gateways")
    public void clickAdminMenuAddGateways() {
        adminMenuAddGateways.click();
    }


}
