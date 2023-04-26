package com.example.realEstate.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {
    @ManyToMany
    @JoinTable(name = "favorites")
    private List<Property> properties;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Offer> offers;

}
