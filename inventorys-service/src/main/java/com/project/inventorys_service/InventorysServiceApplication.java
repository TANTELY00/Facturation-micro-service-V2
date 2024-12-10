package com.project.inventorys_service;

import com.project.inventorys_service.entities.Product;
import com.project.inventorys_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventorysServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorysServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
				productRepository.save(Product.builder()
								.id(UUID.randomUUID().toString())
								.name("Printer")
								.price(2000)
								.quantity(10)
						.build());

			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Computer")
					.price(3000)
					.quantity(10)
					.build());

			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Smart Phone")
					.price(16000)
					.quantity(10)
					.build());

			productRepository.findAll().forEach(product -> {
				System.out.println(product.getId());
				System.out.println(product.getName());
				System.out.println(product.getPrice());
				System.out.println(product.getQuantity());

			});
		};
	}
}
