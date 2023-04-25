package com.example.realEstate.Service.Impl;

import com.example.realEstate.Repository.PropertyRepository;
import com.example.realEstate.Service.PropertyService;
import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.PropertyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Override
    public List<Property> findPropertyStatus() {
      return propertyRepository.findAllByPropertyStatus(PropertyStatus.RENTED);
    }
}
