package co.com.ath.automation.features.steps.Deceval;

import static net.serenitybdd.rest.SerenityRest.given;

import co.com.ath.automation.rest.apis.ServicePaths;
import co.com.ath.automation.utils.FunctionsUtils;
import io.restassured.response.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class DecevalRequest {

  private static String cuentaOtorgante;
  private static String numeroPagareDeceval;
  public FunctionsUtils functionsUtils = new FunctionsUtils();

  public String CrearOtorganteBody(int numeroDiasMenos, String eliminarCampo) {

      JSONObject jObject  = functionsUtils.getJsonFinal(eliminarCampo, "json/Deceval_CrearOtorgante.json", DecevalStaticCode.CREAR_OTORGANTE_POSICION_NUM_DOCUMENTO);
      jObject.put("fechahoy",functionsUtils.getDateToday(numeroDiasMenos));

      String CrearGiradorBodyModify =   jObject.toString();
      return CrearGiradorBodyModify;

  }

  public String CrearPagareBody(int numeroDiasMenos) {

    try {
      String crearPagareBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_CrearPagare.json"),
          StandardCharsets.UTF_8
      );

      JSONObject jObject  = new JSONObject(crearPagareBody);
      jObject.put("fechahoy",functionsUtils.getDateToday(numeroDiasMenos));
      jObject.put("otorganteCuenta", cuentaOtorgante);
      jObject.put("numPagareEntidad", functionsUtils.getNamePagare());
      String crearPagareBodyModify =   jObject.toString();
      return crearPagareBodyModify;

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public String FirmaPagareBody(int numeroDiasMenos) {

    try {
      String firmaPagareBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_FirmaPagare.json"),
          StandardCharsets.UTF_8
      );

      JSONObject jObject  = new JSONObject(firmaPagareBody);
      jObject.put("fechahoy",functionsUtils.getDateToday(numeroDiasMenos));
      jObject.put("idPagare", numeroPagareDeceval);
      return jObject.toString();

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public String ConsultarPagareSinPdfBody(int numeroDiasMenos) {

    try {
      String consultarPagareSinPdfBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_ConsultaSinPdf.json"),
          StandardCharsets.UTF_8
      );
      JSONObject jObject  = new JSONObject(consultarPagareSinPdfBody);
      jObject.put("fechahoy",functionsUtils.getDateToday(numeroDiasMenos));
      return jObject.toString();

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public String ConsultarPagareConPdfBody(int numeroDiasMenos, String numeroId, String eliminarCampo) {

        JSONObject jObject  = functionsUtils.getJsonFinal(eliminarCampo, "json/Deceval_Consulta_ConPdf.json", DecevalStaticCode.CONSULTA_PAGARE_POSICION_NUM_PAGARE);
        jObject.put("fechahoy",functionsUtils.getDateToday(numeroDiasMenos));
        if(numeroId!=null){
            jObject.put("numPagareEntidad",numeroId);
        }
        return jObject.toString();
  }


  public void ConsultaPagareConPdf(int numeroDiasMenos, String numeroId, String eliminarCampo) throws IOException {

    given()
        .contentType("application/json")
        .accept("application/json")
        .body(ConsultarPagareConPdfBody(numeroDiasMenos, numeroId, eliminarCampo))
        .when().post(ServicePaths.pathDeceval_consultaConPdf());
  }

  public void ConsultaPagareSinPdf(int numeroDiasMenos) throws IOException {

    given()
        .contentType("application/json")
        .accept("application/json")
        .body(ConsultarPagareSinPdfBody(numeroDiasMenos))
        .when().post(ServicePaths.pathDeceval_consultaSinPdf());
  }


  public void CrearOtorgante(int numeroDiasMenos, String eliminarCampo) throws IOException {

    Response response =
            given()
        .contentType("application/json")
        .accept("application/json")
        .body(CrearOtorganteBody(numeroDiasMenos,eliminarCampo))
        .when().post(ServicePaths.pathDeceval_crearotorgante())
        .then().contentType("application/json")
        .extract().response();
        cuentaOtorgante = response.path("mensajesSalida.cuentaotorgante");
  }


  public void CrearPagare(int numeroDiasMenos) throws IOException {
    Response response =
        given()
        .contentType("application/json")
        .accept("application/json")
        .body(CrearPagareBody(numeroDiasMenos)).
    when()
        .post(ServicePaths.pathDeceval_crearpagare()).
    then()
        .contentType("application/json").
    extract()
        .response();
    numeroPagareDeceval = response.path("mensajesSalida.numPagareDeceval");
  }

  public void FirmarPagare(int numeroDiasMenos) throws IOException {
    given()
        .contentType("application/json")
        .accept("application/json")
        .body(FirmaPagareBody(numeroDiasMenos))
        .when().post(ServicePaths.pathDeceval_firmarpagare());
  }


}
