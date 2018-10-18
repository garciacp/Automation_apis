package co.com.ath.automation.features.steps.Authentication;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import net.serenitybdd.rest.SerenityRest;

public class AuthenticationAssertions {

<<<<<<< HEAD
  public static void shouldSeeCodeIdBankRed() {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo("00010524"));
  }

  public static void shouldSeeCodeIdBankGreen() {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo("00010029"));
  }

  public static void shouldSeeCodeIdBankBlue() {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo("00010236"));
  }

  public static void shouldSeeCodeIdBankAval() {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo("00010999"));
  }

  public static void shouldSeeCodeDatacredito() {
    assertThat(SerenityRest.then().extract().body().jsonPath().get("msgRsHdr.Status.StatusCode"),
        equalTo(0));
=======
  public static void shouldSeeSuccessfulStatusCodeVillas() {
    // assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo(10524));
  }

  public static void shouldSeeSuccessfulStatusCodePopular() {
    //  assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo(10029));
  }

  public static void shouldSeeSuccessfulStatusCodeOccidente() {
    //   assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo(10236));
  }

  public static void aceptadarojo() {
    //   assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo(10236));
  }

  public static void aceptadaaval() {
    //   assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("bankInfo.bankId"),
        equalTo(10999));
>>>>>>> ad880ab25e19d497f27a924c39831a9097ebdddc
  }

}
