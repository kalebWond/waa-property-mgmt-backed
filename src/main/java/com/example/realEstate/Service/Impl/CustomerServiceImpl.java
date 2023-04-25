package com.example.realEstate.Service.Impl;

import com.example.realEstate.Repository.CustomerRepository;
import com.example.realEstate.Service.CustomerService;
import com.example.realEstate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> findAllCustomers(){
//        var listCustomers =  customerRepository.findAll().stream().filter(e->e.);
        return customerRepository.sortByDateOfRegistrationDsc();
    }

    @Override
    public void activateCustomer(Long id) {
       var isCustomer= customerRepository.findById(id);
       if(isCustomer.isPresent()){
           isCustomer.get().setActivated(true);
           customerRepository.save(isCustomer.get());

       }
    }


    @Override
    public void deactivateCustomer(long id){
        var isCustomer= customerRepository.findById(id);
        if(isCustomer.isPresent()){
            isCustomer.get().setActivated(false);
            customerRepository.save(isCustomer.get());
        }
    }
}

