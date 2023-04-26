package com.example.realEstate.entity;

import com.example.realEstate.entity.enums.ListingType;
import com.example.realEstate.entity.enums.PropertyStatus;
import com.example.realEstate.entity.enums.PropertyType;
import com.example.realEstate.entity.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private double price;
    private int bedrooms;
    private int bathrooms;
    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;
    private double lotSize;
    private Date builtYear;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.STRING)
    private ListingType listingType;

    @OneToMany
    @JoinColumn(name = "property_id")
    private List<Photos> photos;

    @OneToOne
    @JoinColumn(name = "property_details_id")
    private PropertyDetails propertyDetails;

    @OneToMany
    private List<Offer> offers;

    @ManyToMany
    private List<Customer> customers;
}
