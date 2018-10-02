package co.com.ath.automation.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/", tags = "@CrearOtorganteCedulaIncorrecta")
public class Runner {
    @Managed(driver = "chrome")
    WebDriver driver;
}
