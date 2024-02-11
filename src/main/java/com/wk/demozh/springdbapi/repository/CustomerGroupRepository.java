package com.wk.demozh.springdbapi.repository;

import com.wk.demozh.springdbapi.entity.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup, Long> {

}





