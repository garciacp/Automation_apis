package co.com.ath.automation.utils;

import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertionsUtil {

  public static void shouldSeeSuccessfulStatusCode() {
   // assertThat(SerenityRest.then().extract().statusCode(), equalTo(200));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(0));

  }
  public static void shouldSeeNotFoundStatusCode() {
   // assertThat(SerenityRest.then().extract().statusCode(), equalTo(200));
    assertThat(SerenityRest.then().extract().body().jsonPath().get("MsgRsHdr.Status.StatusCode"), equalTo(500));

  }

}
