package br.com.vraptor.contrib.jscontroller;

import static br.com.caelum.vraptor.view.Results.status;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * This controller generates all the javascript needed to use the other controllers via javascript.
 * It should be injected on the pages.
 * @author marceloemanoel
 */
@Resource
@Path("/js")
public class JsController {
  
  private Result result;
  private ControllerDiscover discover;
  
  public JsController(Result result, ControllerDiscover discover) {
    this.result = result;
    this.discover = discover;
  }
  
  @Get
  @Path("/{controllerName}")
  public void controller(String controllerName){
    Controller controller = discover.find(controllerName);
    if(controller == null){
      result.use(status()).notFound();
      return;
    }
    result.include(controller);
  } 
  
}
