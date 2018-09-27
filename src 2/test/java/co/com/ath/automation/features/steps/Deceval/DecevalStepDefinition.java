package co.com.ath.automation.features.steps.Deceval;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DecevalStepDefinition {
  DecevalRequest Request = new DecevalRequest();

  @Given("^usuario Nuevo solicita consulta pagare sin pdf")
  public void usuario_Nuevo_solicita_consulta_pagare_sin_pdf(){
  }

  @Given("^usuario Nuevo solicita consulta pagare con pdf")
  public void usuario_Nuevo_solicita_consulta_pagare_con_pdf(){
  }

  @Given("^usuario Nuevo solicita crear otorgante")
  public void usuario_Nuevo_solicita_crear_otorgante(){
  }

  @Given("^usuario Nuevo solicita crear pagare")
  public void usuario_Nuevo_solicita_crear_pagare(){
  }

  @Given("^usuario Nuevo solicita firmar pagare")
  public void usuario_Nuevo_solicita_firmar_pagare(){
  }


  @When("^envia la peticion de consulta sin pdf a deceval$")
  public void envia_la_peticion_de_consulta_sin_pdf_a_deceval() throws Throwable {
    Request.ConsultaPagareSinPdf();
  }

  @When("^envia la peticion de consulta con pdf a  deceval$")
  public void envia_la_peticion_de_consulta_con_pdf_a_deceval() throws Throwable {
    Request.ConsultaPagareConPdf();
  }

  @When("^envia la peticion para crear otorgante$")
  public void envia_la_peticion_para_crear_otorgante() throws Throwable {
    Request.CrearOtorgante();
  }

  @When("^envia la peticion para crear pagare")
  public void envia_la_peticion_para_crear_pagare() throws Throwable {
    Request.CrearPagare();
  }

  @When("^envia la peticion para firmar pagare")
  public void envia_la_peticion_para_firmar_pagare() throws Throwable {
    Request.FirmarPagare();
  }

  @Then("^la consulta debe ser aprobada")
  public void la_consulta_debe_ser_aprobada() {
    DecevalAssertion.Consultaaprobada();
  }

  @Then("^la consulta debe ser rechazada$")
  public void la_consulta_debe_ser_rechazada() {
    DecevalAssertion.Consultarechazada();
  }









}
