package com.example.customermanager.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.customermanager.repository.CustomerRepository;
import com.example.customermanager.model.CustomerEntity;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> findAll() {
        return (List<CustomerEntity>) customerRepository.findAll();
    }

    public CustomerEntity findById(final int id) {
        return customerRepository.findById(id);
    }

    public void save(final CustomerEntity customer) {
        //cho nay can phai bat
        customerRepository.persist(customer);
    }

    public void update(final CustomerEntity customer) {
        // check if not exist -> throw excpetion
        CustomerEntity customerDb = customerRepository.findById(customer.getId());
        customerDb.setName(customer.getName());
        customerDb.setAddress(customer.getAddress());
        customerDb.setEmail(customer.getEmail());
        customerDb.setGender(customer.getGender());
        customerDb.setFavorites(customer.getFavorites());
        customerDb.setPosition(customer.getPosition());

        customerRepository.persist(customerDb);
    }

    public void delete(final int id) {
        CustomerEntity customer = customerRepository.findById(id);
        if (customer != null) {
            customerRepository.delete(customer);
        }

    }
}