package com.intuit.einvoiceserver.model;


import org.hibernate.validator.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invoice_line_items")
@EntityListeners(AuditingEntityListener.class)

public class LineItem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
	