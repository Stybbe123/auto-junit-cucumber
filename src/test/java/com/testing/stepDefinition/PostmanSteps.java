package com.testing.stepDefinition;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.apache.http.HttpStatus;

import static com.jayway.restassured.RestAssured.given;

public class PostmanSteps implements En {

    @When("^baseUri \"([^\"]*)\" and basePath \"([^\"]*)\"$")
    public void baseUrlAndBasePath(String baseUri, String basePath) {
        RestAssured.baseURI = baseUri;
        RestAssured.basePath = basePath;
    }

    @And("^basic auth with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void basicAuthWithUsernameAndPassword(String username, String password) {
        RestAssured.authentication = RestAssured.basic(username, password);
    }

    @Then("^authenticated$")
    public void expectedResponseMessage() {
        Response response = given().
                when().get().
                then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                extract().
                response();
        assert response.getBody().jsonPath().getBoolean("authenticated");
    }

}
