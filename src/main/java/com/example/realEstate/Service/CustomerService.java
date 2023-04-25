package com.example.realEstate.Service;

import com.example.realEstate.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAllCustomers();
    public void activateCustomer(Long id);

    public void deactivateCustomer(long id);
}
