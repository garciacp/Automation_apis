package co.com.ath.automation.features.steps.signature;

import static net.serenitybdd.rest.SerenityRest.given;

import co.com.ath.automation.rest.apis.ServicePaths;
import co.com.ath.automation.rest.data.Environment;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class SignatureRequests {

  private static Environment environment;

  static {
    environment = ConfigFactory.create(Environment.class);
  }


  public String signDocumentBody(int identSerialNum, int score, String RefId3, String RefId5) {

    try {
      String signDocumentBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/signdocument.json"),
          StandardCharsets.UTF_8
      );

      JSONObject jObject = new JSONObject(signDocumentBody);
      jObject.getJSONObject("govIssueIdent").put("identSerialNum", identSerialNum);
      jObject.getJSONObject("creditAnalysis").put("score", score);

      JSONArray refInfo = jObject.getJSONArray("refInfo");
      refInfo.getJSONObject(0).put("refId", RefId3);
      refInfo.getJSONObject(1).put("refId", RefId5);
      String JsonModify = jObject.toString();
      return JsonModify;

    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
    }
  }

  public void SignDocument(int IdentSerialNum, String body) throws IOException {

    Random numeroRandom = new Random();
    int XRqUID = numeroRandom.nextInt(999999 - 100000 + 1) + 100000;

    given()
        .contentType("application/json")
        .header("X-Channel", "ADL").relaxedHTTPSValidation()
        .header("X-ServiceName", "Operation").relaxedHTTPSValidation()
        .header("X-BankId", "00010029").relaxedHTTPSValidation()
        .header("X-RqUID", XRqUID).relaxedHTTPSValidation()
        .header("Backend", "ADL").relaxedHTTPSValidation()
        .header("X-Sesskey", "123").relaxedHTTPSValidation()
        .header("X-IPAddr", "127.0.0.1").relaxedHTTPSValidation()
        .header("X-IdentSerialNum", IdentSerialNum).relaxedHTTPSValidation()
        .header("X-ClientDt", "Post").relaxedHTTPSValidation()
        .header("X-Backend", "ElectronicSigInq").relaxedHTTPSValidation()
        .accept("application/json")
        .body(body)
        .when().post(ServicePaths.pathSignDocument());
  }


}