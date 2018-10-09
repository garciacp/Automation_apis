package co.com.ath.automation.rest.data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:staging.properties"})

public interface Environment extends Config {

  @DefaultValue("999999")
  String url_signature_2();

  String url_signature_6();

  String url_authentication_v2();

  String url_authentication_v5();

  String url_PagareDeceval();

  String url_ConsultaPagareDecevalSinPdf();

  String url_ConsultaPagareDecevalConPdf();

  String url_crearGiratorDeceval();

  String url_CrearPagareDeceval();

  String url_firmarPagareDeceval();

  String datapower();

  String core();

  String BankidVillas();

  String BankidPopular();

  String BankidOccidente();

  String OtpTypeVillas();

  String OtpTypePopular();

  String OtpTypeOccidente();

  String url_cancelarPagareDeceval();

  String url_authentication_v7();

  int datoseguro_rojo();

  int datoseguro_rojo_verde();

  int datoseguro_rojo_azul();

  int datoseguro_rojo_verde_azul();

  int datoseguro_verde();

  int datoseguro_verde_azul();

  int datoseguro_azul();

  int datoseguro_cifin();

  String urlCambiarEstadoPagare();

  String urlAnularPagare();

}


