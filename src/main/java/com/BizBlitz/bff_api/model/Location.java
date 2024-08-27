package com.BizBlitz.bff_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String address1;
    private String address2;
    private String address3;
    private String city;
    @JsonProperty("zip_code")
    private String zipCode;
    private String country;
    private String state;
}
