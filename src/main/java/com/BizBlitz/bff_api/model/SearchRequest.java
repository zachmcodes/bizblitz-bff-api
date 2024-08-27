package com.BizBlitz.bff_api.model;

public class SearchRequest {
    private String location;
    private String sortQuery;
    private String sortType;

    // Getters and setters

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSortQuery() {
        return sortQuery;
    }

    public void setSortQuery(String sortQuery) {
        this.sortQuery = sortQuery;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
