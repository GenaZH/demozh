package com.wk.demozh.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuBaseRight {

    public MenuBaseRight(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[contains(@class, 'MuiTableRow-root')]//span[normalize-space(.) = 'edit']")
    private WebElement buttonEditRow;


    public void clickButtonEditRow() {
        buttonEditRow.click();
    }

}
