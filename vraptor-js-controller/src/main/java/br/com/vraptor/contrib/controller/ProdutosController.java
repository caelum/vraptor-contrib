package br.com.vraptor.contrib.controller;
import java.util.ArrayList;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("/produtos")
public class ProdutosController {
  
  private Result result;
  
  public ProdutosController(Result result) {
    this.result = result;
  }
  
  @Get
  @Path("/")
  public void listar() {
    ArrayList<Produto> produtos = new ArrayList<Produto>();
    produtos.add(new Produto("descricao1", 0D));
    produtos.add(new Produto("descricao2", 1D));
    produtos.add(new Produto("descricao3", 2D));
    result.include("produtos", produtos);
  }
  
}
