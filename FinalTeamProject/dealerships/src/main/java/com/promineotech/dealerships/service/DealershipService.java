package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Transaction;

public interface DealershipService {

    /**
     * Customer Functions 
     * @return
     */

    List<Customer> listCustomers();
    void updateCustomer(int customer_id, String name, String address, String phone);
    void deleteCustomer(int customer_id, String name, String address, String phone);

    /**
     * Transaction Functions 
     * @param transactionID
     * @return
     */

    public List<Transaction> getTransactions(int transactionID);
    public void deleteTransaction(int transactionID);
    public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeID, int locationID, String date);
    public void newTransaction(int vehicleID, int customerID, int employeeID, int locationID, String date);

    
    
}
