package br.com.vraptor.contrib.jscontroller;

import static org.junit.Assert.*;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.http.route.RoutesParser;
import br.com.caelum.vraptor.resource.HttpMethod;

public class ControllerDiscoverTest {
  
  @Mock private ServletContext context;
  @Mock private RoutesParser routesParser;
  private ControllerDiscover discover;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    
    discover = new ControllerDiscover(routesParser, context);
  }
  
  @Test public void 
  givenJsControllerTheDiscoverShouldFind2Methods() {
    Controller jsController = new Controller();
    jsController.setName("JsController");
    
    JsRoute controllerRoute = new JsRoute();
    controllerRoute.setName("controller");
    controllerRoute.setUrl("/js/{controllerName}");
    controllerRoute.setAllowedMethods(Sets.newEnumSet(Sets.newHashSet(HttpMethod.GET), HttpMethod.class));

    JsRoute minControllerRoute = new JsRoute();
    minControllerRoute.setName("minifiedController");
    minControllerRoute.setUrl("/js/min/{controllerName}");
    minControllerRoute.setAllowedMethods(Sets.newEnumSet(Sets.newHashSet(HttpMethod.GET), HttpMethod.class));

    jsController.setJsRoutes(Lists.newArrayList(controllerRoute, minControllerRoute));
    
    discover.handle(JsController.class);
    assertEquals(jsController, discover.find(jsController.getName()));
  }
  
  @Test public void 
  testFind() {
    fail("Not yet implemented");
  }
  
  @Test public void 
  stereotypeShouldAlwaysReturnResourceClass() {
    assertEquals(Resource.class, discover.stereotype());
  }
  
}
