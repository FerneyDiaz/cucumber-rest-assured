package starter.reqres.user;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class UserStepDefinitions {
    @Steps
    UserAPI userApi;

    @When("I look up a user by {}")
    public void iLookUpAUserById(String id) {
        userApi.fetchUserById(id);
    }

    @Then("The email and first name should be {word} {word}")
    public void theEmailAndFirstNameShouldBeEmailFirst_name(String email, String firstName) {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(LocationResponse.EMAIL,equalTo(email)));
        restAssuredThat(response -> response.body(LocationResponse.FIRST_NAME,equalTo(firstName)));
    }

    @When("I save a new user with {word} and {word}")
    public void iSaveANewUserWithNameAndJob(String name, String job) {
        userApi.postUserWithNameAndJob(name,job);
    }

    @Then("The response return an id")
    public void theResponseReturnAnId() {
        restAssuredThat(response -> response.statusCode(203));
    }

    @When("I delete an user with {}")
    public void iDeleteAnUserWithId(String idUser) {
        userApi.deleteUserById(idUser);
    }

    @Then("The response code should be {int}")
    public void theResponseCodeShouldBe(int statusCode) {
        restAssuredThat(response ->response.statusCode(204));
    }

    @When("Create multiple users test")
    public void createMultipleUsersTest(){

    }


}
