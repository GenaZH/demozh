package com.wk.demozh.ui.steps;

import com.wk.demozh.ui.pages.WindowsService;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.openqa.selenium.WebDriver;

public class WindowsServiceSteps {
    private WebDriver driver;
    public WindowsService windowsService;

    public WindowsServiceSteps(WebDriver driver) {
        this.driver = driver;
        windowsService = new WindowsService(driver);
    }


    public void fillAndAddServiceAndSave(String fullName, String alias, int pozList, String iPService, String portService, String proxyPort, String description, String comment) {
        windowsService.enterTextInputFullNameService(fullName);
        windowsService.enterTextInputAliasService(alias);
        windowsService.choiceCustomerService(pozList);
        windowsService.choiceManagerService(pozList);
       /* windowsService.choiceCustomerService(BaseWebDriver.getRandomNumberInt(0 ,4));
        windowsService.choiceManagerService(BaseWebDriver.getRandomNumberInt(0 ,20));*/
        windowsService.clickTabConnectionService();
        windowsService.enterTextInputIPService(iPService);
        windowsService.enterTextInputPortService(portService);
        windowsService.choiceOtherService(pozList);
        windowsService.choiceGatewayService(pozList);
        windowsService.choiceProxyTypeService(0);
        windowsService.enterTextInputProxyPortService(proxyPort);
        windowsService.openTabDescriptionAndEnterTextInDescriptionAndCommentService(description, comment);
        windowsService.clickButtonSaveService();
        BaseWebDriver.waitDownloadPage(driver);
    }
}
