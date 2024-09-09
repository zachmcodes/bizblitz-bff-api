package com.BizBlitz.bff_api.model.reviewDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {

    private Long userId;
    private String businessId;
    private String reviewText;
    private int rating;
}
