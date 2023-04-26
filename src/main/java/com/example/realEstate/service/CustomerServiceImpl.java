package com.example.realEstate.service;

import com.example.realEstate.entity.Customer;
import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.OfferStatus;
import com.example.realEstate.repository.CustomerRepository;
import com.example.realEstate.repository.OfferRepository;
import com.example.realEstate.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository customerRepository;
    final PropertyRepository propertyRepository;
    final OfferRepository offerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, PropertyRepository propertyRepository, OfferRepository offerRepository) {
        this.customerRepository = customerRepository;
        this.propertyRepository = propertyRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void addToFavorites(long customer_id, long property_id) {
        Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new RuntimeException("Customer not found"));
        Property property = propertyRepository.findById(property_id).orElseThrow(() -> new RuntimeException("Property not found"));
        customer.getProperties().add((property));
        customerRepository.save(customer);
    }

    @Override
    public List<Property> getFavoriteProperties(long customer_id) {
        Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customer.getProperties();
    }

    @Override
    public void removeFromFavorites(long customer_id, long property_id) {
        Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new RuntimeException("Customer not found"));
        Property property = propertyRepository.findById(property_id).orElseThrow(() -> new RuntimeException("Property not found"));
        if(!customer.getProperties().contains(property)) {
            throw new RuntimeException("Property not found");
        }
        customer.getProperties().remove(property);
        customerRepository.save(customer);
    }

    @Override
    public void makeOffer(Offer offer) {
        offer.setStatus(OfferStatus.WAITING);
        offer.setSubmittedAt(LocalDateTime.now());
        offerRepository.save(offer);
    }

    @Override
    public List<Offer> getOffers(long customer_id) {
        Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customer.getOffers();
    }

    @Override
    public Offer getOfferById(long customer_id, long offer_id) {
        Offer offer = offerRepository.findByIdAndCustomerId(offer_id, customer_id);
        return offer;
    }

    @Override
    public void withdrawOffer(long customerId, long id) {
        Offer offer = offerRepository.findByIdAndCustomerId(id, customerId);
        if(offer == null) {
            throw new RuntimeException("Offer not found");
        }
        offerRepository.delete(offer);
    }

    @Override
    public void updateOfferPrice(long customerId, long id, double price) {
        Offer offer = offerRepository.findByIdAndCustomerId(id, customerId);
        if(offer == null) {
            throw new RuntimeException("Offer not found");
        }
        offer.setPrice(price);
        offerRepository.save(offer);
    }


}
