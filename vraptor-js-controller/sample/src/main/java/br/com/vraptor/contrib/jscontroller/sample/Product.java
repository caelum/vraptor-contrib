package br.com.vraptor.contrib.jscontroller.sample;

public class Product {
  String description;
  Double price;
  
  public Product() {
  }
  
  public Product(String description, Double price) {
    this();
    this.description = description;
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
