package com.example.realEstate.service;

import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.ListingType;
import com.example.realEstate.entity.enums.PropertyType;
import com.example.realEstate.repository.PropertyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface PropertyService {
    public void addProperty(long ownerId, Property property);
    public List<Property> getAllPropertiesByOwnerId(long ownerId);
    public Property getPropertyById(long id);
    public Property updatePropertyById(long ownerId, long id,Property property);
    public void deleteByIdAndOwnerId(long id, long ownerId);
    public List<Offer> searchPropertyCriteria(Long id, Long pptId, String city, String state, Double price, LocalDateTime submittedAt);
    public List<Property> findPropertiesByCriteria(Double minPrice, Double maxPrice,
                                                   ListingType listingType, Integer minBedRooms,
                                                   Integer maxBedRooms, Double minBathRooms, Double maxBathrooms, PropertyType propertyType,
                                                   String city, String state);
    public List<Property> findPropertyStatus();

}
