package com.propertysearch.PropertySearch.model;

//this is a data class that holds search criteria -
//- for filtering properties in the PropertySearchService.
public class PropertySearchCriteria {
    private String location;
    private Double minPrice;
    private Double maxPrice;
    private Double minSqrFootage;
    private Double maxSqrFootage;
    private Integer minBedrooms;
    private Integer maxBedrooms;
    private Integer minBathrooms;
    private Integer maxBathrooms;
    private Integer bedrooms;

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    private Integer bathrooms;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinSqrFootage() {
        return minSqrFootage;
    }

    public void setMinSqrFootage(Double minSqrFootage) {
        this.minSqrFootage = minSqrFootage;
    }

    public Double getMaxSqrFootage() {
        return maxSqrFootage;
    }

    public void setMaxSqrFootage(Double maxSqrFootage) {
        this.maxSqrFootage = maxSqrFootage;
    }

    public Integer getMinBedrooms() {
        return minBedrooms;
    }

    public void setMinBedrooms(Integer minBedrooms) {
        this.minBedrooms = minBedrooms;
    }

    public Integer getMaxBedrooms() {
        return maxBedrooms;
    }

    public void setMaxBedrooms(Integer maxBedrooms) {
        this.maxBedrooms = maxBedrooms;
    }

    public Integer getMinBathrooms() {
        return minBathrooms;
    }

    public void setMinBathrooms(Integer minBathrooms) {
        this.minBathrooms = minBathrooms;
    }

    public Integer getMaxBathrooms() {
        return maxBathrooms;
    }

    public void setMaxBathrooms(Integer maxBathrooms) {
        this.maxBathrooms = maxBathrooms;
    }

    //added for logging
    @Override
    public String toString() {
        return "PropertySearchCriteria{" +
                "location='" + location + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minSqrFootage=" + minSqrFootage +
                ", maxSqrFootage=" + maxSqrFootage +
                ", minBedrooms=" + minBedrooms +
                ", maxBedrooms=" + maxBedrooms +
                ", minBathrooms=" + minBathrooms +
                ", maxBathrooms=" + maxBathrooms +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                '}';
    }
}
