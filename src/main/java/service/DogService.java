package service;

import contants.Url;
import io.restassured.response.Response;
import io.restassured.specification.*;
import models.CreateVote;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class DogService {

    public Response getVotesBySub_id(String sub_id, RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        return given()
                .spec(requestSpec)
                .basePath(Url.VOTE_BASE_PATH)
                .queryParam("sub_id", sub_id)
                .when()
                .get()
                .then()
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();
    }

    public Response createVoteBySub_idAndImage_id(CreateVote createVote, RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        return given()
                .spec(requestSpec)
                .basePath(Url.VOTE_BASE_PATH)
                .body(createVote)
                .when()
                .post()
                .then()
                .body("message", equalTo("SUCCESS"))
                .assertThat()
                .spec(responseSpec)
                .log().ifValidationFails()
                .extract().response();
    }
}
