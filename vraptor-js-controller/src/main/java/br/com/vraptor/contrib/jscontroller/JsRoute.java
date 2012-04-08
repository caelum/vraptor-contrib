package br.com.vraptor.contrib.jscontroller;

import java.util.EnumSet;

import br.com.caelum.vraptor.resource.HttpMethod;
/**
 * This class represents a javascript route to access the vraptor controller.
 * @author marceloemanoel
 */
public class JsRoute {

  private String name;
  private String url;
  private EnumSet<HttpMethod> allowedMethods;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public EnumSet<HttpMethod> getAllowedMethods() {
    return allowedMethods;
  }
  
  public void setAllowedMethods(EnumSet<HttpMethod> allowedMethods) {
    this.allowedMethods = allowedMethods;
  }
  
}
