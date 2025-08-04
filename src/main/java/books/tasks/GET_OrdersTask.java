package books.tasks;

import books.models.POST_CreateOrderData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;
import java.util.Map;

public class GET_OrdersTask implements Task {

    private final String PATH = "/orders";

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall("accessToken");

        actor.attemptsTo(
                Get.resource(PATH)
                        .with(request -> request
                                .headers(setHeaders(token))
                        )
        );

        System.out.println("==== LISTADO DE ORDENES ====");
        SerenityRest.lastResponse().prettyPrint();
    }

    private Map<String, Object> setHeaders(String token){
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    public static GET_OrdersTask on(){
        return Instrumented.instanceOf(GET_OrdersTask.class).withProperties();
    }

}
