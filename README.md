# bizblitz-bff-api
BFF API

Overview

The bff-api (Backend for Frontend) acts as a gateway for the mobile client, aggregating data from various backend services like login-api, review-api, and external APIs like Yelp.

Features

    •    Orchestrates calls between the mobile UI and backend services.
    •    Aggregates data from multiple sources.
    •    Handles authentication and data processing before sending responses to the mobile client.

Installation

    1.    Prerequisites:
    •    Java 11+
    •    Maven or Gradle
    2.    Setup:
    •    Clone the repository:
    git clone https://github.com/yourusername/bff-api.git
    •    Navigate to the project directory and build the project:
    cd bff-api
    ./mvnw clean install
    •    Configure the application.properties or application.yml with your API URLs and other settings.

    3.    Run the Application:
    •    Start the application:
    ./mvnw spring-boot:run
    •    The service will be available at http://localhost:8082.

Endpoints

    •    POST /api/bff/auth/login: Forward login requests to login-api.
    •    POST /api/bff/reviews: Forward review creation requests to review-api.
    •    GET /api/bff/businesses/search: Aggregate business data from Yelp API.

Testing

    •    Unit and integration tests are included.
    •    To run tests:
    ./mvnw test
Final Notes

Each component is designed to work in conjunction with the others, providing a seamless user experience for both the mobile client and backend services. Be sure to check and configure your network and security settings to ensure proper communication between the services.
