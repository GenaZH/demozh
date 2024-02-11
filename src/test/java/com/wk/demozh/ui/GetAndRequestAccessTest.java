package com.wk.demozh.ui;

import com.wk.demozh.ui.config.BaseTest;
import com.wk.demozh.ui.config.PropertiesUI;
import com.wk.demozh.ui.steps.MenuBaseTopDownSteps;
import com.wk.demozh.ui.steps.MenuUserBaseLeftSteps;
import org.testng.Assert;
import org.testng.annotations.*;

public class GetAndRequestAccessTest extends BaseTest {
    private MenuBaseTopDownSteps menuBaseTopDownSteps;
    private MenuUserBaseLeftSteps menuUserBaseLeftSteps;

    public void deleteGetAndRequestAccess() {
        authorizationSteps.clickButtonLogout();
        authorizationSteps.autorizationEnterLoginPasswordTokenFull
                (PropertiesUI.getInstance().getUserLogin(), PropertiesUI.getInstance().getUserPassword(), PropertiesUI.getInstance().getUserToken());
        menuBaseTopDownSteps.clickButtonModeUser();
        // удаляем открытые доступы и заявки
        menuBaseTopDownSteps.deleteAllOpenedAccesses(true);
        menuBaseTopDownSteps.deleteAllRequestedAccesses(true);
    }

    @BeforeClass
    public void beginClassTest() {
        menuBaseTopDownSteps = new MenuBaseTopDownSteps(driver);
        menuUserBaseLeftSteps = new MenuUserBaseLeftSteps(driver);
    }

    @AfterClass
    public void endMethodTest() {
        deleteGetAndRequestAccess();
        authorizationSteps.clickButtonLogout();
    }

    @BeforeMethod
    public void beginMethodTest() {
        deleteGetAndRequestAccess();
    }


    public void approveAdminAndCheckingUser(String textComment) {
        // заходим под админом и подтверждаем
        authorizationSteps.autorizationEnterLoginPasswordTokenFull
                (PropertiesUI.getInstance().getAdminLogin(), PropertiesUI.getInstance().getAdminPassword(), PropertiesUI.getInstance().getAdminToken());
        menuBaseTopDownSteps.clickButtonModeAdmin();
        Assert.assertTrue(menuBaseTopDownSteps.absenceRowsPerPageAdminRequestedAccesses());
        menuBaseTopDownSteps.approveAllRequestedAccesses(false, "AutoTest Approve Requested Accesses Through Services Groups Comment");
        Assert.assertFalse(menuBaseTopDownSteps.absenceRowsPerPageAdminRequestedAccesses());
        authorizationSteps.clickButtonLogout();

        // заходим под юзером
        authorizationSteps.autorizationEnterLoginPasswordTokenFull
                (PropertiesUI.getInstance().getUserLogin(), PropertiesUI.getInstance().getUserPassword(), PropertiesUI.getInstance().getUserToken());
        menuBaseTopDownSteps.clickButtonModeUser();
        // проверяем
        Assert.assertTrue(menuBaseTopDownSteps.absenceRowsPerPageUserOpenedAccesses());
    }

    @Test
    public void addGetAccessUserThroughChoiceCustomers() {
        menuUserBaseLeftSteps.fillAndAddGetAccessThroughChoiceCustomers(0, "AutoTest Get Access Through Choice Customers Justification");
        Assert.assertTrue(menuBaseTopDownSteps.absenceRowsPerPageUserOpenedAccesses());
    }

    @Test
    public void addGetAccessUserThroughChoiceServicesGroups() {
        menuUserBaseLeftSteps.clickUserMenuGetAccessAndAddGetAccessThroughChoiceServicesGroups(0, "AutoTest Get Access Through Choice Services Groups Justification");
        Assert.assertTrue(menuBaseTopDownSteps.absenceRowsPerPageUserOpenedAccesses());
    }
// должен быть кому-то в подчинении, то есть мне назначен суперивзорю
// В Access service должны быть нескоько груп сервисов, а ниже хотя бы одна
    @Test
    public void addRequestAccessThroughCustomersUserAndApproveAdmin() {
        menuUserBaseLeftSteps.clickUserMenuRequestAccessAndAddRequestAccessThroughCustomers(1, "AutoTest Request Access Through Choice Customers Justification");
        Assert.assertTrue(menuBaseTopDownSteps.absenceRowsPerPageUserRequestedAccesses());
        authorizationSteps.clickButtonLogout();
        approveAdminAndCheckingUser("AutoTest Approve Requested Accesses Through Choice Customers Comment");
    }

    @Test
    public void addRequestAccessThroughServicesGroupsUserAndApproveAdmin() {
        menuUserBaseLeftSteps.clickUserMenuRequestAccessAndAddRequestAccessThroughServicesGroups(2,"AutoTest Request Access Through Services Groups Justification");
        Assert.assertTrue(menuBaseTopDownSteps.absenceRowsPerPageUserRequestedAccesses());
        authorizationSteps.clickButtonLogout();
        approveAdminAndCheckingUser("AutoTest Approve Requested Accesses Through Services Groups Comment");
    }


}
