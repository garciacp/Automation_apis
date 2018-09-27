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

    @Given("^dato seguro en \"([^\"]*)\" solicita autenticacion en \"([^\"]*)\"$")
    public void User_request_bank (String DatoSeguro, String Banco){
      switch (DatoSeguro) {
        case "rojo":
          dato_seguro = environment.datoseguro_rojo();
          break;
        case "azul":
          dato_seguro = environment.datoseguro_azul();
          break;
        case "verde":
          dato_seguro = environment.datoseguro_verde();
          break;
        case "rojo - azul":
          dato_seguro = environment.datoseguro_rojo_azul();
          break;
        case "rojo - verde":
          dato_seguro = environment.datoseguro_rojo_verde();
          break;
        case "azul - verde":
          dato_seguro = environment.datoseguro_verde_azul();
          break;
        case "rojo - azul - verde":
          dato_seguro = environment.datoseguro_rojo_azul();
          break;
        default:
          dato_seguro = 000000;
          break;
      }

      switch (Banco) {
      case "rojo":
        BankId = environment.BankidVillas();
        TypeTx = environment.OtpTypeVillas();
      break;

      case "azul":
        BankId = environment.BankidOccidente();
        TypeTx = environment.OtpTypeOccidente();
      break;

      case "verde":
        BankId = environment.BankidPopular();
        TypeTx = environment.OtpTypePopular();
      break;

      default:
      dato_seguro = 9999;
      break;
    }
    bodyRequest = Request.AuthenticationBody(dato_seguro, TypeTx );
     }


    @Given("^dato seguro en rojo solicita producto en azul$")
    public void User_red_request_product_blue(){
        bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo(), environment.OtpTypeVillas());
        dato_seguro = environment.datoseguro_rojo();
        BankId = environment.BankidOccidente();
    }

    @Given("^dato seguro en rojo solicita producto en verde")
    public void User_red_request_product_green(){
        bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo(), environment.OtpTypeVillas());
        dato_seguro = environment.datoseguro_rojo();
        BankId = environment.BankidPopular();
    }

    @Given("^dato seguro en rojo solicita producto en rojo")
    public void User_red_request_product_red(){
        bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo(), environment.OtpTypeVillas());
        dato_seguro = environment.datoseguro_rojo();
        BankId = environment.BankidVillas();
    }

    @Given("^dato seguro en rojo y verde solicita producto en rojo")
    public void User_red_green_request_product_red(){
        bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_verde(), environment.OtpTypeVillas());
        dato_seguro = environment.datoseguro_rojo_verde();
        BankId = environment.BankidVillas();
    }

    @Given("^dato seguro en rojo y verde solicita producto en verde")
    public void User_red_green_request_product_green(){
        bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_verde(), environment.OtpTypePopular());
        dato_seguro = environment.datoseguro_rojo_verde();
        BankId = environment.BankidPopular();
    }


     @Given("^dato seguro en rojo y verde solicita producto en azul")
     public void User_red_green_request_product_blue(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_verde(),environment.OtpTypeVillas());
         dato_seguro =environment.datoseguro_rojo_verde();
         BankId = environment.BankidOccidente();
     }

     @Given("^dato seguro en rojo y azul solicita producto en rojo")
     public void User_red_blue_request_product_red(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_azul(),environment.OtpTypeVillas());
         dato_seguro = environment.datoseguro_rojo_azul();
         BankId = environment.BankidVillas();
     }

     @Given("^dato seguro en rojo y azul solicita producto en verde")
     public void User_red_blue_request_product_green(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_azul(),environment.OtpTypeVillas());
         dato_seguro = environment.datoseguro_rojo_azul();
         BankId = environment.BankidPopular();
     }

     @Given("^dato seguro en rojo y azul solicita producto en azul")
     public void User_red_blue_request_product_blue(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_azul(),environment.OtpTypeOccidente());
         dato_seguro = environment.datoseguro_rojo_azul();
         BankId = environment.BankidOccidente();
     }
     @Given("^dato seguro en rojo - azul y verde solicita producto en rojo")
     public void User_red_blue_green_request_product_red(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_verde_azul(),environment.OtpTypeVillas());
         dato_seguro = environment.datoseguro_rojo_verde_azul();
         BankId = environment.BankidVillas();
     }
     @Given("^dato seguro en rojo - azul y verde solicita producto en verde")
     public void User_red_blue_green_request_product_green(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_verde_azul(),environment.OtpTypePopular());
         dato_seguro = environment.datoseguro_rojo_verde_azul();
         BankId = environment.BankidPopular();
     }
     @Given("^dato seguro en rojo - azul y verde solicita producto en azul")
     public void User_red_blue_green_request_product_blue(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_rojo_verde_azul(),environment.OtpTypeOccidente());
         dato_seguro = environment.datoseguro_rojo_verde_azul();
         BankId = environment.BankidOccidente();
     }
     @Given("^dato seguro en verde solicita producto en azul")
     public void User_green_request_product_blue(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_verde(),environment.OtpTypePopular());
         dato_seguro = environment.datoseguro_verde();
         BankId = environment.BankidOccidente();
     }
     @Given("^dato seguro en verde solicita producto en verde")
     public void User_green_request_product_green(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_verde(),environment.OtpTypePopular());
         dato_seguro = environment.datoseguro_verde();
         BankId = environment.BankidPopular();
     }
     @Given("^dato seguro en verde solicita producto en rojo")
     public void User_green_request_product_red(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_verde(),environment.OtpTypePopular());
         dato_seguro = environment.datoseguro_verde();
         BankId = environment.BankidVillas();
     }
     @Given("^dato seguro en verde y azul solicita producto en rojo")
     public void User_green_blue_request_product_red(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_verde_azul(),environment.OtpTypeOccidente());
         dato_seguro = environment.datoseguro_verde_azul();
         BankId = environment.BankidVillas();
     }
     @Given("^dato seguro en verde y azul solicita producto en verde")
     public void User_green_blue_request_product_green(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_verde_azul(),environment.OtpTypePopular());
         dato_seguro = environment.datoseguro_verde_azul();
         BankId = environment.BankidPopular();
     }
     @Given("^dato seguro en verde y azul solicita producto en azul")
     public void User_green_blue_request_product_blue(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_verde_azul(),environment.OtpTypeOccidente());
         dato_seguro = environment.datoseguro_verde_azul();
         BankId = environment.BankidOccidente();
     }
     @Given("^dato seguro en azul solicita producto en rojo")
     public void User_blue_request_product_red(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_azul(),environment.OtpTypeOccidente());
         dato_seguro = environment.datoseguro_azul();
         BankId = environment.BankidVillas();
     }
     @Given("^dato seguro en azul solicita producto en verde")
     public void User_blue_request_product_green(){
         bodyRequest = Request.AuthenticationBody(environment.datoseguro_azul(),environment.OtpTypeOccidente());
         dato_seguro = environment.datoseguro_azul();
         BankId = environment.BankidPopular();
     }

     @Given("^dato seguro en azul solicita producto en azul")
  public void User_blue_request_product_blue(){
    bodyRequest = Request.AuthenticationBody(environment.datoseguro_azul(),environment.OtpTypeOccidente());
    dato_seguro = environment.datoseguro_azul();
    BankId = environment.BankidOccidente();
  }

  @Given("^usuario sin dato seguro solicita producto")
  public void User_new_sin_dato(){
    bodyRequest = Request.AuthenticationBody(environment.datoseguro_cifin(),environment.OtpTypeOccidente());
    dato_seguro = environment.datoseguro_cifin();
    BankId = environment.BankidOccidente();
  }


    @When("^el envia la peticion para ser autenticado$")
    public void he_sends_the_request_to_enter_authentication() throws Throwable {
        Request.Authentication(dato_seguro, BankId, bodyRequest);
    }


    @Then("^la peticion debe ser aprobada en rojo$")
    public void Approved_request_red() {
        AuthenticationAssertions.shouldSeeSuccessfulStatusCodeVillas();
    }

    @Then("^la peticion debe ser aprobada en verde$")
    public void Approved_request_green() {
        AuthenticationAssertions.shouldSeeSuccessfulStatusCodePopular();
    }

    @Then("^la peticion debe ser aprobada en azul$")
    public void Approved_request_blue() {
        AuthenticationAssertions.shouldSeeSuccessfulStatusCodeOccidente();
    }

    @Then("^la peticion debe ser aprobada en cifin$")
    public void Approved_request_cifin() {
    AuthenticationAssertions.aceptadacifin();
    }

}
