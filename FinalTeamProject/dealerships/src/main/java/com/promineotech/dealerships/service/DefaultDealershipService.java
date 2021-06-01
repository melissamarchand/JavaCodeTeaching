package com.promineotech.dealerships.service;

import java.util.List;

import com.promineotech.dealerships.dao.CustomerDao;
import com.promineotech.dealerships.dao.LocationDao;
import com.promineotech.dealerships.dao.EmployeeDao;
import com.promineotech.dealerships.dao.TransactionDao;
import com.promineotech.dealerships.dao.VehicleDao;
import com.promineotech.dealerships.entity.Customer;
import com.promineotech.dealerships.entity.Location;
import com.promineotech.dealerships.entity.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDealershipService implements DealershipService{
    
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private VehicleDao vehicleDao;
    
    //==========================Customers===============================================

    @Override
    public List<Customer> listCustomers(){
        return customerDao.listAllCustomers();
    }
   
	@Override
    public void newCustomer(int customerID, String name, String address, String phone) {
        customerDao.newCustomer(customerID, name, address, phone);        
    }

    @Override
    public void updateCustomer(int customer_id, String name, String address, String phone){
        customerDao.updateCustomer(customer_id, name, address, phone);
    }

    @Override
     public void deleteCustomer(int customerID, String name, String address, String phone){
        customerDao.deleteCustomer(customerID, name, address, phone);
    }
    
}

    //==========================Transactions===============================================

    public List<Transaction> getTransactions(int transactionID){
       return transactionDao.getTransaction(transactionID);
    }

    @Override
    public void deleteTransaction(int transactionID) {
        transactionDao.deleteTransaction(transactionID);
    }

    @Override
    public void updateTransaction(int transactionID, int vehicleID, int customerID, int employeeID, int locationID,
            String date) {
        transactionDao.updateTransaction(transactionID, vehicleID, customerID, employeeID, locationID, date);
    }

    @Override
    public void newTransaction(int vehicleID, int customerID, int employeeID, int locationID, String date) {
        vehicleDao.updateVehicle(vehicleID, true);
        transactionDao.newTransaction(vehicleID, customerID, employeeID, locationID, date);        
    }


//==========================Locations===============================================
    
public List<Location> getLocation(int locationID){
    return locationDao.getLocation(locationID);
 }

 @Override
 public void deleteLocation(int locationID) {
	 locationDao.deleteLocation(locationID);
 }

 @Override
 public void updateLocation(int locationID, String location_name) {
	 locationDao.updateLocation(locationID, location_name);
     
 }

 @Override
 public void newLocation(int locationID, String location_name) {
     locationDao.newLocation(locationID, location_name);        
 }
 
 
 
 
}// end DefaultDealershipService class
