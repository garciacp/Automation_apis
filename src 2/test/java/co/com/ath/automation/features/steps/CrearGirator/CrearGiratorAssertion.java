package co.com.ath.automation.features.steps.CrearGirator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import net.serenitybdd.rest.SerenityRest;

public class CrearGiratorAssertion {
    public static void approvedAssertion() {
        assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida.codigoGirador"), equalTo("SDLSE.0000"));
    }
}
