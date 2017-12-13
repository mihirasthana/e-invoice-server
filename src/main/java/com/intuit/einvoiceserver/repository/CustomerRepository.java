package com.intuit.einvoiceserver.repository;

import com.intuit.einvoiceserver.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
