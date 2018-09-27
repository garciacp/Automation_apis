package co.com.ath.automation.features.steps.CrearGirator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class CrearGiratorStepDefinition {
    CrearGiratorRequest Request = new CrearGiratorRequest();

    @Given("^el es un usuario")
    public void User(){
    }

    @When("^envia la peticion$")
    public void Send_request() throws IOException {
        Request.CrearGirator();
    }

    @Then("^debe aprobar$")
    public void Acceptad(){
            CrearGiratorAssertion.approvedAssertion();
        }
    }



