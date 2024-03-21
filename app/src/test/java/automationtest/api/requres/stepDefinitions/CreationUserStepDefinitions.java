package automationtest.api.requres.stepDefinitions;

import automationtest.api.requres.tasks.CreateUser;
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

public class CreationUserStepDefinitions {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    private Actor actor;
    private String nameToCreated, occupationToCreated;

    @Before
    public void prepareExecution() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Mario have valid information for a new user")
    public void mario_have_valid_information_for_a_new_user() {
        actor = Actor.named("Mario the user").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("he register this new user in the system")
    public void he_register_this_new_user_in_the_system() {
        nameToCreated = "Jonas Gutierrez";
        occupationToCreated = "Tax Driver";
        actor.attemptsTo(
                CreateUser.withDetails(nameToCreated, occupationToCreated));
    }

    @Then("the system should confirm the creation of the user")
    public void the_system_should_confirm_the_creation_of_the_user() {
        String occupationCreated = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("job", String.class);
        String nameCreated = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("name", String.class);
        actor.attemptsTo(Ensure.that(occupationCreated).isEqualTo(occupationToCreated));
        actor.attemptsTo(Ensure.that(nameCreated).isEqualTo(nameToCreated));
    }

}
