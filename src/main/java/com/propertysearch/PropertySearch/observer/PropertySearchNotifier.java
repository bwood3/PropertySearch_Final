package com.propertysearch.PropertySearch.observer;

import com.propertysearch.PropertySearch.model.PropertySearchCriteria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//responsible for managing the list of observers and notifying them of search events.
public class PropertySearchNotifier {
    private final List<SearchObserver> observers = new ArrayList<>();

    public void addObserver(SearchObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SearchObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(PropertySearchCriteria criteria) {
        for (SearchObserver observer : observers) {
            observer.onSearchPerformed(criteria);
        }
    }
}