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

    @GetMapping("/search")
    @ResponseBody
    @CrossOrigin(origins = {"https://propertylistingfinal-production.up.railway.app", "http://localhost:3000"})
    public List<Property> searchProperties(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minSqrFootage,
            @RequestParam(required = false) Double maxSqrFootage,
            @RequestParam(required = false, defaultValue = "0") Integer minBedrooms,
            @RequestParam(required = false, defaultValue = "2147483647") Integer maxBedrooms,
            @RequestParam(required = false, defaultValue = "0") Integer minBathrooms,
            @RequestParam(required = false, defaultValue = "2147483647") Integer maxBathrooms
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
