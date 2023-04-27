package com.propertysearch.PropertySearch.observer;

import com.propertysearch.PropertySearch.model.PropertySearchCriteria;
//observer interface, which can listen to search events.
public interface SearchObserver {
    void onSearchPerformed(PropertySearchCriteria criteria);
}
