package com.BizBlitz.bff_api.service;

import com.BizBlitz.bff_api.model.logindto.LoginRequest;
import com.BizBlitz.bff_api.model.logindto.RegisterRequest;
import com.BizBlitz.bff_api.model.reviewDto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    @Value("${login.api.baseurl}")
    private String loginApiBaseUrl;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserByUsername(String username) {
        String url = loginApiBaseUrl + "/api/users/" + username;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        return response.getBody();
    }

    public ResponseEntity<String> registerUser(RegisterRequest registerRequest) {
        String url = loginApiBaseUrl + "/api/users/register";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<RegisterRequest> request = new HttpEntity<>(registerRequest, headers);

        try {
            return restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Registration failed: " + e.getMessage());
        }
    }

    public ResponseEntity<String> loginUser(LoginRequest loginRequest) {
        String url = loginApiBaseUrl + "/api/auth/login";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest, headers);

        try {
            return restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Login failed: " + e.getMessage());
        }
    }
}
