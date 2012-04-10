package br.com.vraptor.contrib.jscontroller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import javassist.Modifier;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.http.route.Route;
import br.com.caelum.vraptor.http.route.RoutesParser;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.StereotypeHandler;
import br.com.caelum.vraptor.resource.DefaultResourceClass;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Intercept all controllers registered by Vraptor.
 * 
 * Built inspired by Lucas Cavalcanti's blog post http://lucas.cavalcanti.me/2011/07/06/anatomia-de-uma-solucao-vraptor-linkto-para-jsp-final/
 * @author marceloemanoel
 */
@Component
@ApplicationScoped
public class ControllerDiscover implements StereotypeHandler {
  
  private Map<String, Controller> controllers;
  private RoutesParser routesParser;
  private ServletContext context;
  
  public ControllerDiscover(RoutesParser routesParser, ServletContext context) {
    controllers = Maps.newHashMap();
    this.routesParser = routesParser;
    this.context = context;
  }
  
  public void handle(Class<?> controllerClass) {
    Controller controller = new Controller();
    controller.setName(controllerClass.getSimpleName());
    
    List<JsRoute> jsRoutes = Lists.newArrayList();
    List<Route> routes = routesParser.rulesFor(new DefaultResourceClass(controllerClass));

    for (Method method : controllerClass.getMethods()) {
      if(isEligible(method)){
        
        JsRoute jsRoute = new JsRoute();
        jsRoute.setName(method.getName());
    
        for (Route route : routes) {
          if(route.canHandle(controllerClass, method)){
            jsRoute.setUrl(context.getContextPath() + route.getOriginalUri());
            jsRoute.setAllowedMethods(route.allowedMethods());
            continue;
          }
        }
        jsRoutes.add(jsRoute);
      }
    }
    controller.setJsRoutes(jsRoutes);
    controllers.put(controllerClass.getSimpleName(), controller);
  }
  
  public Controller find(String name) {
    return controllers.get(name);
  }
  
  public Class<? extends Annotation> stereotype() {
    return Resource.class;
  }
  
  protected boolean isEligible(Method javaMethod) {
    return Modifier.isPublic(javaMethod.getModifiers())
      && !Modifier.isStatic(javaMethod.getModifiers())
      && !javaMethod.isBridge()
      && !javaMethod.getDeclaringClass().equals(Object.class);
  }
  
}
