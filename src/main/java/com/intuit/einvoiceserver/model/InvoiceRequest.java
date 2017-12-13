package com.intuit.einvoiceserver.model;

import java.util.List;

public class InvoiceRequest {

	private Customer customer;
	private Invoice invoice;
	private List<LineItem> lineItems;
	public Customer getCustomer() {
		return customer;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	
}
