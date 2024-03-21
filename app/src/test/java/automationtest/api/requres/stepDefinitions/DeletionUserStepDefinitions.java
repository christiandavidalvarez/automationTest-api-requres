package automationtest.api.requres.stepDefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import automationtest.api.requres.tasks.DeleteUser;
import automationtest.api.requres.tasks.GetUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

public class DeletionUserStepDefinitions {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    private Actor actor;
    Integer userIdToRemove;

    @Before
    public void prepareExecution() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("Mario the user").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Given("Mario have the ID of a user I wish to delete")
    public void mario_have_the_id_of_a_user_i_wish_to_delete() {
        userIdToRemove = 10;
    }

    @When("he request the deletion of this user")
    public void he_request_the_deletion_of_this_user() {
        actor.attemptsTo(
                DeleteUser.byId(userIdToRemove));
    }

    @Then("the system should confirm the deletion")
    public void the_system_should_confirm_the_deletion() {
        actor.should(
                seeThatResponse("The response status code should be 204",
                        response -> response.statusCode(204)));
    }

    @Then("the user should no longer exist in the system")
    public void the_user_should_no_longer_exist_in_the_system() {
        actor.attemptsTo(GetUser.withId(userIdToRemove));
        actor.should(
                seeThatResponse("The user should no longer exist",
                        response -> response.statusCode(404)));
    }

}
