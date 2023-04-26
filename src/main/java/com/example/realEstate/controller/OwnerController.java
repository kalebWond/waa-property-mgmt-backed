package com.example.realEstate.controller;

import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Property;
import com.example.realEstate.service.OwnerService;
import com.example.realEstate.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/owners")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class OwnerController {

    private final PropertyService propertyService;
    private final OwnerService ownerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}/properties")
    public List<Property> getAll(@PathVariable long id) {
        return propertyService.getAllProperties();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/properties")
    public Property save(@PathVariable long id, @RequestBody Property property) {
        return propertyService.save(property);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{OwnerId}/properties/{Id}")
    public Property getById(@PathVariable long id) {
        var property = propertyService.getPropertyById(id);
        return property;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}/properties/{id}")
    public void delete(@PathVariable int id) {
        propertyService.deleteById(id);
    }

    @PutMapping("{id}/properties/{pptId}")
    public void update(@PathVariable("pptId") int propertyId, @RequestBody Property property) {
        propertyService.updatePropertyById(propertyId,property);
    }

    @GetMapping("{id}/properties/{id}/offers/filter")
    public List<Offer> searchOffers(
            @PathVariable("id")Long id,
            @RequestParam(value = "price", required = false) double price,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "submittedAt",required = false) LocalDateTime submittedAt){
        return propertyService.searchPropertyCriteria(id, city, state, price, submittedAt);
    }




}
