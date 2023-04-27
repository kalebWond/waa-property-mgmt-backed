package com.example.realEstate.service;

import com.example.realEstate.entity.Customer;
import com.example.realEstate.entity.Offer;
import com.example.realEstate.entity.Property;
import com.example.realEstate.entity.enums.OfferStatus;
import com.example.realEstate.entity.enums.UserStatus;
import com.example.realEstate.entity.httpdata.OfferRequest;
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
    public void makeOffer(OfferRequest offerRequest, long customer_id) {
        Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new RuntimeException("Customer not found"));
        Property property = propertyRepository.findById(offerRequest.getPropertyId()).orElseThrow(() -> new RuntimeException("Property not found"));

        Offer offer = new Offer();
        offer.setCustomer(customer);
        offer.setPrice(offerRequest.getPrice());
        offer.setOwnerId(property.getOwnerId());
        offer.setProperty(property);
        offer.setStatus(OfferStatus.WAITING);
        offer.setSubmittedAt(LocalDateTime.now());
        customer.getOffers().add(offer);

        customerRepository.save(customer);
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


    public List<Customer> findAllCustomers(){
//        var listCustomers =  customerRepository.findAll().stream().filter(e->e.);
        return customerRepository.sortByDateOfRegistrationDsc();
    }

    @Override
    public void activateCustomer(Long id) {
        var isCustomer= customerRepository.findById(id);
        if(isCustomer.isPresent()){
            isCustomer.get().setStatus(UserStatus.ACTIVE);
            customerRepository.save(isCustomer.get());

        }
    }

    @Override
    public void deactivateCustomer(long id){
        var isCustomer= customerRepository.findById(id);
        if(isCustomer.isPresent()){
            isCustomer.get().setStatus(UserStatus.DEACTIVE);
            customerRepository.save(isCustomer.get());
        }
    }

}
