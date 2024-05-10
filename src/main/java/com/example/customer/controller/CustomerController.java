package com.example.customer.controller;


import com.example.customer.dto.RoomsDTO;
import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @Autowired
    RestTemplate restTemplate;



    @PostMapping("/signup")
    public ResponseEntity<Customer> newUser(@RequestBody Customer customer) {

        Customer newcustomer = customerService.saveNewCustomer(customer);


        return ResponseEntity.ok(newcustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long Id) {

       Customer customerinfo = customerService.getUserById(Id);

        return new ResponseEntity<>(customerinfo, HttpStatus.OK);
    }


    @GetMapping("/getlistings")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public ResponseEntity<List> getlistings() {


        ResponseEntity<List> response = restTemplate.exchange("http://localhost:8084/api/v1/hotel/listings", HttpMethod.GET,
                    null, List.class);

            return (ResponseEntity<List>) response;


    }




}
