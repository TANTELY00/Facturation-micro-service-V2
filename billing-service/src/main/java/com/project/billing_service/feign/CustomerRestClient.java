package com.project.billing_service.feign;

import com.project.billing_service.DTOs.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("/customers")
    public PagedModel<Customer> getCustomer();

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService" ,fallbackMethod = "getDefaultCustomer")
    public Customer getCustomerById(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id , Exception exception){
        return Customer.builder()
                .id(id)
                .name("default Name")
                .email("default email")
                .build();
    }

}
