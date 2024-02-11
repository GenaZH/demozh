package com.wk.demozh.api;

import com.wk.demozh.api.config.BaseTest;
import com.wk.demozh.api.config.PropertiesApiDemozh;
import com.wk.demozh.api.json.customergroup.CustomerGroups;
import com.wk.demozh.api.steps.CustomerGroupSteps;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomersGroupApiTest extends BaseTest {
    private CustomerGroupSteps customersGroupSteps;
    private CustomerGroups objectCustomerGroupsFirst;
    private CustomerGroups objectCustomerGroupsSecond;


    @BeforeClass
    public void beginTestCustomerGroup() {
        connectRestAssured();
        
        customersGroupSteps = new CustomerGroupSteps();
        objectCustomerGroupsFirst = customersGroupSteps.createCustomerGroups(PropertiesApiDemozh.getInstance().getCustomerGroupFirst());
        objectCustomerGroupsSecond = customersGroupSteps.createCustomerGroups(PropertiesApiDemozh.getInstance().getCustomerGroupSecond());
    }

    @AfterClass(alwaysRun = true) // alwaysRun = true означает что запускаться всегда
    public void endTestCustomerGroup() {
        // удаление по name
        customersGroupSteps.deleteByNameCustomerGroup(PropertiesApiDemozh.getInstance().getCustomerGroupFirst());
        customersGroupSteps.deleteByNameCustomerGroup(PropertiesApiDemozh.getInstance().getCustomerGroupSecond());
    }

    @Test
    public void addCustomerGroup() throws IOException {
        int customerGroupId;
        String customerGroupFirst = PropertiesApiDemozh.getInstance().getCustomerGroupFirst();

        customersGroupSteps.deleteByNameCustomerGroup(PropertiesApiDemozh.getInstance().getCustomerGroupFirst());

        customerGroupId = customersGroupSteps.validateResponseAddPostCustomerGroup(objectCustomerGroupsFirst, customerGroupFirst);
        customersGroupSteps.compareGetCustomerGroup(customerGroupId, customerGroupFirst);
    }

    @Test
    public void addDuplicateCustomerGroup() throws IOException {
        customersGroupSteps.simpleDeleteAddCustomerGroup(objectCustomerGroupsFirst);

        Response response = customersGroupSteps.addPostCustomerGroup(objectCustomerGroupsFirst);
        Assert.assertEquals(response.statusCode(), 400, "addDuplicateCustomerGroup - StatusCode");
    }

    @Test
    public void editNameCustomerGroup() throws IOException {
        int customerGroupId;
        String customerGroupSecond = PropertiesApiDemozh.getInstance().getCustomerGroupSecond();

        customerGroupId = customersGroupSteps.simpleDeleteAddCustomerGroup(objectCustomerGroupsFirst);

        customersGroupSteps.compareAfterEditPutNameCustomerGroup(customerGroupId, objectCustomerGroupsSecond, customerGroupSecond);
        customersGroupSteps.compareGetCustomerGroup(customerGroupId, customerGroupSecond);
    }

    @Test
    public void deleteByIdCustomerGroup() throws IOException {
        int customerGroupId;

        customerGroupId = customersGroupSteps.simpleDeleteAddCustomerGroup(objectCustomerGroupsFirst);

        customersGroupSteps.deleteByIdCustomerGroup(customerGroupId);

        Response response = customersGroupSteps.getCustomerGroup(customerGroupId);
        Assert.assertEquals(response.statusCode(), 400, "deleteByIdCustomerGroup - StatusCode");
    }

    @Test
    public void groupDeleteByNameCustomerGroup() throws IOException {
        Response response;
        int customerGroupIdFirst = customersGroupSteps.simpleDeleteAddCustomerGroup(objectCustomerGroupsFirst);
        int customerGroupIdSecond = customersGroupSteps.simpleDeleteAddCustomerGroup(objectCustomerGroupsSecond);

        customersGroupSteps.deleteByNameCustomerGroup(PropertiesApiDemozh.getInstance().getCustomerGroupSimilarName());

        response = customersGroupSteps.getCustomerGroup(customerGroupIdFirst);
        Assert.assertEquals(response.statusCode(), 400, "groupDeleteByNameCustomerGroup - StatusCodeFirst");
        response = customersGroupSteps.getCustomerGroup(customerGroupIdSecond);
        Assert.assertEquals(response.statusCode(), 400, "groupDeleteByNameCustomerGroup - StatusCodeSecond");
    }

}
