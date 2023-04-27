package com.propertysearch.PropertySearch.observer;

import com.propertysearch.PropertySearch.model.PropertySearchCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//logs the search criteria when a search event occurs.
@Component
public class SearchLogger implements SearchObserver{
    private static final Logger logger = LoggerFactory.getLogger(SearchLogger.class);

    @Override
    public void onSearchPerformed(PropertySearchCriteria criteria) {
        logger.info("Property search performed with criteria: {}", criteria.toString());
    }
}
