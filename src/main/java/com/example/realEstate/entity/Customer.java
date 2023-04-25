package com.example.realEstate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer extends User {
    @ManyToMany
    @JoinTable(name = "favorites")
    private List<Property> properties;
    @OneToMany(mappedBy = "customer")
    private List<Offer> offers;

    //added
    private LocalDate dateOfRegistration;

}
