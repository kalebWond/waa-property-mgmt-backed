package com.example.realEstate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends User {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "owner_properties")
    private List<Property> properties;
}
