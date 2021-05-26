package com.promineotech.dealerships.controller;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/Dealerships")
public interface DealershipController {
    

    @GetMapping("Customers")
    ResponseEntity<List<Customer>> listCustomers();

    @PutMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void updateCustomer(
        @RequestParam(required = true) int customer_id, 
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String address, 
        @RequestParam(required = false) String phone);
}
