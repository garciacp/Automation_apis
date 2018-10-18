package co.com.ath.automation.features.steps.Authentication;

import co.com.ath.automation.rest.data.Environment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.aeonbits.owner.ConfigFactory;

public class AuthenticationStepsDefinition {

  private static Environment environment;

  static {
    environment = ConfigFactory.create(Environment.class);
  }

  AuthenticationRequests Request = new AuthenticationRequests();
  String bodyRequest;
  int dato_seguro;
  String BankId;
  String TypeTx;


  @Given("^un usuario con datos seguro en (.*) solicita autenticacion en el banco (.*)$")
  public void userRequestAuthentication(String DatoSeguro, String Banco) {
    switch (DatoSeguro) {
      case "rojo":
        System.out.println("entro en 1:");
        dato_seguro = environment.datoSeguroRojo();
        break;
      case "azul":
        dato_seguro = environment.datoSeguroAzul();
        break;
      case "verde":
        dato_seguro = environment.datoSeguroVerde();
        break;
      case "rojo - azul":
        dato_seguro = environment.datoSeguroRojoAzul();
        break;
      case "rojo - verde":
        dato_seguro = environment.datoSeguroRojoVerde();
        break;
      case "azul - verde":
        dato_seguro = environment.datoSeguroVerdeAzul();
        break;
      case "rojo - azul - verde":
        dato_seguro = environment.datoSeguroRojoVerdeAzul();
        break;
      default:
        dato_seguro = 000000;
        break;
    }

    switch (Banco) {
      case "rojo":

        BankId = environment.bankIdVillas();
        TypeTx = environment.otpTypeVillas();
        break;

      case "azul":
        BankId = environment.bankIdOccidente();
        TypeTx = environment.otpTypeOccidente();
        break;

      case "verde":
        BankId = environment.bankIdPopular();
        TypeTx = environment.otpTypePopular();
        break;

      default:
        dato_seguro = 9999;
        break;
    }
    bodyRequest = Request.authenticationBody(dato_seguro, TypeTx, "");
  }

  @Given("^un usuario que esta registrado en datacredito solicita validacion en el banco (.*)$")
  public void userRequestDatacredito(String Banco) {
    switch (Banco) {
      case "rojo":
        BankId = environment.bankIdVillas();
        TypeTx = environment.otpTypeVillas();
        break;

      case "azul":
        BankId = environment.bankIdOccidente();
        TypeTx = environment.otpTypeOccidente();
        break;

      case "verde":
        BankId = environment.bankIdPopular();
        TypeTx = environment.otpTypePopular();
        break;

      default:
        dato_seguro = 9999;
        break;
    }
    bodyRequest = Request.authenticationBody(environment.datoSeguroDatacredito(), TypeTx, "3005501111");
  }

  @Given("^un usuario que esta registrado en cifin solicita validacion en el banco (.*)$")
  public void userRequestCifin(String Banco) {
    switch (Banco) {
      case "rojo":
        BankId = environment.bankIdVillas();
        TypeTx = environment.otpTypeVillas();
        break;

      case "azul":
        BankId = environment.bankIdOccidente();
        TypeTx = environment.otpTypeOccidente();
        break;

      case "verde":
        BankId = environment.bankIdPopular();
        TypeTx = environment.otpTypePopular();
        break;

      default:
        dato_seguro = 9999;
        break;
    }
    bodyRequest = Request.authenticationBody(environment.datoSeguroCifin(), TypeTx, "3003590317");
  }


  @When("^el envia la peticion para ser autenticado$")
  public void sendRequestAuthentication() throws Throwable {
    Request.authentication(dato_seguro, BankId, bodyRequest);
  }

  @Then("^La peticion debe ser contestada por el (.*)$")
  public void requestBankAutorization(String BancoAutorizador) throws Throwable {
    switch (BancoAutorizador) {
      case "rojo":
        AuthenticationAssertions.shouldSeeCodeIdBankRed();
        break;

      case "azul":
        AuthenticationAssertions.shouldSeeCodeIdBankBlue();
        break;

      case "verde":
        AuthenticationAssertions.shouldSeeCodeIdBankGreen();
        break;

      default:
        AuthenticationAssertions.shouldSeeCodeIdBankAval();
        break;

    }
  }
  @Then("^La peticion debe ser contestada por datacredito$")
  public void requestDatacredito() throws Throwable {
    AuthenticationAssertions.shouldSeeCodeDatacredito();
  }

  @Then("^La peticion debe ser contestada por cifin")
  public void requestCifin() throws Throwable {
    AuthenticationAssertions.shouldSeeCodeIdBankAval();
  }



}
