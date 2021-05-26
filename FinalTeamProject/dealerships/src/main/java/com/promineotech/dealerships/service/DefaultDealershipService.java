package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.dao.CustomerDao;
import com.promineotech.dealerships.dao.DealershipDao;
import com.promineotech.dealerships.dao.EmployeeDao;
import com.promineotech.dealerships.dao.VehicleDao;
import com.promineotech.dealerships.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionExecution;

@Service
public class DefaultDealershipService implements DealershipService{
    
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DealershipDao dealeshipDao;

    @Autowired
    private TransactionExecution transactionDao;

    @Autowired
    private VehicleDao vehicleDao;

    public List<Customer> listCustomers(){
        List<Customer> customers = customerDao.listAllCustomers();
        return customers;
    }

    public void updateCustomer(int customer_id, String name, String address, String phone){
        customerDao.updateCustomer(customer_id, name, address, phone);
    }

}
