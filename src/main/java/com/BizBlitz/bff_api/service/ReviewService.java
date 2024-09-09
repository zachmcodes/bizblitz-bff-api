package com.BizBlitz.bff_api.service;

import com.BizBlitz.bff_api.model.reviewDto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ReviewService {

    private final RestTemplate restTemplate;

    @Value("${review.api.baseurl}")
    private String reviewApiBaseUrl;

    @Autowired
    public ReviewService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> createReview(Review review) {
        String url = reviewApiBaseUrl + "/api/reviews";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Review> reviewToAdd = new HttpEntity<>(review, headers);

        try {
            return restTemplate.exchange(url, HttpMethod.POST, reviewToAdd, String.class);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Review Creation failed: " + e.getMessage());
        }
    }
}
