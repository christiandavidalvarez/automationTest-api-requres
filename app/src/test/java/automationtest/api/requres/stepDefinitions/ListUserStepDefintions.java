package automationtest.api.requres.stepDefinitions;

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
import automationtest.api.requres.models.User;
import automationtest.api.requres.tasks.GetUsers;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.IsIterableContaining.hasItems;

public class ListUserStepDefintions {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    private Actor actor;

    @Given("there are registered users on the platform")
    public void there_are_registered_users_on_the_platform() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("Mario the user").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("he request the list of users from a specific page")
    public void he_request_the_list_of_users_from_a_specific_page() {
        actor.attemptsTo(
                GetUsers.fromPageAndUsersPerPage(1, 2));
    }

    @Then("he should receive a list containing the users of that page")
    public void he_should_receive_a_list_containing_the_users_of_that_page() {
        actor.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.body("data.first_name", hasItems("George", "Janet"))));

    }

    @Then("the current page information matches the requested one")
    public void the_current_page_information_matches_the_requested_one() {
        User user = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("data[0]",User.class);
        actor.attemptsTo(Ensure.that(user.getFirst_name()).isEqualTo("George"));
        actor.attemptsTo(Ensure.that(user.getLast_name()).isEqualTo("Bluth"));
    }

}
