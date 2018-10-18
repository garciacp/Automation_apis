package co.com.ath.automation.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
<<<<<<< HEAD
    features = "src/test/resources/features/")
=======
    features = "src/test/resources/features/", tags = "@CrearOtorganteCedulaIncorrecta")
>>>>>>> ad880ab25e19d497f27a924c39831a9097ebdddc
public class Runner {
    @Managed(driver = "chrome")
    WebDriver driver;
}
