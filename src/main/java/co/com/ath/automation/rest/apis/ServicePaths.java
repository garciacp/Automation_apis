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

}
