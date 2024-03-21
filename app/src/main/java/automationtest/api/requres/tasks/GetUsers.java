package automationtest.api.requres.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers implements Task {

    private Integer page;
    private Integer userPerPage;

    public GetUsers(Integer page) {
        this.page = page;
    }

    public GetUsers(Integer page, Integer userPerPage) {
        this.page = page;
        this.userPerPage = userPerPage;
    }

    public static GetUsers fromPage(Integer page) {
        return instrumented(GetUsers.class, page);
    }

    public static GetUsers fromPageAndUsersPerPage(Integer page, Integer userPerPage) {
        return instrumented(GetUsers.class, page, userPerPage);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (userPerPage != null) {
            getForPageAndUserPerPage(actor);
        } else {
            getForPage(actor);
        }
    }

    @Step("{0} gets users for page #page")
    private <T extends Actor> void getForPage(T actor) {
        Get get = new Get("/users?page=" + page);
        actor.attemptsTo(get);
    }

    @Step("{0} gets users for page #page and users per page #userPerPage")
    private <T extends Actor> void getForPageAndUserPerPage(T actor) {
        Get get = new Get("/users?page=" + page + "&per_page=" + userPerPage);
        actor.attemptsTo(get);
    }

}
