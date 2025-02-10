package com.luisma.curso.springboot.jpa.springboot_jpa_relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luisma.curso.springboot.jpa.springboot_jpa_relationship.entities.Client;
import com.luisma.curso.springboot.jpa.springboot_jpa_relationship.entities.Invoice;
import com.luisma.curso.springboot.jpa.springboot_jpa_relationship.repositories.ClientRepository;
import com.luisma.curso.springboot.jpa.springboot_jpa_relationship.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ManyToOne();
	}

	public void ManyToOne(){
		Client client = new Client("Luis", "Miguel");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compra de un producto", 1000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println(invoiceDb);
	}

}
