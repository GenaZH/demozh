package com.wk.demozh.springdbapi;

import com.wk.demozh.springdbapi.config.Configurationn;
import com.wk.demozh.springdbapi.config.PropertiesSpringDemozh;
import com.wk.demozh.springdbapi.entity.CustomerGroup;
import com.wk.demozh.springdbapi.entity.Customers;
import com.wk.demozh.springdbapi.serivce.CustomerGroupService;
import com.wk.demozh.springdbapi.serivce.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertNotNull;

@ContextConfiguration(classes = Configurationn.class)
@SpringBootTest(classes = SpringCompareDbApiDemozhApplication.class)
public class SpringCompareDbApiDemozhTest extends AbstractTestNGSpringContextTests { // AbstractTransactionalTestNGSpringContextTests

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomerGroupService customerGroupService;
    @Autowired
    private CustomersService customersService;

    private String urlApiCustomerGroup =       // https://192.168.85.85:8082/admin/customer/group/{id}
            PropertiesSpringDemozh.getInstance().getBaseUrlApi() + ":" + PropertiesSpringDemozh.getInstance().getPortApi() + "/admin/customer/group/{id}";

    public void compareDbApiCustomerGroup(Long id) {
        CustomerGroup customerGroupApi, customerGroupBD;

        customerGroupBD = customerGroupService.findById(id);
        assertNotNull(customerGroupBD);

        customerGroupApi = restTemplate.getForObject(urlApiCustomerGroup, CustomerGroup.class, id);
        assertNotNull(customerGroupApi);

        assertThat(customerGroupApi, is(customerGroupBD));
    }

    @Test
    public void verifyDbCustomerGroupAllCustomers() {

        List<Customers> listCustomers = customersService.findAll();
        CustomerGroup customerGroupBD = customerGroupService.findById(1L);

        assertNotNull(customerGroupBD);
        assertThat(customerGroupBD.getId(), equalTo(1L));
        assertThat(customerGroupBD.getName(), is("All Customers"));
        assertThat(customerGroupBD.getCustomers().size(), equalTo(listCustomers.size()));
    }

    @Test
    public void verifyApiCustomerGroupAllCustomers() {

        List<Customers> listCustomers = customersService.findAll();
        CustomerGroup customerGroupApi = restTemplate.getForObject(urlApiCustomerGroup, CustomerGroup.class, 1);

        assertNotNull(customerGroupApi);
        assertThat(customerGroupApi.getId(), equalTo(1L));
        assertThat(customerGroupApi.getName(), is("All Customers"));
        assertThat(customerGroupApi.getCustomers().size(), equalTo(listCustomers.size()));
    }

    @Test
    public void compareDbApiAnyCustomerGroup() {
        compareDbApiCustomerGroup(PropertiesSpringDemozh.getInstance().getIdCustomerGroup());
    }

    @Test
    public void compareDbApiCustomerGroupAllCustomers() {
        compareDbApiCustomerGroup(1L);
    }


}
