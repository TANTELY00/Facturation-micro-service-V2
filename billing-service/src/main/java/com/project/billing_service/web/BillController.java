package com.project.billing_service.web;

import com.netflix.discovery.converters.Auto;
import com.project.billing_service.DTOs.Customer;
import com.project.billing_service.DTOs.Product;
import com.project.billing_service.entities.Bill;
import com.project.billing_service.feign.CustomerRestClient;
import com.project.billing_service.feign.ProductRestClient;
import com.project.billing_service.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBillId(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return  bill;
    }

}
