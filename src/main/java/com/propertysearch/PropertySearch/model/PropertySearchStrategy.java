package com.propertysearch.PropertySearch.model;

//interface that defines the contract for filtering --
// -- properties based on the user's search criteria.
public interface PropertySearchStrategy {
    boolean matchesCriteria(Property property, PropertySearchCriteria criteria);
}
