package com.intuit.einvoiceserver.model;


import org.hibernate.validator.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
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
	
	@NotBlank
	private Double total_amount;
	
	@NotBlank
	private Date dueDate;
	
    @OneToMany(fetch = FetchType.EAGER,mappedBy="line_items",cascade = CascadeType.ALL)
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

	public Double getTotalAmount() {
		return total_amount;
	}

	public void setTotalAmount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}	
	
}
