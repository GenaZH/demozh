package com.wk.demozh.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import static com.codeborne.selenide.Selenide.$x;

public class WindowGateways {

    private final SelenideElement inputNameGateways = $x("//div[@id='Info-tabpanel']/div/div/div[1]/div/input[@type='text']");
    private final SelenideElement inputDNSNameGateways = $x("//div[@id='Info-tabpanel']/div/div/div[2]/div/input[@type='text']");
    private final SelenideElement inputPortGateways = $x("//div[@id='Info-tabpanel']/div/div/div[3]/div/input[@type='text']");

    private final SelenideElement buttonTypeGateways = $x("//div[@id='Info-tabpanel']/div/div/div[4]//button[2]");
    private final SelenideElement noproxyTypeGateways = $x("//div[@role='presentation']//li[@id='combo-box-1-option-1']");


    @И("Вводим Name Gateways {string}")
    public void enterInputNameGateways(String name) {
        inputNameGateways.sendKeys(name);
    }

    @И("Вводим DNS Name Gateways {string}")
    public void enterInputDNSNameGateways(String name) {
        inputDNSNameGateways.sendKeys(name);
    }

    @И("Вводим Port Gateways {string}")
    public void enterPortGateways(String port) {
        inputPortGateways.sendKeys(port);
    }

    @И("Выбираем Type Gateways")
    public void choiceTypeGateways() {
        buttonTypeGateways.click();
        noproxyTypeGateways.click();
    }

    @И("Проверяем наличие {string} и удаляем")
    public void checkingAvailabilityDelete(String name) throws InterruptedException {
        MenuBaseTopDown menuBaseTopDown = new MenuBaseTopDown();
        menuBaseTopDown.deleteTestObject(name);
    }

}
