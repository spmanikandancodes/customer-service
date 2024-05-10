package com.example.customer.service;

import com.example.customer.entity.Customer;

import java.util.Optional;

public interface CustomerService {

   Customer saveNewCustomer(Customer customer);

   Customer getUserById(Long id);



}
