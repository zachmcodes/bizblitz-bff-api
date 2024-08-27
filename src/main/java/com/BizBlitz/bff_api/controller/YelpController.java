package com.BizBlitz.bff_api.controller;

import com.BizBlitz.bff_api.model.Business;
import com.BizBlitz.bff_api.model.SearchRequest;
import com.BizBlitz.bff_api.service.YelpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bff/businesses")
public class YelpController {

    private final YelpService yelpService;

    public YelpController(YelpService yelpService) {
        this.yelpService = yelpService;
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchBusinesses(@RequestBody SearchRequest searchRequest) {
        try {
            List<Business> businesses = yelpService.getBusinessDetails(
                    searchRequest.getLocation(),
                    searchRequest.getSortQuery(),
                    searchRequest.getSortType()
            );
            Map<String, Object> response = new HashMap<>();
            response.put("businesses", businesses);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Internal Server Error", "message", e.getMessage()));
        }
    }
}


