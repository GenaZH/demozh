package com.wk.demozh.ui.pages;

import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuBaseTopDown {
    private WebDriver driver;

    public MenuBaseTopDown(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='header-portal']//input[contains(@placeholder, 'Search') and @type='text']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@type='button' and @aria-label='Approve selected']")
    private WebElement buttonApproveSelected;

    @FindBy(xpath = "//button[@type='button' and @aria-label='Delete selected']")
    private WebElement buttonDeleteSelected;

    @FindBy(xpath = "//button[@type='button' and @aria-label='Menu']")
    private WebElement buttonBaseMenu;

    @FindBy(xpath = "//button[@type='button']//span[normalize-space(.) = 'Logout']")
    private WebElement buttonLogout;

    @FindBy(xpath = "//div[@id='root']//div[@class='MainView-module-switchCheckboxNo__2xkpms4']")
    private WebElement buttonModeUserOrAdmin;

    @FindBy(id = "tableTitle")
    private WebElement tableTitleInPage;

    @FindBy(xpath = "//th[contains(@class, 'MuiTableCell-root')]//input[@type='checkbox' and contains(@class, 'jss') and @data-indeterminate='false']")
    private WebElement checkboxSelectAllRowsInTable;

    @FindBy(xpath = "//table[contains(@class, 'MuiTable-root')]")
    private WebElement presenceTable;

    @FindBy(xpath = "//tr[contains(@class, 'MuiTableRow-root')]//td[contains(@class, 'MuiTableCell-root')]")
    private WebElement presenceRowsInTable;


    public void inputTextSearch(String text) {
        BaseWebDriver.inputText(inputSearch, text);
    }

    public boolean absenceQuantityRowsPerPage() {
        try {
            BaseWebDriver.waitWebElementInPage(driver, presenceTable); // ждём появление таблицы, а потом строк
            BaseWebDriver.waitDownloadPage(driver);
            return BaseWebDriver.waitWebElementInPage(driver, presenceRowsInTable, 1);
        } catch (Exception e) {
            return false;
        }
    }

    public void selectAllRowsAndDelete() {
        checkboxSelectAllRowsInTable.click();
        buttonDeleteSelected.click();
    }

    public void selectAllRowsAndApprove() {
        checkboxSelectAllRowsInTable.click();
        buttonApproveSelected.click();
    }

    public void clickButtonLogout() {
        if (BaseWebDriver.waitWebElementInPage(driver, buttonBaseMenu, 0)) {
            buttonBaseMenu.click();
            buttonLogout.click();
            BaseWebDriver.waitRemoveWebElementInPage(driver, By.xpath("//button[@type='button']//span[normalize-space(.) = 'Logout']"), 30);
        }
    }

    public void choiceMode(String mode) {
        if ((BaseWebDriver.waitWebElementInPage(driver, buttonModeUserOrAdmin, 0)) && (!buttonModeUserOrAdmin.getText().equalsIgnoreCase(mode))) {
            buttonModeUserOrAdmin.click();
        }
    }

    public void clickButtonModeUser() {
        choiceMode("Admin");
    }

    public void clickButtonModeAdmin() {
        choiceMode("User");
    }

    public boolean waitPageTableTitleInPage(String nameTable) {
        BaseWebDriver.waitWebElementInPage(driver, By.id("tableTitle"));
        return tableTitleInPage.getText().equalsIgnoreCase(nameTable);
    }

}


