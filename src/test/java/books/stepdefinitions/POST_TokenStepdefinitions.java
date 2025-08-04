package books.stepdefinitions;

import books.models.POST_TokenData;
import books.questions.CodigoEstado;
import books.tasks.POST_TokenTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static books.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class POST_TokenStepdefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR).whoCan(CallAnApi.at(URL));
    }

    @Dado("que se realiza la peticion para generar el token")
    public void queSeRealizaLaPeticionParaGenerarElToken(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                POST_TokenTask.on(POST_TokenData.setData(dataTable).get(0))
        );
    }

    @Entonces("valida que el codigo de status sea {int}")
    public void validaQueElCodigoDeStatusSea(Integer codigo) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("el código de estado", CodigoEstado.es(), equalTo(codigo))
        );
    }

}
