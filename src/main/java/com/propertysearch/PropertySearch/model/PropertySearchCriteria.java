package com.propertysearch.PropertySearch.model;

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
}
