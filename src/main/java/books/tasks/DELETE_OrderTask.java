package books.tasks;

import books.models.DELETE_OrderData;
import books.models.POST_CreateOrderData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class DELETE_OrderTask implements Task {

    private final String PATH = "/orders/";

    protected DELETE_OrderData deleteOrderData;

    public DELETE_OrderTask(DELETE_OrderData deleteOrderData) {
        this.deleteOrderData = deleteOrderData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall("accessToken");
        actor.attemptsTo(
                Delete.from(PATH + deleteOrderData.getOrderId())
                        .with(request -> request
                                .headers(setHeaders(token))
                        )
        );

        System.out.println("==== RESPUESTA ELIMINAR ORDEN ====");
        SerenityRest.lastResponse().prettyPrint();
    }

    private Map<String, Object> setHeaders(String token) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    public static DELETE_OrderTask on(DELETE_OrderData postCreateOrderData) {
        return Instrumented.instanceOf(DELETE_OrderTask.class).withProperties(postCreateOrderData);
    }
}
