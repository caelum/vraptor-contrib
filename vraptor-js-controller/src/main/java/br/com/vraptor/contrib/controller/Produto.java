package br.com.vraptor.contrib.controller;

public class Produto {
  String descricao;
  Double preco;
  
  public Produto(String descricao, Double preco) {
    this.descricao = descricao;
    this.preco = preco;
  }

  @Override
  public String toString() {
    return "Produto [descricao=" + descricao + ", preco=" + preco + "]";
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }
}
