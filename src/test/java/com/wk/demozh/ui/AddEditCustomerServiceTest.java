package com.wk.demozh.ui;

import com.wk.demozh.ui.config.BaseTest;
import com.wk.demozh.ui.config.PropertiesUI;
import com.wk.demozh.ui.steps.MenuAdminBaseLeftSteps;
import com.wk.demozh.ui.steps.MenuBaseRightSteps;
import com.wk.demozh.ui.steps.MenuBaseTopDownSteps;
import com.wk.demozh.ui.webdriver.BaseWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddEditCustomerServiceTest extends BaseTest {
    private MenuBaseTopDownSteps menuBaseTopDownSteps;
    private MenuAdminBaseLeftSteps adminBaseLeftMenuSteps;
    private MenuBaseRightSteps menuBaseRightSteps;


    private void autorizationAdmin() {
        authorizationSteps.clickButtonLogout();
        authorizationSteps.autorizationEnterLoginPasswordTokenFull
                (PropertiesUI.getInstance().getAdminLogin(), PropertiesUI.getInstance().getAdminPassword(), PropertiesUI.getInstance().getAdminToken());
        menuBaseTopDownSteps.clickButtonModeAdmin();
    }

    private void deleteTestCustomer() {  // очищаем тестовых заказчиков
        menuBaseTopDownSteps.deleteTestCustomer(PropertiesUI.getInstance().getCustomerNameNew());
        menuBaseTopDownSteps.deleteTestCustomer(PropertiesUI.getInstance().getCustomerNameEdit());
    }

    private void deleteTestService() {  // очищаем тестовые сервисы
        menuBaseTopDownSteps.deleteTestService(PropertiesUI.getInstance().getServiceNameNew());
        menuBaseTopDownSteps.deleteTestService(PropertiesUI.getInstance().getServiceNameEdit());
    }

    private void autorizationDeleteTestData() {
        autorizationAdmin();
        deleteTestCustomer();
        deleteTestService();
    }

    @BeforeClass
    public void beginClassTest() {
        menuBaseTopDownSteps = new MenuBaseTopDownSteps(driver);
        adminBaseLeftMenuSteps = new MenuAdminBaseLeftSteps(driver);
        menuBaseRightSteps = new MenuBaseRightSteps(driver);
        autorizationDeleteTestData();
    }

    @AfterClass
    public void endClassTest() {
        autorizationDeleteTestData();
        authorizationSteps.clickButtonLogout();
    }

    @BeforeMethod
    public void beginMethodTest() {
        autorizationAdmin();
    }

    @AfterMethod
    public void endMethodTest() {
        authorizationSteps.clickButtonLogout();
    }

    @Test (enabled = false)
    public void addEditCustomer() {
        adminBaseLeftMenuSteps.clickAdminMenuAddCustomer();
        adminBaseLeftMenuSteps.fillAndAddCustomer
                (PropertiesUI.getInstance().getCustomerNameNew(),
                        PropertiesUI.getInstance().getCustomerCountryNew(),
                        PropertiesUI.getInstance().getCustomerCityNew(),
                        0,
                        "AutoTest Add Customer Comment");
        menuBaseTopDownSteps.inputTextSearch(PropertiesUI.getInstance().getCustomerNameNew());
        Assert.assertTrue(menuBaseTopDownSteps.absenceQuantityRowsPerPage());

        menuBaseRightSteps.clickButtonEditRow();
        adminBaseLeftMenuSteps.fillAndAddCustomer
                (PropertiesUI.getInstance().getCustomerNameEdit(),
                        PropertiesUI.getInstance().getCustomerCountryEdit(),
                        PropertiesUI.getInstance().getCustomerCityEdit(),
                        1,
                        "AutoTest Edit Customer Comment");
        menuBaseTopDownSteps.inputTextSearch(PropertiesUI.getInstance().getCustomerNameEdit());
        Assert.assertTrue(menuBaseTopDownSteps.absenceQuantityRowsPerPage());
    }

    @Test //(enabled = false)
    public void addEditService() {
        //for (int x = 0; x < 3000; x = x + 1) {
            //String serviceNew = "Service" + BaseWebDriver.getRandomNumberInt(1, 999999); int pzl = BaseWebDriver.getRandomNumberInt(0, 2);

        String serviceNew = PropertiesUI.getInstance().getServiceNameNew();
        String serviceEdit = PropertiesUI.getInstance().getServiceNameEdit();

        adminBaseLeftMenuSteps.clickAdminMenuAddService();
        adminBaseLeftMenuSteps.fillAndAddServiceAndSave
                (serviceNew,
                        serviceNew,
                        0,
                        BaseWebDriver.getRandomNumberInt(10, 255) + "." + BaseWebDriver.getRandomNumberInt(0, 255) + "." + BaseWebDriver.getRandomNumberInt(0, 255) + "." + BaseWebDriver.getRandomNumberInt(0, 255),
                        Integer.toString(BaseWebDriver.getRandomNumberInt(1000, 65535)),
                        Integer.toString(BaseWebDriver.getRandomNumberInt(1000, 65535)),
                        "AutoTest Description " + serviceNew,
                        "AutoTest Comment " + serviceNew);
        //}
        menuBaseTopDownSteps.inputTextSearch(serviceNew);
        Assert.assertTrue(menuBaseTopDownSteps.absenceQuantityRowsPerPage());

        menuBaseRightSteps.clickButtonEditRow();
        adminBaseLeftMenuSteps.fillAndAddServiceAndSave
                (serviceEdit,
                        serviceEdit,
                        1,
                        BaseWebDriver.getRandomNumberInt(10, 255) + "." + BaseWebDriver.getRandomNumberInt(0, 255) + "." + BaseWebDriver.getRandomNumberInt(0, 255) + "." + BaseWebDriver.getRandomNumberInt(0, 255),
                        Integer.toString(BaseWebDriver.getRandomNumberInt(1000, 65535)),
                        Integer.toString(BaseWebDriver.getRandomNumberInt(1000, 65535)),
                        "AutoTest Description for " + serviceEdit,
                        "AutoTest Comment for " + serviceEdit);
        menuBaseTopDownSteps.inputTextSearch(serviceEdit);
        Assert.assertTrue(menuBaseTopDownSteps.absenceQuantityRowsPerPage());
    }


}
