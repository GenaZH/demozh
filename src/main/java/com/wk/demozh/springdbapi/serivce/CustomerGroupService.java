package com.wk.demozh.springdbapi.serivce;

import com.wk.demozh.springdbapi.entity.CustomerGroup;
import com.wk.demozh.springdbapi.entity.Customers;
import com.wk.demozh.springdbapi.repository.CustomerGroupRepository;
import com.wk.demozh.springdbapi.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerGroupService{

    @Autowired CustomerGroupRepository customerGroupRepository;
    @Autowired CustomersRepository customerRepository;

    public CustomerGroup findById(Long id) {
        customerGroupRepository.findById(id).get().setCustomers(customerRepository.getListCustomersForCustomerGroup(id));
        return customerGroupRepository.findById(id).get();
    }

    public List<CustomerGroup> findAllCustomerGroupWithoutCustomer() {
        return customerGroupRepository.findAll();
    }

    public List<CustomerGroup> findAllCustomerGroupWithCustomer() {
        List<CustomerGroup> listCustomerGroup = customerGroupRepository.findAll();

        for (CustomerGroup customerGroup : listCustomerGroup) {
            customerGroup.setCustomers(customerRepository.getListCustomersForCustomerGroup(customerGroup.getId()));
        }
        return listCustomerGroup;
    }

}


