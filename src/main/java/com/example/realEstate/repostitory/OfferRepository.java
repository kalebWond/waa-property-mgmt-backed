package com.example.realEstate.repostitory;

import com.example.realEstate.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("select o from Offer o where o.id = :id AND o.customer.id = :customerId")
    Offer findByIdAndCustomerId(long id, long customerId);
}
