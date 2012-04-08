package br.com.vraptor.contrib.jscontroller.sample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class Products {
  
  private Map<Integer, Product> products;
  
  public Products(){
    products = new HashMap<Integer, Product>();
    products.put(0, new Product("desc1", 0D));
    products.put(1, new Product("desc2", 1D));
    products.put(2, new Product("desc3", 2D));
  }
  
  public Collection<Product> all() {
    return products.values();
  }
  
  public void add(Product produto){
    products.put(products.size(), produto);
  }
  
  public Product select(int index) {
    return products.get(index);
  }

  public void update(int id, Product produto) {
    products.put(id, produto);
  }

  public void remove(int id) {
    products.remove(id);
  }
  
}
