package books.stepdefinitions;

import books.tasks.GET_OrdersTask;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

public class GET_OrdersStepdefinitions {

    @Cuando("se envia la peticion para obtener ordenes")
    public void seEnviaLaPeticionParaObtenerOrdenes() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GET_OrdersTask.on()
        );
    }

}
