package automationtest.api.requres.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CreateUser implements Task {
    private final String name;
    private final String job;

    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public static Performable withDetails(String name, String job) {
        return Task.where("{0} attempts to create a new user with name " + name + " and job " + job,
                Post.to("/api/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}"))
        );
    }

    @Override
    @Step("{0} attempts to create a new user with name #name and job #job")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"name\": \"" + this.name + "\", \"job\": \"" + this.job + "\"}"))
        );
    }
}

