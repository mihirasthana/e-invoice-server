package com.intuit.einvoiceserver.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.einvoiceserver.model.Customer;
import com.intuit.einvoiceserver.model.Invoice;
import com.intuit.einvoiceserver.model.InvoiceRequest;
import com.intuit.einvoiceserver.model.LineItem;
import com.intuit.einvoiceserver.repository.CustomerRepository;
import com.intuit.einvoiceserver.repository.InvoiceRepository;
import com.intuit.einvoiceserver.repository.LineItemRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class EInvoiceController {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
	LineItemRepository lineItemRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/invoices")
	public List<Invoice> getAllInvoices() {
	    return invoiceRepository.findAll();
	}
	
	
	//TODO
	//Rearrange and neat
    @PostMapping("/invoices")
    public List<LineItem> createInvoice(@Valid @RequestBody InvoiceRequest invoiceRequest) {
        // service layer
    	Customer customer = invoiceRequest.getCustomer();
    	
    	if(!customerRepository.exists((invoiceRequest.getCustomer().getId()))) {
        	customerRepository.save(invoiceRequest.getCustomer());
        }
    	Invoice invoice = invoiceRequest.getInvoice();
    	invoice.setCustomer(customer);
    	Long invoiceId = invoiceRepository.saveAndFlush(invoice).getId();
    	
    	List<LineItem> lineItems = invoiceRequest.getLineItems();
    	lineItems.forEach((lI) -> lI.setInvoiceId(invoiceId));
    	
    	return lineItemRepository.save(lineItems);
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
