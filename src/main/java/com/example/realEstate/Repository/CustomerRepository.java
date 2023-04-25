package com.example.realEstate.Repository;

import com.example.realEstate.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @Query("select c from Customer c order by c.dateOfRegistration desc limit 10")
    public List<Customer> sortByDateOfRegistrationDsc();
//    public List<Customer> findByDateOfRegistration

}
