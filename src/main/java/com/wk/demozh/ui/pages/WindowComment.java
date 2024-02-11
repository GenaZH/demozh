package com.wk.demozh.ui.pages;

import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowComment {

    public WindowComment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@aria-invalid='false' and @rows='5']")
    private WebElement textareaComment;

    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Approve']")
    private WebElement buttonApprove;


    public void enterTextareaComment(String text) {
        BaseWebDriver.inputText(textareaComment, text);
    }

    public void clickButtonApprove() {
        buttonApprove.click();
    }


}

