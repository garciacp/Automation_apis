package co.com.ath.automation.features.steps.testTutorial;

import co.com.ath.automation.features.steps.Authentication.AuthenticationRequests;
import co.com.ath.automation.rest.data.Environment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.aeonbits.owner.ConfigFactory;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.when;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class TestRestSteps {

    private static Environment environment;
    String bodyRequest;
    int dato_seguro;
    String BankId;
    String TypeTx;

    AuthenticationRequests requests = new AuthenticationRequests();

    static {
        environment = ConfigFactory.create(Environment.class);
    }


    @Given("^El usuario desea obtener listado de vehiculos$")
    public void el_usuario_desea_obtener_listado_de_vehiculos() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        given()
                .contentType("application/json");
    }

    @When("^Se envia solicitud de obtener listado$")
    public void se_envia_solicitud_de_obtener_listado() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        bodyRequest = requests.AuthenticationBody(environment.datoseguro_azul(),environment.OtpTypeOccidente());
        dato_seguro = environment.datoseguro_azul();
        BankId = environment.BankidOccidente();
    }

    @Then("^Devolver listado de vehiculos$")
    public void devolver_listado_de_vehiculos() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        requests.Authentication(dato_seguro,BankId,bodyRequest);
        String resultado = SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode");
        assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    }
}
