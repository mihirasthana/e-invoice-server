package com.intuit.einvoiceserver.repository;

import com.intuit.einvoiceserver.model.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	//TODO implement limit
	@Query("select distinct u.name from Customer u where u.name like ?1%")
	  List<String> nameStartsWith(String name);
}
