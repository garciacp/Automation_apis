package co.com.ath.automation.rest.apis;

import co.com.ath.automation.rest.data.Environment;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class ServicePaths {

  private static Environment environment;

  static {
    environment = ConfigFactory.create(Environment.class);
  }

  public static URL pathSignDocument() throws MalformedURLException {
    return new URL(environment.datapower() + environment.urlSignatureV6());
  }

  public static URL pathAuthentication() throws MalformedURLException {
    return new URL(environment.datapower() + environment.urlAuthenticationV7());
  }

  public static URL pathDeceval_consultaSinPdf() throws MalformedURLException {
    return new URL(environment.url_ConsultaPagareDecevalSinPdf());
  }

  public static URL pathDeceval_consultaConPdf() throws MalformedURLException {
    return new URL(environment.url_ConsultaPagareDecevalConPdf());
  }

  public static URL pathDeceval_crearotorgante() throws MalformedURLException {
    return new URL(environment.url_crearGiratorDeceval());
  }

  public static URL pathDeceval_crearpagare() throws MalformedURLException {
    return new URL(environment.url_CrearPagareDeceval());
  }

  public static URL pathDeceval_firmarpagare() throws MalformedURLException {
    return new URL(environment.url_firmarPagareDeceval());
  }

  public static URL pathDeceval_cancelarPagare() throws MalformedURLException {
    return new URL(environment.url_cancelarPagareDeceval());
  }

  public static URL pathDecevalCambiarEstadoPagare() throws MalformedURLException {
    return new URL(environment.urlCambiarEstadoPagare());
  }

  public static URL pathDecevalAnularPagare() throws MalformedURLException {
    return new URL(environment.urlAnularPagare());
  }


}
