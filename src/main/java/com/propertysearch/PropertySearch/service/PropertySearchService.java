package com.propertysearch.PropertySearch.service;


import com.propertysearch.PropertySearch.client.PropertyClient;
import com.propertysearch.PropertySearch.model.Property;
import com.propertysearch.PropertySearch.model.PropertySearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
// service package is used to separate the concerns
// in a Spring Boot application. The service layer contains the business logic of
// app, and repo layer is responsible for data access.
// Separating these concerns makes your code more modular and maintainable.

@Service
public class PropertySearchService {
    private final PropertyClient propertyClient;
    @Autowired
    public PropertySearchService(PropertyClient propertyClient) {
        this.propertyClient = propertyClient;
    }

    public Flux<Property> search(PropertySearchCriteria criteria) {
        return propertyClient.getProperties().filter(property -> matchesCriteria(property, criteria));
    }

    private boolean matchesCriteria(Property property, PropertySearchCriteria criteria) {
        return (criteria.getLocation() == null || property.getLocation().equalsIgnoreCase(criteria.getLocation()))
                && (criteria.getMinPrice() == null || property.getPrice() >= criteria.getMinPrice())
                && (criteria.getMaxPrice() == null || property.getPrice() <= criteria.getMaxPrice())
                && (criteria.getMinSqrFootage() == null || property.getSqrFootage() >= criteria.getMinSqrFootage())
                && (criteria.getMaxSqrFootage() == null || property.getSqrFootage() <= criteria.getMaxSqrFootage())
                && (criteria.getMinBedrooms() == null || property.getBedrooms() >= criteria.getMinBedrooms())
                && (criteria.getMaxBedrooms() == null || property.getBedrooms() <= criteria.getMaxBedrooms())
                && (criteria.getMinBathrooms() == null || property.getBathrooms() >= criteria.getMinBathrooms())
                && (criteria.getMaxBathrooms() == null || property.getBathrooms() <= criteria.getMaxBathrooms());
    }

//    public List<Property> searchProperties(String location, Double minPrice, Double maxPrice, Double minSqrFootage, Double maxSqrFootage, Integer minBedrooms, Integer maxBedrooms, Integer minBathrooms, Integer maxBathrooms) {
//        return propertyRepository.findAll((Specification<Property>) (root, criteriaQuery, criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//
//            if (location != null) {
//                predicates.add(criteriaBuilder.equal(root.get("location"), location));
//            }
//
//            if (minPrice != null) {
//                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
//            }
//
//            if (maxPrice != null) {
//                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
//            }
//
//            if (minSqrFootage != null) {
//                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("sqrFootage"), minSqrFootage));
//            }
//
//            if (maxSqrFootage != null) {
//                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("sqrFootage"), maxSqrFootage));
//            }
//
//            if (minBedrooms != null) {
//                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("bedrooms"), minBedrooms));
//            }
//
//            if (maxBedrooms != null) {
//                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("bedrooms"), maxBedrooms));
//            }
//
//            if (minBathrooms != null) {
//                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("bathrooms"), minBathrooms));
//            }
//
//            if (maxBathrooms != null) {
//                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("bathrooms"), maxBathrooms));
//            }
//
//            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        });
//    }
}
