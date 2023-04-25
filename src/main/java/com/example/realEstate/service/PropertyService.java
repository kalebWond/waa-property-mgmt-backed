package com.example.realEstate.service;

import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.ListingType;
import com.example.realEstate.entity.enums.PropertyType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {

    public List<Property> findAllProperties();

    public Property findPropertyById(long Id);

    public List<Property> findPropertiesByCriteria(Double minPrice, Double maxPrice,
                                                   ListingType listingType, Integer minRooms,
                                                   Integer maxRooms, PropertyType propertyType,
                                                   String city, String state);
}

