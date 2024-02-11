package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.MenuAdminBaseLeft;
import com.wk.demozh.ui.pages.MenuBaseTopDown;
import com.wk.demozh.ui.pages.MenuUserBaseLeft;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;

public class MenuBaseTopDownSteps {
    private WebDriver driver;
    private MenuBaseTopDown menuBaseTopDown;
    private MenuAdminBaseLeft menuAdminBaseLeft;
    private MenuUserBaseLeft menuUserBaseLeft;
    private WindowAreYouSureDeleteSelectedSteps windowAreYouSureDeleteSelectedSteps;
    private WindowCommentSteps windowCommentSteps;

    public MenuBaseTopDownSteps(WebDriver driver) {
        this.driver = driver;
        menuBaseTopDown = new MenuBaseTopDown(driver);
        menuAdminBaseLeft = new MenuAdminBaseLeft(driver);
        menuUserBaseLeft = new MenuUserBaseLeft(driver);
        windowAreYouSureDeleteSelectedSteps = new WindowAreYouSureDeleteSelectedSteps(driver);
        windowCommentSteps = new WindowCommentSteps(driver);
    }

    public void inputTextSearch(String text) {
        menuBaseTopDown.inputTextSearch(text);
        BaseWebDriver.waitDownloadPage(driver);
    }

    private void deleteTestObject(String text) {
        inputTextSearch(text);
        if ( menuBaseTopDown.absenceQuantityRowsPerPage() ) {
            menuBaseTopDown.selectAllRowsAndDelete();
            windowAreYouSureDeleteSelectedSteps.confirmationDeleteAllService();
        }
    }

    public void deleteTestCustomer(String text) {
        menuAdminBaseLeft.clickAdminMenuCustomers();
        deleteTestObject(text);
    }

    public void deleteTestService(String text) {
        menuAdminBaseLeft.clickAdminMenuServices();
        deleteTestObject(text);
    }

    private void approveSelectAllRowsInTable(boolean checkingRows, String text) {
        if (!checkingRows || menuBaseTopDown.absenceQuantityRowsPerPage()) {
            menuBaseTopDown.selectAllRowsAndApprove();
            windowCommentSteps.enterCommentAndConfirmationDeleteSelectAllService(text);
        }
    }

    public void approveAllRequestedAccesses(boolean checkingRows, String text) {
        menuAdminBaseLeft.clickAdminMenuRequestedAccesses();
        approveSelectAllRowsInTable(checkingRows, text);
    }

    private void deleteSelectAllRowsInTable(boolean checkingRows) {
        if (!checkingRows || menuBaseTopDown.absenceQuantityRowsPerPage()) {
            menuBaseTopDown.selectAllRowsAndDelete();
            windowAreYouSureDeleteSelectedSteps.confirmationDeleteAllService();
        }
    }

    public void deleteAllOpenedAccesses(boolean checkingRows) {
        menuUserBaseLeft.clickUserMenuOpenedAcceses();
        deleteSelectAllRowsInTable(checkingRows);
    }

    public void deleteAllRequestedAccesses(boolean checkingRows) {
        menuUserBaseLeft.clickUserMenuRequestedAccesses();
        deleteSelectAllRowsInTable(checkingRows);
    }

    public void clickButtonModeUser() {
        menuBaseTopDown.clickButtonModeUser();
    }

    public void clickButtonModeAdmin() {
        menuBaseTopDown.clickButtonModeAdmin();
    }

    public boolean absenceQuantityRowsPerPage() {
        return menuBaseTopDown.absenceQuantityRowsPerPage();
    }

    public boolean absenceRowsPerPageAdminRequestedAccesses() {
        menuAdminBaseLeft.clickAdminMenuRequestedAccesses();
        return absenceQuantityRowsPerPage();
    }

    public boolean absenceRowsPerPageUserRequestedAccesses() {
        menuUserBaseLeft.clickUserMenuRequestedAccesses();
        return absenceQuantityRowsPerPage();
    }

    public boolean absenceRowsPerPageUserOpenedAccesses() {
        menuUserBaseLeft.clickUserMenuOpenedAcceses();
        return absenceQuantityRowsPerPage();
    }



}
