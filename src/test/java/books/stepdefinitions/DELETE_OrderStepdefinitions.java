package books.stepdefinitions;

import books.models.DELETE_OrderData;
import books.tasks.DELETE_OrderTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

public class DELETE_OrderStepdefinitions {

    @Cuando("se envia la peticion de eliminar orden")
    public void seEnviaLaPeticionDeEliminarOrden(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DELETE_OrderTask.on(DELETE_OrderData.setData(dataTable).get(0))
        );

    }

}
