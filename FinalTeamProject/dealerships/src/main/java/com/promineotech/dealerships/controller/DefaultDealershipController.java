package com.promineotech.dealerships.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DefaultDealershipController implements DealershipController{
    
    @autowire
    private DealershipService dealershipService;

    @Override
    @GetMapping("Customers")
    public responseEntity<List<Customer>> listCustomers(){
        log.info("customer list requested");
        List<Customer> customers = dealershipService.listCustomers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
}
