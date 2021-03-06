package co.com.ath.automation.features.steps.Deceval;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import net.serenitybdd.rest.SerenityRest;

public class DecevalAssertion {


    public static void consultaAprobada(String codigo) {
      assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida."+codigo), equalTo("SDL.SE.0000"));
    }

  public static void consultarechazada(String codigo) {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida."+codigo),  not(equalTo("SDL.SE.0000")));
  }

  public static void approvedAssertionGirator(String codigo) {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida."+codigo), equalTo("SDL.SE.0000"));
  }

  public static void AssertionCuentaotorgante() {
      assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida.cuentaotorgante"), equalTo("SDLSE.0000"));
  }

    public static void crearGiradorechazado(String codigo) {
        assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida."+codigo),  equalTo("SDL.SE.0091 - La fecha en el header no es válida.(Día) "));
    }

    public static void assertionFirmaPagareAprobada(String codigo) {
        assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida."+codigo),  equalTo("SDL.SE.0000: Exitoso."));
    }
    public static void assertionCrearOtorganteRechazada(String codigo) {
        assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida."+codigo),  equalTo("SDL.SE.0098"));
    }

    public static void assertionConsultaPdfRechazada(String codigo, String valor) {
        assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida."+codigo),  equalTo(valor));
    }
    public static void assertionTransaccionAprobada(String codigo, String valor) {
        assertThat(SerenityRest.then().extract().body().jsonPath().get("mensajesSalida."+codigo),  equalTo(valor));
    }


}
