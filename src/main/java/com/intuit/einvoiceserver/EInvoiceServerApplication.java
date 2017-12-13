package com.intuit.einvoiceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EInvoiceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EInvoiceServerApplication.class, args);
	}
}
