package com.propertysearch.PropertySearch.model;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
//implements the RealEstatePropertySearchStrategy interface
public class RealEstatePropertySearchStrategy implements PropertySearchStrategy{
    @Override
    //Check if the property matches the given search criteria by comparing each criterion
    //if the criterion is not specified (null), we consider it a match
    //otherwise, compare the property's value with the given criteria value
    //the property matches the criteria only if all comparisons are true
    public boolean matchesCriteria(Property property, PropertySearchCriteria criteria) {
        return (criteria.getLocation() == null || property.getLocation().equalsIgnoreCase(criteria.getLocation()))
                && (criteria.getMinPrice() == null || property.getPrice() >= criteria.getMinPrice())
                && (criteria.getMaxPrice() == null || property.getPrice() <= criteria.getMaxPrice())
                && (criteria.getMinSqrFootage() == null || property.getSqrFootage() >= criteria.getMinSqrFootage())
                && (criteria.getMaxSqrFootage() == null || property.getSqrFootage() <= criteria.getMaxSqrFootage())
                && (criteria.getMinBedrooms() == null || property.getBedrooms() >= criteria.getMinBedrooms())
                && (criteria.getMaxBedrooms() == null || property.getBedrooms() <= criteria.getMaxBedrooms())
                && (criteria.getMinBathrooms() == null || property.getBathrooms() >= criteria.getMinBathrooms())
                && (criteria.getMaxBathrooms() == null || property.getBathrooms() <= criteria.getMaxBathrooms())
                && (criteria.getBedrooms() == null || Objects.equals(property.getBedrooms(), criteria.getBedrooms()))
                && (criteria.getBathrooms() == null || Objects.equals(property.getBathrooms(), criteria.getBathrooms()));
    }
}
