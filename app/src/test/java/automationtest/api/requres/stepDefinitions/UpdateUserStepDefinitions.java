package automationtest.api.requres.stepDefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import automationtest.api.requres.models.User;
import automationtest.api.requres.tasks.UpdateUserOccupation;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

public class UpdateUserStepDefinitions {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    private Actor actor;
    private Integer userId;
    private String newOcupation;

    @Before
    public void prepareExecution() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Mario have access to modify a specific user")
    public void mario_have_access_to_modify_a_specific_user() {
        actor = Actor.named("Mario the user").whoCan(CallAnApi.at(theRestApiBaseUrl));
        userId = 9;
        newOcupation = "Manager devops";
    }

    @When("he update this users occupation")
    public void he_update_this_users_occupation() {
        actor.attemptsTo(
                UpdateUserOccupation.withDetails(userId, newOcupation));

    }

    @Then("the system should confirm the update")
    public void the_system_should_confirm_the_update() {
        actor.should(
                seeThatResponse("The response status should be 200",
                        response -> response.statusCode(200)));
    }

    @Then("the updated information should be reflected in the users data")
    public void the_updated_information_should_be_reflected_in_the_users_data() {
        String occupationUpdated = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("occupation", String.class);
        actor.attemptsTo(Ensure.that(occupationUpdated).isEqualTo(newOcupation));

    }

}
