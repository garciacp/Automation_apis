package co.com.ath.automation.features.steps.FirmaPagareDeceval;

import static net.serenitybdd.rest.SerenityRest.given;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;

public class FirmaPagareDecevalRequest {


  public String FirmaPagareBody() {

    try {
      String FirmaPagareBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/firmarPagareDeceval.json"),
          StandardCharsets.UTF_8
      );
      return FirmaPagareBody;

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public void FirmaPagare() throws IOException {
    given()
        .contentType("application/json")
        .accept("application/json")
        .body(FirmaPagareBody())
        .when().post("https://ns9orpyu6h.execute-api.sa-east-1.amazonaws.com/PRU/firmarPagare");
  }

}
