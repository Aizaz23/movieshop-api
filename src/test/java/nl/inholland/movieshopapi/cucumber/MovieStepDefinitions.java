package nl.inholland.movieshopapi.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieStepDefinitions extends BaseStepDefinitions {
    @Autowired
    private TestRestTemplate testRestTemplate;

    private ResponseEntity<String> response;

    HttpHeaders httpHeaders;

    @Given("The endpoint for {string} is available for method {string}")
    public void theEndpointForIsAvailableForMethod(String endpoint, String method) {
        response = testRestTemplate.exchange(
                "/" + endpoint,
                HttpMethod.OPTIONS,
                new HttpEntity<>(
                        null,
                new org.springframework.http.HttpHeaders()),
                String.class);

        List<String> options = Arrays.stream(response.getHeaders().get("Allow").get(0).split(",")).collect(Collectors.toList());
        Assertions.assertTrue(options.contains(method.toUpperCase()));
    }

    @When("I retrieve all movies")
    public void iRetrieveAllMovies(){
        response = testRestTemplate.exchange(
                "/guitars",
                HttpMethod.GET,
                new HttpEntity<>(
                        null,
                new org.springframework.http.HttpHeaders()),
                String.class);

    }

    @Then("I get a list of {int} guitars")
    public void iGetAListOfGuitars(int expected) {
        int actual = JsonPath.read(response.getBody(), "$.size()");
        Assertions.assertEquals(expected, actual);
    }

    @And("I get http status code {int}")
    public void iGetHttpStatusCode(int statusCode) {
        int actual = JsonPath.read(response.getBody(), "$.statusCode");
        Assertions.assertEquals(statusCode, actual);
    }

    @When("I provide a movie with name {string}")
    public void iProvideAMovieWithName(String name) {
        httpHeaders.add("Content-Type", "application/json");
        response = testRestTemplate.exchange(
                "/movies",
                HttpMethod.POST,
                new HttpEntity<>(
                        // IDC about line break
                        """
                            {
                                "name": John Wick
                            }
                        """, new org.springframework.http.HttpHeaders()),
                String.class);
    }

    @And("The price of the movie is {int}")
    public void thePriceOfTheMovieIs(int price) {
        double actual = JsonPath.read(response.getBody(), "$.price");
        Assertions.assertEquals(price, actual);
    }
}
