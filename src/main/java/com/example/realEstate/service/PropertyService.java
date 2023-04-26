package com.example.realEstate.service;

import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.ListingType;
import com.example.realEstate.entity.enums.PropertyType;
import java.time.LocalDateTime;
import java.util.List;

public interface PropertyService {
    public Property save(Property property);
    public List<Property> getAllProperties();
    public Property getPropertyById(long id);
    public Property updatePropertyById(long id,Property property);
    public Property findPropertyById(long Id);
    public void deleteById(long id);
    public List<Offer> searchPropertyCriteria(Long id,String city, String state, double price, LocalDateTime submittedAt);
    public List<Property> findPropertiesByCriteria(Double minPrice, Double maxPrice,
                                                   ListingType listingType, Integer minRooms,
                                                   Integer maxRooms, PropertyType propertyType,
                                                   String city, String state);

}
