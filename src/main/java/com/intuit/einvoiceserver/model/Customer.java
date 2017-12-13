package com.intuit.einvoiceserver.model;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)

public class Customer implements Serializable{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotBlank
    private String name;

	@NotBlank
    private String email;
    
/*    @OneToMany(targetEntity=Invoice.class, fetch = FetchType.LAZY)
    private Set<Invoice> invoices;    */
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

/*	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}*/
	
}
