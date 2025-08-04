package books.stepdefinitions;

import books.models.POST_CreateOrderData;
import books.tasks.POST_CreateOrderTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;

public class POST_CreateOrderStepdefinitions {

    @Cuando("se envia la peticion de creacion de libros")
    public void seEnviaLaPeticionDeCreacionDeLibros(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                POST_CreateOrderTask.on(POST_CreateOrderData.setData(dataTable).get(0))
        );
    }
}
