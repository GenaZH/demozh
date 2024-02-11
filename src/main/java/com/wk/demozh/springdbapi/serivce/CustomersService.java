package com.wk.demozh.springdbapi.serivce;

import com.wk.demozh.springdbapi.entity.Customers;
import com.wk.demozh.springdbapi.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomersService {

    @Autowired CustomersRepository customersRepository;

    public Customers findById(Long id) {
        return customersRepository.findById(id).get();
    }

    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    public List<Customers> getListCustomersForCustomerGroup(Long id){
        return customersRepository.getListCustomersForCustomerGroup(id);
    }

}
