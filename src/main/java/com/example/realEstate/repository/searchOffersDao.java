package com.example.realEstate.repository;

import com.example.realEstate.entity.Offer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class searchOffersDao {
    private final EntityManager em;

    public List<Offer> searchPropertyCriteria(Long propertyId, String city, String state,
                                               Double price, LocalDateTime submittedAt){ // You can make a search request object for the input
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Offer> criteriaQuery = criteriaBuilder.createQuery(Offer.class);
        List<Predicate> predicates = new ArrayList<>();

        // select * from Offer
        Root<Offer> root = criteriaQuery.from(Offer.class);

        Predicate offerPredicate = criteriaBuilder.equal(root.get("property"), propertyId);
        predicates.add(offerPredicate);

        if(city !=null){
            Predicate cityPredicate = criteriaBuilder.like(root.get("property").get("address").get("city"),"%" + city + "%");
            predicates.add(cityPredicate);
        }
        if(state!=null){
            Predicate statePredicate = criteriaBuilder.like(root.get("property").get("address").get("state"),state);
            predicates.add(statePredicate);
        }
        if(price!=null){
            Predicate pricePredicate = criteriaBuilder.equal(root.get("price"),(double)price);
            predicates.add(pricePredicate);
        }
        if(submittedAt!=null){
            Predicate statePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("submittedAt") ,submittedAt);
            predicates.add(statePredicate);
        }
        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<Offer> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
