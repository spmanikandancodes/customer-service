package com.example.customer.service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Override
    public Customer saveNewCustomer(Customer customer) {

        kafkaProducerService.sendSignupMessage("Signup Successful, Welcome to blahblah Reservation");
        return customerRepository.save(customer);
    }

    @Override
    public Customer getUserById(Long Id) {
       Optional <Customer> customerinfo = customerRepository.findById(Id);
        return customerinfo.get();

    }

}

