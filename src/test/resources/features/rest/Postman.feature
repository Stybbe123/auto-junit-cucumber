@api
@all
Feature: Postman

  I authenticate at "https://postman-echo.com/basic-auth" using username "postman" and password "password"
  I get "authenticated:true" response

  Scenario: Auth success at postman-echo
    When baseUri "https://postman-echo.com" and basePath "/basic-auth"
    And basic auth with username "postman" and password "password"
    Then authenticated



