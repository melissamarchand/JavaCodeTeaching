package com.promineotech.dealerships.dao;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerDao {

    public List<Customer> ListAllCustomers() {
        String sql = "SELECT * FROM customers";
        //DoSQL
        return null;
    }
    
}
