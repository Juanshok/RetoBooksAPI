package books.stepdefinitions;

import books.tasks.GET_BooksTask;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

public class GET_BooksStepdefinitions {

    @Cuando("se envia la peticion para obtener los libros")
    public void seEnviaLaPeticionParaObtenerLosLibros() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GET_BooksTask.on()
        );
    }

}
