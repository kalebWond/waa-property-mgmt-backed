package com.example.realEstate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Owner extends User {
    @ManyToMany
    @JoinTable(name = "owner_property")
    private List<Property> properties;


    //added
    private LocalDate dateOfRegistration;

}
