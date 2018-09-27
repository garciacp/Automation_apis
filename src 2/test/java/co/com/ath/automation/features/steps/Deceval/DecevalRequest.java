package co.com.ath.automation.features.steps.Deceval;

import static net.serenitybdd.rest.SerenityRest.given;

import co.com.ath.automation.rest.apis.ServicePaths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;

public class DecevalRequest {


  public String CrearGiradorBody() {

    try {
      String CrearGiradorBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/Deceval_CrearOtorgante.json"),
          StandardCharsets.UTF_8
      );
      return CrearGiradorBody;

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
      return CrearPagareBody;

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
        .body(CrearGiradorBody())
        .when().post(ServicePaths.pathDeceval_crearotorgante());
  }


  public void CrearPagare() throws IOException {
    given()
        .contentType("application/json")
        .accept("application/json")
        .body(CrearPagareBody())
        .when().post(ServicePaths.pathDeceval_crearpagare());
  }

  public void FirmarPagare() throws IOException {
    given()
        .contentType("application/json")
        .accept("application/json")
        .body(FirmaPagareBody())
        .when().post(ServicePaths.pathDeceval_crearpagare());
  }






}
