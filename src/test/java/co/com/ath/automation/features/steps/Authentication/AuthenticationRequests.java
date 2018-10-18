package co.com.ath.automation.features.steps.Authentication;

import static net.serenitybdd.rest.SerenityRest.given;

import co.com.ath.automation.rest.apis.ServicePaths;
import co.com.ath.automation.rest.data.Environment;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class AuthenticationRequests {

  private static Environment environment;

<<<<<<< HEAD
  static {
    environment = ConfigFactory.create(Environment.class);
  }
=======
    final static Logger logger = Logger.getLogger(AuthenticationRequests.class);

    static {
        environment = ConfigFactory.create(Environment.class);
    }
>>>>>>> ad880ab25e19d497f27a924c39831a9097ebdddc


  public String authenticationBody(int identSerialNum, String otpType, String Phone) {

    try {
      String authenticationBody = IOUtils.toString(
          this.getClass().getClassLoader().getResourceAsStream("json/authentication.json"),
          StandardCharsets.UTF_8
      );

      JSONObject jObject = new JSONObject(authenticationBody);
      jObject.getJSONObject("govIssueIdent").put("identSerialNum", identSerialNum);
      jObject.getJSONObject("otpInfo").put("otpType", otpType);

      if (!Phone.equals(""))
      {
        jObject.getJSONObject("contactInfo").getJSONObject("phoneNum").put("phone", Phone);
      }


      String jsonModify = jObject.toString();
      return jsonModify;

<<<<<<< HEAD
    } catch (IOException e) {
      throw new RuntimeException("Error reading file");
=======
    public void Authentication(int IdentSerialNum, String bankid, String body) throws IOException {
        Random numeroRandom = new Random();
        int XRqUID = numeroRandom.nextInt(999999-100000+1) + 100000;
        System.out.print("**** Autenticacion *** "+ServicePaths.pathAuthentication());
        given()
            .contentType("application/json")
            .header("X-RqUID", XRqUID).relaxedHTTPSValidation()
            .header("X-Channel", "ADL").relaxedHTTPSValidation()
            .header("X-BankId", bankid).relaxedHTTPSValidation()
            .header("X-IdentSerialNum", IdentSerialNum).relaxedHTTPSValidation()
            .header("X-IPAddr", "127.0.0.1").relaxedHTTPSValidation()
            .header("X-Sesskey", "sessionKey").relaxedHTTPSValidation()
            .header("X-OperationName", "Post").relaxedHTTPSValidation()
            .header("X-ServiceName", "Authentication").relaxedHTTPSValidation()
            .header("X-Backend", "ElectronicSigInq").relaxedHTTPSValidation()
            .accept("application/json")
            .body(body)
            .when().post(ServicePaths.pathAuthentication());
>>>>>>> ad880ab25e19d497f27a924c39831a9097ebdddc
    }
  }


  public void authentication(int IdentSerialNum, String bankid, String body) throws IOException {
    Random numeroRandom = new Random();
    int XRqUID = numeroRandom.nextInt(999999 - 100000 + 1) + 100000;

    given()
        .contentType("application/json")
        .header("X-RqUID", XRqUID).relaxedHTTPSValidation()
        .header("X-Channel", "ADL").relaxedHTTPSValidation()
        .header("X-BankId", bankid).relaxedHTTPSValidation()
        .header("X-IdentSerialNum", IdentSerialNum).relaxedHTTPSValidation()
        .header("X-IPAddr", "127.0.0.1").relaxedHTTPSValidation()
        .header("X-Sesskey", "sessionKey").relaxedHTTPSValidation()
        .header("X-Backend", "ElectronicSigInq").relaxedHTTPSValidation()
        .header("X-OperationName", "autenticacion").relaxedHTTPSValidation()
        .header("X-ServiceName", "autenticacion").relaxedHTTPSValidation()
        .header("X-govIssueIdentType", "CC").relaxedHTTPSValidation()
        .accept("application/json")
        .body(body)
        .when().post(ServicePaths.pathAuthentication());
  }

}
