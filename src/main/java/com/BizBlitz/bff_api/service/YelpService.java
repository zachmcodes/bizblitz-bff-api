package com.BizBlitz.bff_api.service;

import com.BizBlitz.bff_api.model.Business;
import com.BizBlitz.bff_api.utility.K;
import com.BizBlitz.bff_api.wrapper.YelpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class YelpService {

    private final RestTemplate restTemplate;

    @Autowired
    public YelpService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Autowired
    private K k;

    @Value("${yelp.api.baseurl}")
    private String baseUrl;

    @Value("${yelp.api.key}")
    private String apiKey;

    public List<Business> getBusinessDetails(String location, String sortQuery, String sortType) throws Exception {
        // Construct the Yelp API URL with query parameters
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("term", k.sortedQuery(sortQuery))
                .queryParam("location", location)
                .queryParam("sort_by", k.sortedType(sortType))
                .toUriString();

        System.out.println(url);
        System.out.println(sortQuery + " " + sortType);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<YelpResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, YelpResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody().getBusinesses();
        } else {
            throw new Exception("Failed to fetch data from Yelp API");
        }
    }
}
