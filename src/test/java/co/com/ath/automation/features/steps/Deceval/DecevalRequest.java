package co.com.ath.automation.features.steps.Deceval;

import static net.serenitybdd.rest.SerenityRest.given;

import co.com.ath.automation.rest.apis.ServicePaths;
import io.restassured.response.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class DecevalRequest {

  public String cuentaOtorgante;

  public String CrearOtorganteBody() {
    try {
      String CrearGiradorBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_CrearOtorgante.json"),
          StandardCharsets.UTF_8
      );

      JSONObject jObject  = new JSONObject(CrearGiradorBody);
      jObject.put("fechahoy","2018-10-01T00:00:00");

      String CrearGiradorBodyModify =   jObject.toString();
      return CrearGiradorBodyModify;

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public String CrearPagareBody() {

    try {
      String CrearPagareBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_CrearPagare.json"),
          StandardCharsets.UTF_8
      );

      JSONObject jObject  = new JSONObject(CrearPagareBody);
      jObject.put("fechahoy","2018-10-01T00:00:00");
      jObject.put("otorganteCuenta", cuentaOtorgante);


      String CrearPagareBodyModify =   jObject.toString();
      return CrearPagareBodyModify;

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public String FirmaPagareBody() {

    try {
      String FirmaPagareBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_FirmaPagare.json"),
          StandardCharsets.UTF_8
      );
      return FirmaPagareBody;

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public String ConsultarPagareSinPdfBody() {

    try {
      String ConsultarPagareSinPdfBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_ConsultaSinPdf.json"),
          StandardCharsets.UTF_8
      );
      return ConsultarPagareSinPdfBody;

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public String ConsultarPagareConPdfBody() {

    try {
      String ConsultarPagareConPdfBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_Consulta_ConPdf.json"),
          StandardCharsets.UTF_8
      );
      return ConsultarPagareConPdfBody;

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }


  public void ConsultaPagareConPdf() throws IOException {

    given()
        .contentType("application/json")
        .accept("application/json")
        .body(ConsultarPagareConPdfBody())
        .when().post(ServicePaths.pathDeceval_consultaConPdf());
  }

  public void ConsultaPagareSinPdf() throws IOException {

    given()
        .contentType("application/json")
        .accept("application/json")
        .body(ConsultarPagareSinPdfBody())
        .when().post(ServicePaths.pathDeceval_consultaSinPdf());
  }


  public void CrearOtorgante() throws IOException {
    given()
        .contentType("application/json")
        .accept("application/json")
        .body(CrearOtorganteBody())
        .when().post(ServicePaths.pathDeceval_crearotorgante());
  }


  public void CrearPagare() throws IOException {
    Response response =
        given()
        .contentType("application/json")
        .accept("application/json")
        .body(CrearPagareBody()).
    when()
        .post(ServicePaths.pathDeceval_crearpagare()).
    then()
        .contentType("application/json").
    extract()
        .response();

    cuentaOtorgante = response.path("cuentaotorgante");
  }

  public void FirmarPagare() throws IOException {
    given()
        .contentType("application/json")
        .accept("application/json")
        .body(FirmaPagareBody())
        .when().post(ServicePaths.pathDeceval_crearpagare());
  }






}
