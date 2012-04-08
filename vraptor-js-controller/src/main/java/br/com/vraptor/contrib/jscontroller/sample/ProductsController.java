package br.com.vraptor.contrib.jscontroller.sample;
import static br.com.caelum.vraptor.view.Results.*;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("/products")
public class ProductsController {
  
  private Result result;
  private Products products;
  
  public ProductsController(Result result, Products products) {
    this.result = result;
    this.products = products;
  }
  
  @Get
  @Path("/")
  public void index(){
  }
  
  @Get
  @Path("/list")
  public void list() {
    result.use(json()).withoutRoot().from(products.all()).recursive().serialize();
  }
  
  @Get
  @Path("/{id}")
  public void show(int id) {
    result.use(json()).withoutRoot().from(products.select(id)).recursive().serialize();
  }
  
  @Post
  @Path("/new")
  public void newProduct(Product product){
    products.add(product);
    result.use(status()).ok();
  }
  
  @Put
  @Path("/{id}")
  public void update(int id, Product product){
    products.update(id, product);
    result.use(status()).ok();
  }
  
  @Delete
  @Path("/{id}")
  public void remove(int id) {
    products.remove(id);
    result.use(status()).ok();
  }
}
