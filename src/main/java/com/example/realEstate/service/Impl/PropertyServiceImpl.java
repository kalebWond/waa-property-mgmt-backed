package com.example.realEstate.service.Impl;

import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Property;
import com.example.realEstate.repository.PropertyRepository;
import com.example.realEstate.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;


    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(long id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public Property updatePropertyById(long id, Property property) {
        Property updatedProperty= propertyRepository.findById(id).get();
        updatedProperty =property;
        return updatedProperty;
    }

    @Override
    public void deleteById(long id) {
        propertyRepository.deleteById(id);

    }

    @Override
    public List<Offer> searchPropertyCriteria(Long id, String city, String state,
                                              double price, LocalDateTime submittedAt) {
        return null;
    }




}
