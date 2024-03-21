package automationtest.api.requres.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class UpdateUserOccupation implements Task {
    private final int userId;
    private final String newOccupation;

    public UpdateUserOccupation(int userId, String newOccupation) {
        this.userId = userId;
        this.newOccupation = newOccupation;
    }

    public static Performable withDetails(int userId, String newOccupation) {
        return Task.where("{0} attempts to update the occupation of user #" + userId,
                Put.to("/api/users/{userId}")
                        .with(request -> request.pathParam("userId", userId)
                                .contentType("application/json")
                                .body("{\"occupation\":\"" + newOccupation + "\"}")));
    }

    @Override
    @Step("{0} attempts to update the occupation of user #userId to #newOccupation")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/api/users/{userId}")
                        .with(request -> request.pathParam("userId", this.userId)
                                .contentType("application/json")
                                .body("{\"occupation\":\"" + this.newOccupation + "\"}")));
    }
}
