package com.project.billing_service.feign;

import com.project.billing_service.DTOs.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("/customers")
    public PagedModel<Customer> getCustomer();

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);

}
