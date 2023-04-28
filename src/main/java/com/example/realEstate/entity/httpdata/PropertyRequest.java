package com.example.realEstate.entity.httpdata;

import com.example.realEstate.entity.*;
import com.example.realEstate.entity.enums.ListingType;
import com.example.realEstate.entity.enums.PropertyStatus;
import com.example.realEstate.entity.enums.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class PropertyRequest {
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    private double price;
    private int bedrooms;
    private double bathrooms;

    private double lotSize;
    private LocalDate builtYear;

    @Enumerated(EnumType.STRING)
    private ListingType listingType;

    private Address address;

    private PropertyDetails propertyDetails;

    private long ownerId;
}
