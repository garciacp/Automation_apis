package co.com.ath.automation.features.steps.signature;

import co.com.ath.automation.utils.AssertionsUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Random;

public class SignatureStepsDefinition {
    SignatureRequests Request = new SignatureRequests();
    String bodyRequest;
    int identSerialNum;
    Random numeroRandom = new Random();


    @Given("^Usuario Nuevo no acepta TDP y no acepta TYC$")
    public void New_User_does_not_accept_TDP_and_does_not_accept_TYC(){
        identSerialNum = numeroRandom.nextInt(999999-100000+1) + 100000;
        bodyRequest = Request.signDocumentBody(identSerialNum,90,"false","false");
    }

    @Given("^Usuario Nuevo no acepta TDP y si acepta TYC$")
    public void New_user_who_does_not_accept_tdp_and_if_he_accepts_tyc(){
        identSerialNum = numeroRandom.nextInt(999999-100000+1) + 100000;
        bodyRequest = Request.signDocumentBody(identSerialNum,90,"false","true");
    }

        @Given("^Usuario Nuevo si acepta TDP y no acepta TYC$")
        public void New_user_if_he_accept_tdp_and_does_not_accept_TYC(){
            identSerialNum = numeroRandom.nextInt(999999-100000+1) + 100000;
            bodyRequest = Request.signDocumentBody(identSerialNum,90,"true","false");
        }

        @Given("^Usuario Nuevo si acepta TDP y si acepta TYC$")
        public void New_user_if_he_accept_tdp_and_if_he_accepts_tyc(){
            identSerialNum = numeroRandom.nextInt(999999-100000+1) + 100000;
            bodyRequest = Request.signDocumentBody(identSerialNum,90,"true","true");
        }

           @Given("^Usuario Registrado no acepta TDP y no acepta TYC$")
           public void registered_user_does_not_accept_TDP_and_does_not_accept_TYC(){
               identSerialNum = 363138;
               bodyRequest = Request.signDocumentBody(identSerialNum,90,"false","false");
           }

           @Given("^Usuario Registrado no acepta TDP y si acepta TYC$")
           public void registered_user_who_does_not_accept_tdp_and_if_he_accepts_tyc(){
               identSerialNum = 363138;
               bodyRequest = Request.signDocumentBody(identSerialNum,90,"false","true");
           }

           @Given("^Usuario Registrado si acepta TDP y no acepta TYC$")
           public void registered_user_if_he_accept_tdp_and_does_not_accept_TYC(){
               identSerialNum = 363138;
               bodyRequest = Request.signDocumentBody(identSerialNum,90,"true","false");
           }

           @Given("^Usuario Registrado si acepta TDP y si acepta TYC$")
           public void registered_user_if_he_accept_tdp_and_if_he_accepts_tyc(){
               identSerialNum = 363138;
               bodyRequest = Request.signDocumentBody(identSerialNum,90,"true","true");
           }

           @Given("^Usuario Nuevo con un score menor a 89$")
           public void New_user_small_score_90(){
               identSerialNum = numeroRandom.nextInt(999999-100000+1) + 100000;
               bodyRequest = Request.signDocumentBody(identSerialNum,89,"true","true");
           }

           @Given("^Usuario Nuevo con un score igual a 90$")
           public void New_user_equal_score_90(){
               identSerialNum = numeroRandom.nextInt(999999-100000+1) + 100000;
               bodyRequest = Request.signDocumentBody(identSerialNum,90,"true","true");
           }

           @Given("^Usuario Nuevo con un score mayor a 91$")
           public void New_user_greater_score_90(){
               identSerialNum = numeroRandom.nextInt(999999-100000+1) + 100000;
               bodyRequest = Request.signDocumentBody(identSerialNum,91,"true","true");
           }

    @When("^el envia la peticion para que sea firmada digitalmente$")
    public void he_sends_the_request_to_enter() throws Throwable {
        Request.SignDocument(identSerialNum, bodyRequest);
    }

    @Then("^la peticion debe ser aprobada$")
    public void Approved_request() {
        SignatureAssertions.shouldSeeSuccessfulStatusCode00();
    }

    @Then("^la peticion debe ser declinada$")
    public void rejected_request() {
        SignatureAssertions.shouldSeeSuccessfulStatusCode500();
    }

}
