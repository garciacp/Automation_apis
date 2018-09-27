package co.com.ath.automation.features.steps.signature;


import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignatureAssertions {
    public static void shouldSeeSuccessfulStatusCode500() {
        assertThat(SerenityRest.then().extract().body().jsonPath().get("msgRsHdr.status.statusCode"), equalTo(500));
       // assertThat(SerenityRest.then().extract().body().jsonPath().get("msgRsHdr.status.serverStatusCode"), equalTo(50));
    }

    public static void shouldSeeSuccessfulStatusCode00() {
        assertThat(SerenityRest.then().extract().body().jsonPath().get("msgRsHdr.status.statusCode"), equalTo(0));
        // assertThat(SerenityRest.then().extract().body().jsonPath().get("msgRsHdr.status.serverStatusCode"), equalTo(50));
    }

}

