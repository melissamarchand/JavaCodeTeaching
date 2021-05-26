package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.dao.CustomerDao;
import com.promineotech.dealerships.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDealershipService implements DealershipService{
    
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private EmployeeDao employeeDao;

    List<Customer> listCustomers(){
        List<Customer> customers = customerDao.listAllCustomers();
        int num = customers.length();
        System.out.print(num)
        return customers;
    }

}
