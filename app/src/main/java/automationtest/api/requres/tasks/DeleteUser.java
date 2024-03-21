package automationtest.api.requres.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteUser implements Task {
    
    private final int userId;

    public DeleteUser(int userId) {
        this.userId = userId;
    }

    public static DeleteUser byId(int userId) {
        return new DeleteUser(userId);
    }

    @Override
    @Step("{0} attempts to delete the user with id #userId")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/api/users/{userId}")
                        .with(request -> request.pathParam("userId", userId)));
    }


}