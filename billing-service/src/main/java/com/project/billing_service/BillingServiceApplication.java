package com.project.billing_service;

import com.project.billing_service.DTOs.Customer;
import com.project.billing_service.DTOs.Product;
import com.project.billing_service.entities.Bill;
import com.project.billing_service.entities.ProductItem;
import com.project.billing_service.feign.CustomerRestClient;
import com.project.billing_service.feign.ProductRestClient;
import com.project.billing_service.repositories.BillRepository;
import com.project.billing_service.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient){


		return args -> {
			Collection<Customer> customers = customerRestClient.getCustomer().getContent();
			Collection<Product> products = productRestClient.getProduct().getContent();


			customers.forEach(customer->{
				Bill bills = Bill.builder()
						.customerId(customer.getId())
						.dateBilling(new Date())
						.build();
				billRepository.save(bills);

				products.forEach(product -> {
					productItemRepository.save(ProductItem.builder()
									.unitPrice(product.getPrice())
									.quantity(1+new Random().nextInt(10))
									.productId(product.getId())
									.bills(bills)
							.build());

				});
			});

		};
	}
}
