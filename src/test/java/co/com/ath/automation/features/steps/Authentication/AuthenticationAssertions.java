package co.com.ath.automation.features.steps.Authentication;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import net.serenitybdd.rest.SerenityRest;

public class AuthenticationAssertions {

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
  }

}
