package br.com.vraptor.contrib.jscontroller;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class VelocityJsGenerator implements JsGenerator{
  
  private static final String TEMPLATE_PATH = "/br/com/vraptor/contrib/jscontroller/template/controller.vtl";
  private VelocityEngine engine;
  
  public VelocityJsGenerator() {
    engine = new VelocityEngine();
    engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
    engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
    engine.init();
  }
  
  @Override
  public String generate(Controller controller) {
    VelocityContext context = new VelocityContext();
    context.put("controller", controller);
    try {
      Template jsTemplate = engine.getTemplate(TEMPLATE_PATH);
      StringWriter writer = new StringWriter();
      jsTemplate.merge(context, writer);
      writer.close();
      return writer.toString();
    }
    catch (IOException e) {
      throw new GenerateException(e);
    }
  }
  
}
