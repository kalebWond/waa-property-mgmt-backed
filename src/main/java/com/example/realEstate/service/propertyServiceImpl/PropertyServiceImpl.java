package com.example.realEstate.service.propertyServiceImpl;

import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.ListingType;
import com.example.realEstate.entity.enums.PropertyType;
import com.example.realEstate.repository.PropertyRepository;
import com.example.realEstate.service.PropertyService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<Property> findAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property findPropertyById(long id) {
        return propertyRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Property> findPropertiesByCriteria(
            Double minPrice,
            Double maxPrice,
            ListingType listingType,
            Integer minRooms,
            Integer maxRooms,
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
            predicates.add(builder.equal(root.get("propertyListing"), listingType));
        }
        if (minRooms != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("rooms"), minRooms));
        }
        if (maxRooms != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("rooms"), maxRooms));
        }
        if (propertyType != null) {
            predicates.add(builder.equal(root.get("propertyType"), propertyType));
        }
        if (city != null && !city.isEmpty()) {
            predicates.add(builder.like(root.get("address").get("city"), "%" + city + "%"));
        }
        if (state != null && !state.isEmpty()) {
            predicates.add(builder.like(root.get("address").get("state"), "%" + state + "%"));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}



