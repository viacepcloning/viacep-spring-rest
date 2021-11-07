package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * ViacepApplication is a simple postal address REST webservice.
 * 
 * @author marco.mangan@gmail.com
 *
 */
@SpringBootApplication
public class ViacepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViacepApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner startup(AddressRepository addressRepository) {
//		return args -> {
//			addressRepository
//					.save(new Address("90110170", "Rua Dezessete de Junho", "", "Menino Deus", "Porto Alegre", "RS"));
//		};
//	}
}
