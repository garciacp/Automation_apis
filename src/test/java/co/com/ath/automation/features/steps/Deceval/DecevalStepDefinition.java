package co.com.ath.automation.features.steps.Deceval;

import cucumber.api.java.en.And;
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

  @When("^envia la peticion para crear otorgante$")
  public void envia_la_peticion_para_crear_otorgante() throws Throwable {
    Request.CrearOtorgante(DecevalStaticCode.NUMER_DIAS_IGUAL, null);
  }

  @And("^el cliente ya existe$")
  public void  valida_cliente_existe()throws Throwable{
    DecevalAssertion.approvedAssertionGirator(DecevalStaticCode.CODE_OTORGANTE);
  }




  @Given("^usuario Nuevo solicita crear pagare")
  public void usuario_Nuevo_solicita_crear_pagare(){
  }

  @Given("^usuario Nuevo solicita firmar pagare")
  public void usuario_Nuevo_solicita_firmar_pagare(){
  }


  @When("^envia la peticion de consulta sin pdf a deceval$")
  public void envia_la_peticion_de_consulta_sin_pdf_a_deceval() throws Throwable {
    Request.ConsultaPagareSinPdf(DecevalStaticCode.NUMER_DIAS_IGUAL);
  }

  @When("^envia la peticion de consulta con pdf a  deceval$")
  public void envia_la_peticion_de_consulta_con_pdf_a_deceval() throws Throwable {
    Request.ConsultaPagareConPdf(DecevalStaticCode.NUMER_DIAS_IGUAL,null, null);
  }

  @When("^envia la peticion para crear pagare")
  public void envia_la_peticion_para_crear_pagare() throws Throwable {
    Request.CrearPagare(DecevalStaticCode.NUMER_DIAS_IGUAL,null, "");
  }

  @When("^envia la peticion para firmar pagare")
  public void envia_la_peticion_para_firmar_pagare() throws Throwable {
    Request.FirmarPagare(DecevalStaticCode.NUMER_DIAS_IGUAL,null);
  }

  @Then("^la consulta debe ser aprobada otorgante")
  public void la_consulta_debe_ser_aprobada_otorgante() {
    DecevalAssertion.Consultaaprobada(DecevalStaticCode.CODE_OTORGANTE);
  }

  @Then("^la consulta debe ser aprobada pagare")
  public void la_consulta_debe_ser_aprobada_pagare() {
    DecevalAssertion.Consultaaprobada(DecevalStaticCode.CODE_PAGARE);
  }

  @Then("^la firma debe ser aprobada")
  public void la_firma_debe_ser_aprobada() {
    DecevalAssertion.assertionFirmaPagareAprobada(DecevalStaticCode.COD_DESC_ERROR);
  }

  @Then("^la consulta debe ser rechazada$")
  public void la_consulta_debe_ser_rechazada() {
    DecevalAssertion.Consultarechazada(DecevalStaticCode.CODE_PAGARE);
  }



  @Given("^usuario solicita crear nuevo otorgante con fecha hoy incorrecta$")
  public void usuario_solicita_crear_nuevo_otorgante_con_fecha_hoy_incorrecta() throws Throwable {
    // Write code here that turns the phrase above into concrete action
  }

  @When("^usuario envia solicitud crear nuevo otorgante$")
  public void usuario_envia_solicitud_crear_nuevo_otorgante() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.CrearOtorgante(DecevalStaticCode.NUMERO_DIAS_MAS, null);
  }

  @Then("^la solicitud es rechazada por fecha incorrecta$")
  public void la_solicitud_es_rechazada_por_fecha_incorrecta() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.crearGiradorechazado(DecevalStaticCode.CODE_DESC_OTORGANTE);
  }


  @Given("^usuario envia creacion otorgante sin algun campo obligatorio$")
  public void usuario_envia_creacion_otorgante_sin_algun_campo_obligatorio() throws Throwable {
  }

  @When("^usuario envia solicitud crear nuevo otorgante sin algun campo obligatorio$")
  public void usuario_envia_solicitud_crear_nuevo_otorgante_sin_algun_campo_obligatorio() throws Throwable {
    Request.CrearOtorgante(DecevalStaticCode.NUMER_DIAS_IGUAL, DecevalStaticCode.COD_ELIMINAR_NODO);
  }

  @Then("^la solicitud es rechazada indicando el error en el header$")
  public void la_solicitud_es_rechazada_indicando_el_error_en_el_header() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionCrearOtorganteRechazada(DecevalStaticCode.CODE_OTORGANTE);
  }

  /**
   * usuario envia solicitud de consulta pagare con pdf con id inexistente
   * @throws Throwable
   */
  @Given("^usuario envia solicitud consulta pagare con pdf con id inexistente$")
  public void usuario_envia_solicitud_consulta_pagare_con_pdf_con_id_inexistente() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^usuario envia solicitud consulta pagare con pdf$")
  public void usuario_envia_solicitud_consulta_pagare_con_pdf() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    String numeroId = "1999";
    Request.ConsultaPagareConPdf(DecevalStaticCode.NUMER_DIAS_IGUAL,numeroId,null);
  }

  @Then("^el servicio debe responder no existe id pagare$")
  public void el_servicio_debe_responder_no_existe_id_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionConsultaPdfRechazada(DecevalStaticCode.CODE_PAGARE, DecevalStaticCode.COD_RSPTA_NO_EXISTE_INFO);
  }


  /**
   * usuario envia solicitud de consulta con fecha hoy incorrecta
   */
  @Given("^usuario envia solicitud de consulta con fecha hoy$")
  public void usuario_envia_solicitud_de_consulta_con_fecha_hoy() throws Throwable {
    // Write code here that turns the phrase above into concrete actions

  }

  @When("^usuario envia solicitud consulta pagare con pdf con fecha hoy incorrecta$")
  public void usuario_envia_solicitud_consulta_pagare_con_pdf_con_fecha_hoy_incorrecta() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.ConsultaPagareConPdf(DecevalStaticCode.NUMERO_DIAS_MAS,null,null);
  }

  @Then("^el servicio debe responder error en fecha hoy$")
  public void el_servicio_debe_responder_error_en_fecha_hoy() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionConsultaPdfRechazada(DecevalStaticCode.CODE_PAGARE, DecevalStaticCode.COD_RSPTA_CONSULTA_RECHAZADA);
  }

  /**
   * usuario envia solicitud de consulta sin algun campo obligatorio
   * @throws Throwable
   */
  @Given("^usuario envia solicitud de consulta pagare sin algun campo obligatorio$")
  public void usuario_envia_solicitud_de_consulta_pagare_sin_algun_campo_obligatorio() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^usuario envia solicitud de consulta pagare sin campo pagare$")
  public void usuario_envia_solicitud_de_consulta_pagare_sin_campo_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.ConsultaPagareConPdf(DecevalStaticCode.NUMER_DIAS_IGUAL,null,DecevalStaticCode.COD_ELIMINAR_NODO);
  }

  @Then("^la solicitud es rechazada indicando pagare requerido$")
  public void la_solicitud_es_rechazada_indicando_pagare_requerido() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionConsultaPdfRechazada(DecevalStaticCode.CODE_PAGARE, DecevalStaticCode.COD_RSPTA_CONSULTA_PAGARE_REQUERIDO);
  }

  @Given("^el usuario solicita crear pagare sin cuenta otorgante$")
  public void el_usuario_solicita_crear_pagare_sin_cuenta_otorgante() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^el usuario envia la peticion para crear pagare sin cuenta otorgante$")
  public void el_usuario_envia_la_peticion_para_crear_pagare_sin_cuenta_otorgante() throws Throwable {
    Request.CrearPagare(DecevalStaticCode.NUMER_DIAS_IGUAL,DecevalStaticCode.COD_ELIMINAR_NODO, DecevalStaticCode.CREAR_PAGARE_POSICION_CUENTA_OTORGANTE);

  }

  @Then("^el pagare debe ser creado si se envia numero de documento$")
  public void el_pagare_debe_creado_si_se_envia_numero_de_documentos() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionConsultaPdfRechazada(DecevalStaticCode.CODE_PAGARE,DecevalStaticCode.COD_RSPTA_ERROR);
  }


  @Given("^el usuario solicita crear pagare sin numero pagare$")
  public void el_usuario_solicita_crear_pagare_sin_numero_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^envia la peticion crear pagare sin numero pagare$")
  public void envia_la_peticion_crear_pagare_sin_numero_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.CrearPagare(DecevalStaticCode.NUMER_DIAS_IGUAL,DecevalStaticCode.COD_ELIMINAR_NODO, DecevalStaticCode.CREAR_PAGARE_POSICION_NUM_PAGARE_ENTIDAD);
  }

  @Then("^el servicio debe generar error en la creacion de pagare$")
  public void el_servicio_debe_generar_error_en_la_creacion_de_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.Consultarechazada(DecevalStaticCode.CODE_PAGARE);
  }

  @Given("^el usuario solicita firmar pagare con id inexistente$")
  public void el_usuario_solicita_firmar_pagare_con_id_inexistente() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^envia la peticion firmar pagare con id$")
  public void envia_la_peticion_firmar_pagare_con_id() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.FirmarPagare(DecevalStaticCode.NUMER_DIAS_IGUAL, "XXXX");
  }

  @Then("^el servicio debe generar error id pagare no existe$")
  public void el_servicio_debe_generar_error_id_pagare_no_existe() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.Consultarechazada(DecevalStaticCode.CODE_PAGARE);
  }










}
