package com.example.accessingdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.accessingdatajpa.repository")
public class AccessingDataJpaApplication {
	private static final PseudoMain mainBoucle = new PseudoMain();
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
		mainBoucle.mainBoucle();
	}

}
