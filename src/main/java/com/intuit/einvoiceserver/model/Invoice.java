package com.intuit.einvoiceserver.model;


import org.hibernate.validator.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "invoices")
@EntityListeners(AuditingEntityListener.class)

public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "cust_id")
    private Customer customer;
	
	@NotNull
	private Double total_amount;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date due_date;
	
    @OneToMany(fetch = FetchType.EAGER, mappedBy="invoice", cascade = CascadeType.ALL)
    private Set<LineItem> lineItems;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	
}
