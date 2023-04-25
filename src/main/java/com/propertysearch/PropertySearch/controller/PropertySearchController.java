package com.propertysearch.PropertySearch.controller;

import com.propertysearch.PropertySearch.model.Property;
import com.propertysearch.PropertySearch.model.PropertySearchCriteria;
import com.propertysearch.PropertySearch.service.PropertySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertySearchController {

    @Autowired
    private PropertySearchService propertySearchService;

    @CrossOrigin(origins = {"http://localhost:3000","http://localhost:3000/property-search"})
    @GetMapping("/search")
    @ResponseBody
    public List<Property> searchProperties(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minSqrFootage,
            @RequestParam(required = false) Double maxSqrFootage,
            @RequestParam(required = false) Integer minBedrooms,
            @RequestParam(required = false) Integer maxBedrooms,
            @RequestParam(required = false) Integer minBathrooms,
            @RequestParam(required = false) Integer maxBathrooms
    ) {
        PropertySearchCriteria criteria = new PropertySearchCriteria();
        criteria.setLocation(location);
        criteria.setMinPrice(minPrice);
        criteria.setMaxPrice(maxPrice);
        criteria.setMinSqrFootage(minSqrFootage);
        criteria.setMaxSqrFootage(maxSqrFootage);
        criteria.setMinBedrooms(minBedrooms);
        criteria.setMaxBedrooms(maxBedrooms);
        criteria.setMinBathrooms(minBathrooms);
        criteria.setMaxBathrooms(maxBathrooms);

        return propertySearchService.search(criteria).collectList().block();
    }
}
