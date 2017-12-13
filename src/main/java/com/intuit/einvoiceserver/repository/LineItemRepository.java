package com.intuit.einvoiceserver.repository;

import com.intuit.einvoiceserver.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long>{

}