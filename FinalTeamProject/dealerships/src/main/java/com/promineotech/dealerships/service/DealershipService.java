package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;

public interface DealershipService {

    List<Customer> listCustomers();

    void updateCustomer(int customer_id, String name, String address, String phone);
    
}
