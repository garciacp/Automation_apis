package co.com.ath.automation.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/",tags = "@DatoSeguroRojo, @DatoSeguroVerde")
public class Runner {

}
