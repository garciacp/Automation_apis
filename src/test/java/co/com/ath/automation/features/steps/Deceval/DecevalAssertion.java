package co.com.ath.automation.features.steps.Deceval;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import net.serenitybdd.rest.SerenityRest;

public class DecevalAssertion {


    public static void Consultaaprobada() {
      assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida.codigoPagare"), equalTo("SDL.SE.0000"));
    }

  public static void Consultarechazada() {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida.codigoPagare"), equalTo("SDL.SE.0000"));
  }

  public static void approvedAssertionGirator() {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida.codigoGirador"), equalTo("SDLSE.0000"));
  }

  public static void AssertionCuentaotorgante() {
      assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida.cuentaotorgante"), equalTo("SDLSE.0000"));
  }
}
