package com.BizBlitz.bff_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Business {
    private String id;

    @JsonProperty("image_url")
    private String imageUrl;
    private String name;
    private String url;
    @JsonProperty("review_count")
    private int reviewCount;
    private double rating;
    private Coordinates coordinates;
    private Location location;
    private String phone;
    @JsonProperty("display_phone")
    private String displayPhone;
    @JsonProperty("business_hours")
    private List<BusinessHours> businessHours;

}
