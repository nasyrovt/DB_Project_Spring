package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(ModeleRepository modeleRepository, VeloRepository repository) {
		return (args) -> {
			modeleRepository.save(new Modele("VTT", 1.5f));
			// save a few customers
			repository.save(new Velo(1L, AllEnums.Etat.ETAT_OK, LocalDateTime.now(), 1));
//			repository.save(new Velo("Chloe", "O'Brian"));
//			repository.save(new Velo("Kim", "Bauer"));
//			repository.save(new Velo("David", "Palmer"));
//			repository.save(new Velo("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Velo customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Velo customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByModeleName("VTT").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("");
		};
	}

}