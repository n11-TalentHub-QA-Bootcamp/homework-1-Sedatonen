package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static contants.ResponseSpec.checkStatusCodeOk;
import static org.junit.Assert.*;

import service.DogService;
import models.CreateVote;

import static contants.RequestSpec.*;

public class VoteSteps {
    DogService dogService = new DogService();
    String subId;
    String imageId;
    int id;

    @When("I check of votes for this {string}")
    public void ı_check_of_votes_for_this(String sub_id) {
        Response response = dogService.getVotesBySub_id(sub_id, requestSpecification(), checkStatusCodeOk());
        // System.out.println(response.getBody().asPrettyString());

    }

    @When("I will create one more vote with {string} and {string}")
    public void ı_will_create_one_more_vote_with_and(String sub_id, String image_id) {

        CreateVote createVote = CreateVote.builder()
                .sub_id(sub_id)
                .image_id(image_id)
                .build();
        Response response = dogService.createVoteBySub_idAndImage_id(createVote, requestSpecification(), checkStatusCodeOk());
        id = response.path("id");
        imageId = image_id;
        subId = sub_id;

        assertTrue(response.body().asString().contains("SUCCESS"));
        // int idjsn= response.jsonPath().getInt("id");
        // System.out.println("idjsn = " + idjsn);
        // System.out.println(response.getBody().asPrettyString());
    }

    @Then("I will check of my vote")
    public void ı_will_check_of_my_vote() {
        Response response = dogService.getVotesBySub_id(subId, requestSpecification(), checkStatusCodeOk());

        assertTrue(response.body().asString().contains(subId));
        assertTrue(response.body().asString().contains(imageId));
    }
}
