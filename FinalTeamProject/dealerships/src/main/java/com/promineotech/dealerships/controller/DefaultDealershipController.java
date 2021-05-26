package com.promineotech.dealerships.controller;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.service.DealershipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDealershipController implements DealershipController{
    
    @Autowired
    private DealershipService dealershipService;

    @Override
    @GetMapping("Customers")
    public ResponseEntity<List<Customer>> listCustomers(){
        log.info("customer list requested");
        List<Customer> customers = dealershipService.listCustomers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    public void updateCustomer(int customer_id, String name, String address, String phone){
        dealershipService.updateCustomer(customer_id, name, address, phone);
    }
}
