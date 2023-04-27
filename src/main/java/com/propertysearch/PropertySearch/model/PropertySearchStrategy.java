package com.propertysearch.PropertySearch.model;

public interface PropertySearchStrategy {
    boolean matchesCriteria(Property property, PropertySearchCriteria criteria);
}
