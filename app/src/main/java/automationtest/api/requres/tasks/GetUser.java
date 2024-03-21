package automationtest.api.requres.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetUser implements Task {

    private Integer userId;

    public GetUser(Integer userId) {
        this.userId = userId;
    }

    public static GetUser withId(Integer userId) {
        return instrumented(GetUser.class, userId);
    }

    @Override
    @Step("{0} gets the user")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource("/api/users/{userId}").with(request -> request.pathParam("userId", userId))
        );
    }

}
