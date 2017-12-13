package com.intuit.einvoiceserver.controller;

import com.intuit.einvoiceserver.model.Customer;
import com.intuit.einvoiceserver.repository.CustomerRepository;
import com.intuit.einvoiceserver.model.Invoice;
import com.intuit.einvoiceserver.repository.InvoiceRepository;
import com.intuit.einvoiceserver.model.LineItem;
import com.intuit.einvoiceserver.repository.LineItemRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0/")
public class EInvoiceController {
    @Autowired
    InvoiceRepository invoiceRepository;
	LineItemRepository lineItemRepository;
	@GetMapping("/invoices")
	public List<Invoice> getAllNotes() {
	    return invoiceRepository.findAll();
	}
	
    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody Invoice invoice) {
    	
        return invoiceRepository.save(invoice);
    }
	
    @GetMapping("/invoices/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable(value = "id") Long invoiceId) {
        Invoice invoice = invoiceRepository.findOne(invoiceId);
        if(invoice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(invoice);
    }
	
	 // Create a new invoice
	
}
