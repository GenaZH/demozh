package com.wk.demozh.springdbapi.repository;

import com.wk.demozh.springdbapi.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface  CustomersRepository extends JpaRepository<Customers, Long> {

  @Query(value = "select customer.id, customer.\"name\" from customer_group_membership \n" +
            "left join customer on customer_group_membership.customer_id=customer.id \n" +
            "where customer_group_membership.group_id= :id", nativeQuery = true)
  List<Customers> getListCustomersForCustomerGroup(@Param("id") Long id);


}


