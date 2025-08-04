package books.tasks;

import books.models.POST_TokenData;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class POST_TokenTask implements Task {

    private final String PATH = "/api-clients";

    protected POST_TokenData postTokenData;

    public POST_TokenTask(POST_TokenData postTokenData) {
        this.postTokenData = postTokenData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(PATH)
                        .with((RequestSpecification request) -> request
                                .headers(setHeaders())
                                .body(setBody()))
        );

        // Obtener y guardar el token
        String token = SerenityRest.lastResponse().jsonPath().getString("accessToken");
        System.out.println("==== TOKEN GENERADO ====");
        System.out.println(token);

        // Guardar el token en la memoria del actor
        actor.remember("accessToken", token);
    }

    private Map<String, Object> setHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    private Map<String, Object> setBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("clientName", postTokenData.getClientName());
        body.put("clientEmail", postTokenData.getClientEmail());
        return body;
    }

    public static POST_TokenTask on(POST_TokenData postTokenData){
        return Instrumented.instanceOf(POST_TokenTask.class).withProperties(postTokenData);
    }

}
