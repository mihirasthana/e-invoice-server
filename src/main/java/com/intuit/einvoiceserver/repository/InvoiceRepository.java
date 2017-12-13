package com.intuit.einvoiceserver.repository;

import com.intuit.einvoiceserver.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}