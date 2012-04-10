package br.com.vraptor.contrib.jscontroller;

import static br.com.caelum.vraptor.view.Results.status;

import java.io.InputStream;

import org.apache.tools.ant.filters.StringInputStream;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.interceptor.download.InputStreamDownload;

/**
 * This controller generates all the javascript needed to use the other controllers via javascript.
 * It should be injected on the pages.
 * @author marceloemanoel
 */
@Resource
@Path("/js")
public class JsController {
  
  private static final String JS_EXTENSION = ".js";
  private static final String MINIFIED_JS_EXTENSION = "-min" + JS_EXTENSION;
  private static final String CONTENT_TYPE = "text/javascript; charset=UTF-8";
  
  private Result result;
  private ControllerDiscover discover;
  private JsGenerator generator;
  
  public JsController(Result result, ControllerDiscover discover, JsGenerator generator) {
    this.result = result;
    this.discover = discover;
    this.generator = generator;
  }
  
  @Get
  @Path("/{controllerName}")
  public Download controller(String controllerName){
    Controller controller = discover.find(controllerName);
    if(controller == null){
      result.use(status()).notFound();
      return null;
    }
    InputStream inputStream = new StringInputStream(generator.generate(controller));
    String fileName = controller.getName()+JS_EXTENSION;
    return new InputStreamDownload(inputStream, CONTENT_TYPE, fileName);
  } 
  
  @Get
  @Path("min/{controllerName}")
  public Download minifiedController(String controllerName){
    Controller controller = discover.find(controllerName);
    if(controller == null){
      result.use(status()).notFound();
      return null;
    }
    InputStream inputStream = new StringInputStream(new MinifiedJsGenerator(generator).generate(controller));
    String fileName = controller.getName()+MINIFIED_JS_EXTENSION;
    return new InputStreamDownload(inputStream, CONTENT_TYPE, fileName);
  }
}
