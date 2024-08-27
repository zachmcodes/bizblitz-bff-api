package com.BizBlitz.bff_api.utility;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class K {
    public String sortedType(String sortType) {
        Map<String, String> sortedTypeMap = Map.of(
                "none", "",
                "rating", "rating",
                "best match", "best_match",
                "number of reviews", "review_count",
                "distance", "distance"
        );
        return sortedTypeMap.getOrDefault(sortType, "best_match");
    }

    public String sortedQuery(String sortQuery) {
        Map<String, String> sortedQueryMap = Map.of(
                "doctors", "doctors",
                "urgent cares", "urgent_cares",
                "emergency", "emergency_rooms",
                "chiropractors", "chiropractors",
                "physical therapists", "physical_therapists",
                "pharmacies", "pharmacies"
        );
        return sortedQueryMap.getOrDefault(sortQuery, "doctors");
    }
}
