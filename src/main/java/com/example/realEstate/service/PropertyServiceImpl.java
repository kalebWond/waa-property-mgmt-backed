package com.example.realEstate.service;

import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Owner;
import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.ListingType;
import com.example.realEstate.entity.enums.PropertyStatus;
import com.example.realEstate.entity.enums.PropertyType;
import com.example.realEstate.repository.OwnerRepository;
import com.example.realEstate.repository.PropertyRepository;
import com.example.realEstate.repository.SearchOffersDao;
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

@Service
@RequiredArgsConstructor
class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final OwnerRepository ownerRepository;
    private final SearchOffersDao searchOffersDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProperty(long ownerId, Property property) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.getProperties().add(property);
        ownerRepository.save(owner);
    }

    @Override
    public List<Property> getAllPropertiesByOwnerId(long ownerId) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        return owner.getProperties();
    }

    @Override
    public Property getPropertyById(long id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public Property updatePropertyById(long ownerId, long id, Property property) {
        Property updatedProperty= propertyRepository.findById(id).get();
        property.setId(updatedProperty.getId());
        updatedProperty = property;
        propertyRepository.save(updatedProperty);
        return updatedProperty;
    }

    @Override
    public void deleteByIdAndOwnerId(long id, long ownerId) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        Property property = propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Property not found"));
        if(!owner.getProperties().contains(property)) {
            throw new RuntimeException("Property not found");
        }
        owner.getProperties().remove(property);
        ownerRepository.save(owner);
    }

    @Override
    public List<Offer> searchPropertyCriteria(Long id, Long pptId, String city, String state,
                                              Double price, LocalDateTime submittedAt) {
        // TO-DO
        // NEED TO BE FILTERED BY OWNER ID AS WELL
        return searchOffersDao.searchPropertyCriteria(pptId, city, state, price,submittedAt);
    }

    @Override
    public List<Property> findPropertiesByCriteria(
            Double minPrice,
            Double maxPrice,
            ListingType listingType,
            Integer minBedRooms,
            Integer maxBedRooms,
            Double minBathRooms,
            Double maxBathRooms,
            PropertyType propertyType,
            String city,
            String state) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> query = builder.createQuery(Property.class);
        Root<Property> root = query.from(Property.class);
        List<Predicate> predicates = new ArrayList<>();

        if (minPrice != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if (maxPrice != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        if (listingType != null) {
            predicates.add(builder.equal(root.get("listingType"), listingType));
        }
        if (minBedRooms != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("bedrooms"), minBedRooms));
        }
        if (maxBedRooms != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("bedrooms"), maxBedRooms));
        }
        if (minBathRooms != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("bathrooms"), minBathRooms));
        }
        if (maxBathRooms != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("bathrooms"), maxBathRooms));
        }
        if (propertyType != null) {
            predicates.add(builder.equal(root.get("propertyType"), propertyType));
        }
        if (city != null && !city.isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get("address").get("city")), "%" + city.toLowerCase() + "%"));
        }
        if (state != null && !state.isEmpty()) {
            predicates.add(builder.like(builder.lower(root.get("address").get("state")), "%" + state.toLowerCase() + "%"));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }

}