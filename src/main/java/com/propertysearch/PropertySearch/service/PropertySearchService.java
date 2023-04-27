package com.propertysearch.PropertySearch.service;

import com.propertysearch.PropertySearch.client.PropertyClient;
import com.propertysearch.PropertySearch.model.Property;
import com.propertysearch.PropertySearch.model.RealEstatePropertySearchStrategy;
import com.propertysearch.PropertySearch.model.PropertySearchCriteria;
import com.propertysearch.PropertySearch.observer.PropertySearchNotifier;
import com.propertysearch.PropertySearch.observer.SearchLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PropertySearchService {

    private final PropertySearchNotifier searchNotifier;

    //inject
    //used to make HTTP requests to property listing API
    private final PropertyClient propertyClient;
    //inject
    private final RealEstatePropertySearchStrategy searchStrategy;

    //constructor injection to provide dependencies
    @Autowired
    public PropertySearchService(PropertyClient propertyClient, RealEstatePropertySearchStrategy searchStrategy, PropertySearchNotifier searchNotifier, SearchLogger loggingObserver) {
        this.propertyClient = propertyClient;
        this.searchStrategy = searchStrategy;
        this.searchNotifier = searchNotifier;
        this.searchNotifier.addObserver(loggingObserver);
    }

    //search for properties that match the provided criteria using the specified search strategy
    //flux used for nonblocking
    public Flux<Property> search(PropertySearchCriteria criteria) {
        searchNotifier.notifyObservers(criteria); // Notify observers when a search is performed.
        //Fetch properties from the PropertyClient and filter them using the search strategy's matchesCriteria method
        //only properties that match the criteria will be included in the result
        return propertyClient.getProperties().filter(property -> searchStrategy.matchesCriteria(property, criteria));
    }
}
