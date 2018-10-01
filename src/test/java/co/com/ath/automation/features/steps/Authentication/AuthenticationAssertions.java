package co.com.ath.automation.features.steps.Authentication;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import net.serenitybdd.rest.SerenityRest;

public class AuthenticationAssertions {

  public static void shouldSeeSuccessfulStatusCodeVillas() {
    // assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.BankId"),
        equalTo(10524));
  }

  public static void shouldSeeSuccessfulStatusCodePopular() {
    //  assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.BankId"),
        equalTo(10029));
  }

  public static void shouldSeeSuccessfulStatusCodeOccidente() {
    //   assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.BankId"),
        equalTo(10236));
  }

  public static void aceptadarojo() {
    //   assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.BankId"),
        equalTo(10236));
  }

  public static void aceptadaaval() {
    //   assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.BankId"),
        equalTo(10999));
  }


}
