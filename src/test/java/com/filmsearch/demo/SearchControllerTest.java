package com.filmsearch.demo;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private MockWebServer mockBackEnd;

    @BeforeEach
    void setUp() throws Exception {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @AfterEach
    void tearDown() throws Exception {
        mockBackEnd.shutdown();
    }

    @Test
    void movieInfo_returnsValidResults() {
        // Prepare mock response
        String mockResponseBody = "{ \"Title\": \"Inception\", \"Year\": \"2010\", \"imdbRating\": \"8.8\" }";
        mockBackEnd.enqueue(new MockResponse().setBody(mockResponseBody).setResponseCode(200));

        // Set the URL to use the MockWebServer instance
        String baseUrl = mockBackEnd.url("/").toString();

        // Execute request to your Spring Boot application
        ResponseEntity<String> response = restTemplate.getForEntity("/search?Title=Inception", String.class);

        // Assert that the response status is OK
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Assert that the response body contains expected values
        assertThat(response.getBody()).contains("Inception");
        assertThat(response.getBody()).contains("2010");
        assertThat(response.getBody()).contains("8.8");
    }
}