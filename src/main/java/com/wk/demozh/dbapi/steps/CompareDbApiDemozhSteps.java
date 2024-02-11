package com.wk.demozh.dbapi.steps;

import com.wk.demozh.api.json.customergroup.CustomerGroups;
import com.wk.demozh.api.json.customergroup.Customers;
import com.wk.demozh.api.json.customergroup.Manager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CompareDbApiDemozhSteps {

    private Connection connectionDemozh;


    public CompareDbApiDemozhSteps(Connection connectionDemozh) {
        this.connectionDemozh = connectionDemozh;
    }

    public CustomerGroups getCustomerGroupAndCustomersApi(int idCustomerGroup) {
        List<Customers> listCustomersApi = new ArrayList<Customers>();
        CustomerGroups customerGroupApi = new CustomerGroups(listCustomersApi);
        Manager manager = new Manager();
        //List<Customers> listCustomersTemp = new ArrayList<Customers>();
        List<Customers> listCustomersTemp;
        Customers customersTemp;
        Customers customersApi;

        Response response = given().
                pathParam("id", idCustomerGroup).
                when().
                get("/admin/customer/group/{id}").
                then().
                extract().response();

        Assert.assertEquals(response.statusCode(), 200, "compareDbApiCustomerGroup - StatusCode");

        customerGroupApi.setName(response.jsonPath().getString("name"));
        customerGroupApi.setDeleted(response.jsonPath().getBoolean("deletable"));
        manager.setId(response.jsonPath().getString("manager.id"));
        customerGroupApi.setManager(manager);
        listCustomersTemp = response.jsonPath().getList("customers", Customers.class);

        // getList - создаёт собственный не модифицированный список, поэтому необходимо переложить всё в свой
        for (int i = 0; i < listCustomersTemp.size(); i++) {
            customersTemp = listCustomersTemp.get(i);
            customersApi = new Customers();
            customersApi.setId(customersTemp.getId());
            customersApi.setName(customersTemp.getName());
            listCustomersApi.add(customersTemp);
        }
        return customerGroupApi;
    }

    public CustomerGroups getCustomerGroupAndCustomersDb(int idCustomerGroup) throws Exception {
        ResultSet resultSet;
        List<Customers> listCustomersDb = new ArrayList<Customers>();
        CustomerGroups customerGroupDb = new CustomerGroups(listCustomersDb);
        Manager manager = new Manager();
        Customers customers;

        Statement statement = connectionDemozh.createStatement();
        resultSet = statement.executeQuery("select * from customer_group where customer_group.id=" + idCustomerGroup);
        resultSet.next();
        if(resultSet.getRow() > 0) {
            customerGroupDb.setName(resultSet.getString("name"));
            customerGroupDb.setDeleted(resultSet.getBoolean("deletable"));
            manager.setId(resultSet.getString("manager_id"));
            resultSet.close();
            customerGroupDb.setManager(manager);

            resultSet = statement.executeQuery(
                    "select customer.id, customer.\"name\" from customer_group_membership \n" +
                            "left join customer on customer_group_membership.customer_id=customer.id \n" +
                            "where customer_group_membership.group_id=" + idCustomerGroup);
            while (resultSet.next()) {
                customers = new Customers();
                customers.setId(resultSet.getInt("id"));
                customers.setName(resultSet.getString("name"));
                listCustomersDb.add(customers);
            }

            resultSet.close();
            statement.close();
        }
        return customerGroupDb;
    }

    public void compareCustomerGroupApiDb(CustomerGroups customerGroupApi, CustomerGroups customerGroupDb) {
        Manager managerApi = customerGroupApi.getManager();
        Manager managerDb = customerGroupDb.getManager();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(customerGroupApi.getName(), customerGroupDb.getName(), "compareCustomerGroupApi - Name GroupCustomer");
        softAssert.assertEquals(customerGroupApi.isDeleted(), customerGroupDb.isDeleted(), "compareCustomerGroupApi - Deletable");
        softAssert.assertEquals(managerApi.getId(), managerDb.getId(), "compareCustomerGroupApi - Id Manager");
        softAssert.assertAll();
    }

    public void compareCustomersInsideGroupsApiDb(CustomerGroups customerGroupApi, CustomerGroups customerGroupDb) {
        List<Customers> listCustomersApi = customerGroupApi.getCustomers();
        List<Customers> listCustomersDb = customerGroupDb.getCustomers();

        Assert.assertEquals(listCustomersApi.size(), listCustomersDb.size(), "compareCustomersApiDb <> listCustomers.size");
        if (listCustomersApi.size() > 0) {
            Customers customerApi;
            Customers customerDb;

            SoftAssert softAssert = new SoftAssert();
            for (int i = 0; i < listCustomersApi.size(); i++) {
                customerApi = listCustomersApi.get(i);
                customerDb = listCustomersDb.get(i);
                softAssert.assertEquals(customerApi.getId(), customerDb.getId(), "compareCustomersApiDb - Id Customer[" + i + "]");
                softAssert.assertEquals(customerApi.getName(), customerDb.getName(), "compareCustomersApiDb - Name Customer[" + i + "]");
            }
            softAssert.assertAll();
        }
    }

}
