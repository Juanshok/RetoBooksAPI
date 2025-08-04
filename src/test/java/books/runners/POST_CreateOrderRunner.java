package books.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/POST_CreateOrder.feature",
        glue = "books.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class POST_CreateOrderRunner {
}
