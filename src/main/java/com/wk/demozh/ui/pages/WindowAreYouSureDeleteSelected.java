package com.wk.demozh.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowAreYouSureDeleteSelected {

    public WindowAreYouSureDeleteSelected(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='dialog']//span[normalize-space(.) = 'Delete']")
    private WebElement confirmationDeleteAllService;


    public void confirmationDeleteAllService() {
        confirmationDeleteAllService.click();
    }


}
