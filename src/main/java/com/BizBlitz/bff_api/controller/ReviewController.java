package com.BizBlitz.bff_api.controller;

import com.BizBlitz.bff_api.model.reviewDto.Review;
import com.BizBlitz.bff_api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bff/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        try {
            return reviewService.createReview(review);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Review creation failed: " + e.getMessage());
        }
    }
}
