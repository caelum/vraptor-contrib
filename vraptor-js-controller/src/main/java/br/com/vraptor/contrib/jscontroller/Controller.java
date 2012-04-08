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

}
