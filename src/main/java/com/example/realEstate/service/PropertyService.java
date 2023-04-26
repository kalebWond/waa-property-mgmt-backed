package com.example.realEstate.service;

import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Property;

import java.time.LocalDateTime;
import java.util.List;

public interface PropertyService {
    public Property save(Property property);
    public List<Property> getAllProperties();
    public Property getPropertyById(long id);
    public Property updatePropertyById(long id,Property property);

    public void deleteById(long id);
   public List<Offer> searchPropertyCriteria(Long id,String city, String state, double price, LocalDateTime submittedAt);

}
