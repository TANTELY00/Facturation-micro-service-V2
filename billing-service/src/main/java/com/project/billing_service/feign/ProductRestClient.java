package com.project.billing_service.feign;

import com.project.billing_service.DTOs.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient{

    @GetMapping("/products")
    public PagedModel<Product> getProduct();
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id);

}
