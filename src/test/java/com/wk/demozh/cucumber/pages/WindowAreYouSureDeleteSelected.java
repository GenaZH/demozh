package com.wk.demozh.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class WindowAreYouSureDeleteSelected {

    private final SelenideElement confirmationDeleteAllService = $x("//div[@role='dialog']//span[normalize-space(.) = 'Delete']");

    public void confirmationDeleteAllService() {
        confirmationDeleteAllService.click();
    }


}
