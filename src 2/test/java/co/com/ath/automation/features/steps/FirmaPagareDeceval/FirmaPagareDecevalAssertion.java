package co.com.ath.automation.features.steps.FirmaPagareDeceval;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import net.serenitybdd.rest.SerenityRest;

public class FirmaPagareDecevalAssertion {
    public static void approvedAssertion() {
      assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida.codigoError"), equalTo("0000"));
    }

}
