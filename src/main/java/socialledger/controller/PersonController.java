package socialledger.controller;

import io.javalin.http.Handler;
import socialledger.model.Person;
import socialledger.persistence.PersonDAO;
import socialledger.server.Routes;
import socialledger.server.ServiceRegistry;
import socialledger.server.Server;

import java.util.Objects;

public class PersonController {

    public static final Handler logout = ctx -> {
        ctx.sessionAttribute(Server.SESSION_USER_KEY, null);
        ctx.redirect(Routes.LOGIN_PAGE);
    };

    private static final PersonDAO personDAO = ServiceRegistry.lookup(PersonDAO.class);
    public static final Handler login = context -> {
        String email = context.formParamAsClass("email", String.class)
                .check(Objects::nonNull, "Email is required")
                .get();

        Person person = personDAO.savePerson(new Person(email));
        context.sessionAttribute(Server.SESSION_USER_KEY, person);
        context.redirect(Routes.EXPENSES);
    };
}
