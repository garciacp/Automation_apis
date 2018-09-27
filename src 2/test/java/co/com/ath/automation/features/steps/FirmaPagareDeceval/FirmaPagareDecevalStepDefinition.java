package co.com.ath.automation.features.steps.FirmaPagareDeceval;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;

public class FirmaPagareDecevalStepDefinition {
FirmaPagareDecevalRequest Request = new FirmaPagareDecevalRequest();


  @Given("^usuario firma pagare")
  public void Usernew_firmaPagare(){
  }

  @When("^envia la peticion firma pagare$")
  public void Send_request_firma_pagare() throws IOException {
    Request.FirmaPagare();
  }

  @Then("^debe aprobar firma pagare$")
  public void Acceptad_firma_pagare(){
    FirmaPagareDecevalAssertion.approvedAssertion();
  }
}



