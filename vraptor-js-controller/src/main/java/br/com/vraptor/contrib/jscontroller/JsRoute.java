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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((allowedMethods == null) ? 0 : allowedMethods.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((url == null) ? 0 : url.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JsRoute other = (JsRoute) obj;
    if (allowedMethods == null) {
      if (other.allowedMethods != null)
        return false;
    }
    else if (!allowedMethods.equals(other.allowedMethods))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    }
    else if (!name.equals(other.name))
      return false;
    if (url == null) {
      if (other.url != null)
        return false;
    }
    else if (!url.equals(other.url))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "JsRoute [name=" + name + ", url=" + url + ", allowedMethods=" + allowedMethods + "]";
  }
  
}
