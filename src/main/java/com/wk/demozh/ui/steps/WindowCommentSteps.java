package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.WindowComment;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;

public class WindowCommentSteps {
    private WebDriver driver;
    private WindowComment windowComment;

    public WindowCommentSteps(WebDriver driver) {
        this.driver = driver;
        windowComment = new WindowComment(driver);
    }

    public void enterCommentAndConfirmationDeleteSelectAllService(String text) {
        windowComment.enterTextareaComment(text);
        windowComment.clickButtonApprove();
        BaseWebDriver.waitDownloadPage(driver);
    }


}
