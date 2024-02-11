package com.wk.demozh.api.steps;

import com.wk.demozh.api.config.PropertiesApiDemozh;
import com.wk.demozh.api.json.customergroup.CustomerGroups;
import com.wk.demozh.api.json.customergroup.Customers;
import com.wk.demozh.api.json.customergroup.Manager;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CustomerGroupSteps {

    public CustomerGroups createCustomerGroups(String nameCustomerGroup) {
        Customers customer1 = new Customers();
        customer1.setId(21);
        customer1.setName("");
        Customers customer2 = new Customers();
        customer2.setId(16);
        customer2.setName("");
        List<Customers> customers = new ArrayList<Customers>();
        customers.add(customer1);
        customers.add(customer2);

        CustomerGroups customerGroups = new CustomerGroups(customers);
        customerGroups.setCustomers(customers);
        customerGroups.setDeleted(true);
        Manager manager = new Manager();
        manager.setId(PropertiesApiDemozh.getInstance().getIdManagerGroup());      // henadzi.zherela
        manager.setName(PropertiesApiDemozh.getInstance().getNameManagerGroup());  // Henadzi Zherela
        customerGroups.setManager(manager);
        customerGroups.setId(0);
        customerGroups.setName(nameCustomerGroup);
        return customerGroups;
    }

    private String createCustomerGroupsJson(CustomerGroups customerGroups) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(customerGroups);
    }

    private void compareReceivedResponseWithOriginalData
            (Response response, int assertStatusCode, String nameCustomerGroup, String nameMetod) {
        int customerGroupId;
        String customerGroupName;
        String managerId;
        String managerName;
        int statusCode = response.statusCode();

        if (statusCode == assertStatusCode) {
            if ((statusCode == 200) || (statusCode == 201)) {
                customerGroupId = response.jsonPath().getInt("id");
                customerGroupName = response.jsonPath().getString("name");
                managerId = response.jsonPath().getString("manager.id");
                managerName = response.jsonPath().getString("manager.name");

                String idManagerGroup = PropertiesApiDemozh.getInstance().getIdManagerGroup();
                String nameManagerGroup = PropertiesApiDemozh.getInstance().getNameManagerGroup();

                SoftAssert softAssert = new SoftAssert();
                softAssert.assertNotEquals(customerGroupId, 0, nameMetod + " - Id GroupCustomer");
                softAssert.assertEquals(customerGroupName, nameCustomerGroup, nameMetod + " - Name GroupCustomer");
                softAssert.assertEquals(managerId, idManagerGroup, nameMetod + " - Id Manager");
                softAssert.assertEquals(managerName, nameManagerGroup, nameMetod + " - Name Manager");
                softAssert.assertAll();
            }
        } else {
            Assert.assertEquals(statusCode, assertStatusCode, nameMetod + " - StatusCode");
        }
    }

    public Response getCustomerGroup(int idGroup) {
        return given().
                pathParam("id", idGroup).
                when().
                get("/admin/customer/group/{id}").
                then().
                extract().response();
    }

    public void compareGetCustomerGroup(int idGroup, String nameGroup) {
        Response response = getCustomerGroup(idGroup);
        compareReceivedResponseWithOriginalData(response, 200, nameGroup, "assertGetCustomerGroup");
    }

    public Response addPostCustomerGroup(CustomerGroups customerGroups) throws IOException {
        String customerGroupJson = createCustomerGroupsJson(customerGroups);
        return given().
                contentType(ContentType.JSON).
                body(customerGroupJson).
                when().
                post("/admin/customer/group").
                then().
                extract().response();
    }

    public int validateResponseAddPostCustomerGroup(CustomerGroups customerGroups, String customerGroupFirst) throws IOException {
        Response response = addPostCustomerGroup(customerGroups);
        compareReceivedResponseWithOriginalData(response, 201, customerGroupFirst, "addPostCustomerGroup");
        return response.jsonPath().getInt("id");
    }

    public Response editNamePutCustomerGroup(int idGroup, CustomerGroups customerGroups) throws IOException {
        String customerGroupJson = createCustomerGroupsJson(customerGroups);
        return given().
                contentType(ContentType.JSON).
                body(customerGroupJson).
                pathParam("id", idGroup).
                when().
                put("/admin/customer/group/{id}").
                then().
                extract().response();
    }

    public void compareAfterEditPutNameCustomerGroup(int idGroup, CustomerGroups customerGroups, String customerGroupSecond) throws IOException {
        Response response = editNamePutCustomerGroup(idGroup, customerGroups);
        compareReceivedResponseWithOriginalData(response, 200, customerGroupSecond, "compareAfterEditPutNameCustomerGroup");
    }

    public void deleteByIdCustomerGroup(int idGroup) {
        given().
                pathParam("id", idGroup).
                when().
                delete("/admin/customer/group/{id}").
                then().
                statusCode(204);
    }

    public void deleteByNameCustomerGroup(String nameCustomerGroup) {
        given().
                contentType(ContentType.JSON).
                body("{\"filter\": \"" + nameCustomerGroup + "\"}").
                when().
                delete("/admin/customer/group/all/filter/simple").
                then().
                statusCode(204);
    }

    public int simpleDeleteAddCustomerGroup(CustomerGroups customerGroup) throws IOException {
        deleteByNameCustomerGroup(customerGroup.getName());
        Response response = addPostCustomerGroup(customerGroup);
        Assert.assertEquals(response.statusCode(), 201, "simpleDeleteAddCustomerGroup - StatusCode");
        return response.jsonPath().getInt("id");
    }

}
