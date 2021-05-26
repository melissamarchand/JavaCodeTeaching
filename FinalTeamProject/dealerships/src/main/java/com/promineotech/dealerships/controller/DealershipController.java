package com.promineotech.dealerships.controller;

@RequestMapping("/Dealerships")
public interface DealershipController {
    

    @GetMapping("Customers")
    List<Customer> listCustomers();
}
