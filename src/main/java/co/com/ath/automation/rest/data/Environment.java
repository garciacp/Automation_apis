package co.com.ath.automation.rest.data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})

public interface Environment extends Config {

  String urlSignatureV2();

  String urlSignatureV6();

  String urlAuthenticationV2();

  String urlAuthenticationV5();

  String urlAuthenticationV7();

  String datapower();

  String core();

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


