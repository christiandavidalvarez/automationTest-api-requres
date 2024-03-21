package automationtest.api.requres.stepDefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

public class ParameterDefinitions {

    protected static final String MARIO_THE_USER = "Mario the user";
    private EnvironmentVariables environmentVariables;
    private String theRestApiBaseUrl;
    private Actor actor; 

  
    public void setTheStage() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                                        .orElse("https://reqres.in/api");
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("Mario the user").whoCan(CallAnApi.at(theRestApiBaseUrl)); 
    }

}
