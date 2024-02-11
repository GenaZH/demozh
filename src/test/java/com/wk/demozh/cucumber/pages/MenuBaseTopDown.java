package com.wk.demozh.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import com.wk.demozh.cucumber.steps.BaseOpenDemozh;

import static com.codeborne.selenide.Selenide.$x;

public class MenuBaseTopDown {

    private final SelenideElement inputSearch = $x("//div[@id='header-portal']//input[contains(@placeholder, 'Search') and @type='text']");

    public void inputTextSearch(String text) {
        BaseOpenDemozh.inputText(inputSearch, text);
        BaseOpenDemozh.waitDownloadPage();
    }

    private final SelenideElement presenceTable = $x("//table[contains(@class, 'MuiTable-root')]");
    private final SelenideElement presenceRowsInTable = $x("//tr[contains(@class, 'MuiTableRow-root')]//td[contains(@class, 'MuiTableCell-root')]");

    public boolean absenceQuantityRowsPerPage() {
        BaseOpenDemozh.waitWebElementInPage(presenceTable); // ждём появление таблицы, а потом строк
        BaseOpenDemozh.waitDownloadPage();
        return BaseOpenDemozh.waitWebElementInPage(presenceRowsInTable, 1000);
    }

    private final SelenideElement checkboxSelectAllRowsInTable = $x("//th[contains(@class, 'MuiTableCell-root')]//input[@type='checkbox' and contains(@class, 'jss') and @data-indeterminate='false']");
    private final SelenideElement buttonDeleteSelected = $x("//button[@type='button' and @aria-label='Delete selected']");

    public void selectAllRowsAndDelete() {
        checkboxSelectAllRowsInTable.click();
        checkboxSelectAllRowsInTable.click();
        //buttonDeleteSelected.click();
    }

    public void deleteTestObject(String text) throws InterruptedException {
        inputTextSearch(text);
        if ( absenceQuantityRowsPerPage() ) {
            selectAllRowsAndDelete();
            Thread.sleep(100000);
            //WindowAreYouSureDeleteSelected windowAreYouSureDeleteSelected = new WindowAreYouSureDeleteSelected();
            //windowAreYouSureDeleteSelected.confirmationDeleteAllService();
        }
    }

}
