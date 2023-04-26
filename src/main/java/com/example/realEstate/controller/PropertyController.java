package com.example.realEstate.controller;

import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.ListingType;
import com.example.realEstate.entity.enums.PropertyType;
import com.example.realEstate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable("id") long id) {
        return propertyService.findPropertyById(id);
    }

    @GetMapping("all")
    public List<Property> getAllProperties() {
        return propertyService.findAllProperties();
    }

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public List<Property> getProperties(@RequestParam(required = false) Double minPrice,
                                        @RequestParam(required = false) Double maxPrice,
                                        @RequestParam(required = false) ListingType listingType,
                                        @RequestParam(required = false) Integer minRooms,
                                        @RequestParam(required = false) Integer maxRooms,
                                        @RequestParam(required = false) PropertyType propertyType,
                                        @RequestParam(required = false) String city,
                                        @RequestParam(required = false) String state){
        return propertyService.findPropertiesByCriteria(minPrice, maxPrice, listingType, minRooms, maxRooms, propertyType, city, state);
    }

}
