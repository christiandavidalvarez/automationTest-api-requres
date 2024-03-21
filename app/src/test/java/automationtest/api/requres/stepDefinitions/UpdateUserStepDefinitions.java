package automationtest.api.requres.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.util.EnvironmentVariables;

public class UpdateUserStepDefinitions {

    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    private Actor actor;

    @Before
    public void prepareExecution(){
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://reqres.in/api");
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("Mario have access to modify a specific user")
    public void mario_have_access_to_modify_a_specific_user() {

    }

    @When("he update this users occupation")
    public void he_update_this_users_occupation() {

    }

    @Then("the system should confirm the update")
    public void the_system_should_confirm_the_update() {

    }

    @Then("the updated information should be reflected in the users data")
    public void the_updated_information_should_be_reflected_in_the_users_data() {

    }

}
