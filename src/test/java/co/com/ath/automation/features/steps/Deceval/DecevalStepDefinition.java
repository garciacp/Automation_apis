package co.com.ath.automation.features.steps.Deceval;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DecevalStepDefinition {
  DecevalRequest Request = new DecevalRequest();

  @Given("^el usuario solicita consultar pagare sin pdf")
  public void usuario_Nuevo_solicita_consulta_pagare_sin_pdf(){
  }

  @Given("^el usuario solicita consultar pagare con pdf")
  public void usuario_Nuevo_solicita_consulta_pagare_con_pdf(){
  }

  @Given("^usuario nuevo solicita crear otorgante")
  public void usuario_Nuevo_solicita_crear_otorgante(){
  }

  @When("^el usuario envia la peticion para crear otorgante$")
  public void envia_la_peticion_para_crear_otorgante() throws Throwable {
    Request.CrearOtorgante(DecevalStaticCode.NUMER_DIAS_IGUAL, null);
  }

  @And("^si el otorgante ya existe, se actualiza la informacion del mismo$")
  public void  valida_cliente_existe()throws Throwable{
    DecevalAssertion.approvedAssertionGirator(DecevalStaticCode.CODE_OTORGANTE);
  }




  @Given("^el usuario solicita crear pagare")
  public void usuario_Nuevo_solicita_crear_pagare(){
  }

  @Given("^usuario necesita firmar el pagare creado anteriomente")
  public void usuario_Nuevo_solicita_firmar_pagare(){
  }


  @When("^se envia la peticion de consulta sin pdf a deceval$")
  public void envia_la_peticion_de_consulta_sin_pdf_a_deceval() throws Throwable {
    Request.ConsultaPagareSinPdf(DecevalStaticCode.NUMER_DIAS_IGUAL);
  }

  @When("^se envia la peticion de consulta con pdf a deceval$")
  public void envia_la_peticion_de_consulta_con_pdf_a_deceval() throws Throwable {
    Request.ConsultaPagareConPdf(DecevalStaticCode.NUMER_DIAS_IGUAL,null, null);
  }

  @When("^se envia la peticion para crear pagare en deceval")
  public void envia_la_peticion_para_crear_pagare() throws Throwable {
    Request.CrearPagare(DecevalStaticCode.NUMER_DIAS_IGUAL,null, "");
  }

  @Then("^el resultado de la solicitud de creacion de pagare debe ser aprobada")
  public void el_resultado_de_la_solicitud_de_creacion_de_pagare_debe_ser_aprobada() {
    DecevalAssertion.Consultaaprobada(DecevalStaticCode.CODE_PAGARE);
  }

  @When("^envia la peticion para firmar pagare en deceval")
  public void envia_la_peticion_para_firmar_pagare() throws Throwable {
    Request.FirmarPagare(DecevalStaticCode.NUMER_DIAS_IGUAL,null);
  }

  @Then("^la solicitud de creacion nuevo otorgante debe ser aprobada")
  public void la_consulta_debe_ser_aprobada_otorgante() {
    DecevalAssertion.Consultaaprobada(DecevalStaticCode.CODE_OTORGANTE);
  }

  @Then("^el servicio retorna pagare con pdf")
  public void la_consulta_debe_ser_aprobada_pagare() {
    DecevalAssertion.Consultaaprobada(DecevalStaticCode.CODE_PAGARE);
  }
  @Then("^el servicio retorna pagare sin pdf")
  public void el_servicio_retorna_pagare_sin_pdf() {
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



  @Given("^el usuario solicita crear nuevo otorgante con fecha transaccion incorrecta$")
  public void usuario_solicita_crear_nuevo_otorgante_con_fecha_hoy_incorrecta() throws Throwable {
    // Write code here that turns the phrase above into concrete action
  }

  @When("^usuario envia solicitud crear nuevo otorgante$")
  public void usuario_envia_solicitud_crear_nuevo_otorgante() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.CrearOtorgante(DecevalStaticCode.NUMERO_DIAS_MAS, null);
  }

  @Then("^la solicitud es rechazada por fecha de transaccion incorrecta$")
  public void la_solicitud_es_rechazada_por_fecha_incorrecta() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.crearGiradorechazado(DecevalStaticCode.CODE_DESC_OTORGANTE);
  }


  @Given("^el usuario solicita crear nuevo otorgante sin numero de documento$")
  public void usuario_envia_creacion_otorgante_sin_algun_campo_obligatorio() throws Throwable {
  }

  @When("^usuario envia solicitud de crear nuevo otorgante sin el numero documento$")
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
  @Given("^usuario envia solicitud con un id pagare inexistente en deceval$")
  public void usuario_envia_solicitud_consulta_pagare_con_pdf_con_id_inexistente() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^usuario envia solicitud consulta pagare con pdf$")
  public void usuario_envia_solicitud_consulta_pagare_con_pdf() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    String numeroId = "1999";
    Request.ConsultaPagareConPdf(DecevalStaticCode.NUMER_DIAS_IGUAL,numeroId,null);
  }

  @Then("^el servicio debe responder no existe pagare asociado al id ingresado$")
  public void el_servicio_debe_responder_no_existe_id_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionConsultaPdfRechazada(DecevalStaticCode.CODE_PAGARE, DecevalStaticCode.COD_RSPTA_NO_EXISTE_INFO);
  }


  /**
   * usuario envia solicitud de consulta con fecha hoy incorrecta
   */
  @Given("^usuario desea consultar pagare con de transaccion diferente a hoy$")
  public void usuario_envia_solicitud_de_consulta_con_fecha_hoy() throws Throwable {
    // Write code here that turns the phrase above into concrete actions

  }

  @When("^usuario envia solicitud consulta pagare con pdf con fecha transaccion incorrecta$")
  public void usuario_envia_solicitud_consulta_pagare_con_pdf_con_fecha_hoy_incorrecta() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.ConsultaPagareConPdf(DecevalStaticCode.NUMERO_DIAS_MAS,null,null);
  }

  @Then("^el servicio debe responder error en fecha de transaccion$")
  public void el_servicio_debe_responder_error_en_fecha_hoy() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionConsultaPdfRechazada(DecevalStaticCode.CODE_PAGARE, DecevalStaticCode.COD_RSPTA_CONSULTA_RECHAZADA);
  }

  /**
   * usuario envia solicitud de consulta sin algun campo obligatorio
   * @throws Throwable
   */
  @Given("^usuario desea consultar un pagare pero desconoce el codigo$")
  public void usuario_envia_solicitud_de_consulta_pagare_sin_algun_campo_obligatorio() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^usuario envia solicitud de consulta pagare sin campo codigo pagare$")
  public void usuario_envia_solicitud_de_consulta_pagare_sin_campo_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.ConsultaPagareConPdf(DecevalStaticCode.NUMER_DIAS_IGUAL,null,DecevalStaticCode.COD_ELIMINAR_NODO);
  }

  @Then("^la solicitud es rechazada indicando que el codigo pagare es requerido$")
  public void la_solicitud_es_rechazada_indicando_pagare_requerido() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionConsultaPdfRechazada(DecevalStaticCode.CODE_PAGARE, DecevalStaticCode.COD_RSPTA_CONSULTA_PAGARE_REQUERIDO);
  }

  @Given("^el usuario solicita crear un pagare sin conocer la cuenta otorgante$")
  public void el_usuario_solicita_crear_pagare_sin_cuenta_otorgante() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^el usuario envia la peticion para crear pagare sin cuenta otorgante$")
  public void el_usuario_envia_la_peticion_para_crear_pagare_sin_cuenta_otorgante() throws Throwable {
    Request.CrearPagare(DecevalStaticCode.NUMER_DIAS_IGUAL,DecevalStaticCode.COD_ELIMINAR_NODO, DecevalStaticCode.CREAR_PAGARE_POSICION_CUENTA_OTORGANTE);

  }

  @Then("^el pagare debe ser creado si se envia numero de documento del otorgante$")
  public void el_pagare_debe_creado_si_se_envia_numero_de_documentos() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.assertionConsultaPdfRechazada(DecevalStaticCode.CODE_PAGARE,DecevalStaticCode.COD_RSPTA_ERROR);
  }


  @Given("^el usuario solicita crear un pagare sin conocer el numero pagare en la entidad$")
  public void el_usuario_solicita_crear_pagare_sin_numero_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^envia la peticion de crear pagare sin el numero pagare de la entidad$")
  public void envia_la_peticion_crear_pagare_sin_numero_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.CrearPagare(DecevalStaticCode.NUMER_DIAS_IGUAL,DecevalStaticCode.COD_ELIMINAR_NODO, DecevalStaticCode.CREAR_PAGARE_POSICION_NUM_PAGARE_ENTIDAD);
  }

  @Then("^el servicio genera error en la creacion de pagare$")
  public void el_servicio_debe_generar_error_en_la_creacion_de_pagare() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.Consultarechazada(DecevalStaticCode.CODE_PAGARE);
  }

  @Given("^el usuario desea firmar un pagare con un codigo inexistente$")
  public void el_usuario_solicita_firmar_pagare_con_id_inexistente() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }

  @When("^envia la peticion firmar pagare con codigo inexistente$")
  public void envia_la_peticion_firmar_pagare_con_id() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.FirmarPagare(DecevalStaticCode.NUMER_DIAS_IGUAL, "XXXX");
  }

  @Then("^el servicio debe generar error codigo pagare no existe$")
  public void el_servicio_debe_generar_error_id_pagare_no_existe() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    DecevalAssertion.Consultarechazada(DecevalStaticCode.CODE_PAGARE);
  }



  /**
   * usuario solicita cancelar pagare
   */
  @Given("^el usuario solicita cancelar pagare con codigo existente$")
  public void el_usuario_solicita_cancelar_pagare_con_id_existente() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }
  @When("^envia la peticion de cancelar pagare con codigo existente$")
  public void envia_la_peticion_de_cancelar_pagare_con_id_existente() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Request.cancelarPagare(DecevalStaticCode.NUMER_DIAS_IGUAL, null, null);
  }

  @Then("^el servicio debe respoder error de amortización ya que no existe cambio de esta previo$")
  public void el_servicio_debe_respoder_con_la_cancelacion_del_pagare_exitoso() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  }





}
