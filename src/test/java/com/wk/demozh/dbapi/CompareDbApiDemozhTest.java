package com.wk.demozh.dbapi;

import com.wk.demozh.api.config.PropertiesApiDemozh;
import com.wk.demozh.api.json.customergroup.CustomerGroups;
import com.wk.demozh.dbapi.config.BaseTest;
import org.testng.annotations.Test;

public class CompareDbApiDemozhTest extends BaseTest {

    private CustomerGroups customerGroupApi;
    private CustomerGroups customerGroupDb;

    @Test
    public void compareDbApiCustomerGroup() throws Exception {
        int idCustomerGroup = PropertiesApiDemozh.getInstance().getIdCustomerGroup();
        customerGroupDb = compareDbApiDemozhSteps.getCustomerGroupAndCustomersDb(idCustomerGroup);
        customerGroupApi = compareDbApiDemozhSteps.getCustomerGroupAndCustomersApi(idCustomerGroup);
        compareDbApiDemozhSteps.compareCustomerGroupApiDb(customerGroupApi, customerGroupDb);
        compareDbApiDemozhSteps.compareCustomersInsideGroupsApiDb(customerGroupApi, customerGroupDb);
    }

}
