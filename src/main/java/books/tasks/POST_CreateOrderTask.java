package books.tasks;

import books.models.POST_CreateOrderData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class POST_CreateOrderTask implements Task {

    private final String PATH = "/orders";

    protected POST_CreateOrderData postCreateOrderData;

    public POST_CreateOrderTask(POST_CreateOrderData postCreateOrderData) {
        this.postCreateOrderData = postCreateOrderData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.recall("accessToken");
        actor.attemptsTo(
                Post.to(PATH)
                        .with(request -> request
                                .headers(setHeaders(token))
                                .body(setBody())
                        )
        );

        System.out.println("==== RESPUESTA DE LA ORDEN ====");
        SerenityRest.lastResponse().prettyPrint();
    }
    private Map<String, Object> setHeaders(String token){
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        return headers;
    }

    private Map<String, Object> setBody(){
        Map<String, Object> body = new HashMap<>();
        body.put("bookId", postCreateOrderData.getBookId());
        body.put("customerName", postCreateOrderData.getCustomerName());
        return body;
    }

    public static POST_CreateOrderTask on(POST_CreateOrderData postCreateOrderData){
        return Instrumented.instanceOf(POST_CreateOrderTask.class).withProperties(postCreateOrderData);
    }

}
