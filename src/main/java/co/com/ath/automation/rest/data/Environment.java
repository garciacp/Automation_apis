package co.com.ath.automation.rest.data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:staging.properties"})

public interface Environment extends Config {

  String urlSignatureV2();

  String urlSignatureV6();

  String urlAuthenticationV2();

  String urlAuthenticationV5();

  String urlAuthenticationV7();

  String url_cancelarPagareDeceval();

  String urlCambiarEstadoPagare();

  String url_ConsultaPagareDecevalSinPdf();

  String url_ConsultaPagareDecevalConPdf();

  String url_crearGiratorDeceval();

  String url_CrearPagareDeceval();

  String url_firmarPagareDeceval();

  String urlAnularPagare();

  String datapower();

  String core();

  String BankidVillas();

  String bankIdVillas();


  String bankIdPopular();

  String bankIdOccidente();

  String otpTypeVillas();

  String otpTypePopular();

  String otpTypeOccidente();

  int datoSeguroRojo();

  int datoSeguroRojoVerde();

  int datoSeguroRojoAzul();

  int datoSeguroRojoVerdeAzul();

  int datoSeguroVerde();

  int datoSeguroVerdeAzul();

  int datoSeguroAzul();

  int datoSeguroCifin();

  int datoSeguroDatacredito();

}


