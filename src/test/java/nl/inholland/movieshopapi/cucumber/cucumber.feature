Feature: Everything to do with Movies

  Scenario:
    Given The endpoint for "movies" is available for method "GET"
    When I retrieve all movies
    Then I get a list of movies
    And I get http status code 200



  Scenario: Create movie
    Given The endpoint for "movies" is available for method "POST"
    When I provide a movie with name "John Wick"
    Then I get http status code 201
    And The price of the movie is 10.0