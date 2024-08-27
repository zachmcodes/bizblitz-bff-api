package com.BizBlitz.bff_api.wrapper;

import com.BizBlitz.bff_api.model.Business;

import java.util.List;

public class YelpResponse {
    private List<Business> businesses;

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
}
