package br.com.vraptor.contrib.jscontroller;

import java.util.List;
/**
 * This class represents a jsController with all the routes needed to contact vraptor controllers.
 * @author marceloemanoel
 */
public class Controller {
  private String name;
  private List<JsRoute> jsRoutes;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<JsRoute> getJsRoutes() {
    return jsRoutes;
  }

  public void setJsRoutes(List<JsRoute> jsRoutes) {
    this.jsRoutes = jsRoutes;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((jsRoutes == null) ? 0 : jsRoutes.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    Controller other = (Controller) obj;
    if (jsRoutes == null) {
      if (other.jsRoutes != null)
        return false;
    }
    else if (!jsRoutes.equals(other.jsRoutes))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    }
    else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Controller [name=" + name + ", jsRoutes=" + jsRoutes + "]";
  }

}
