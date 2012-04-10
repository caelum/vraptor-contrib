package br.com.vraptor.contrib.jscontroller;

@SuppressWarnings("serial")
public class GenerateException extends RuntimeException {

  public GenerateException(Exception e) {
    super(e);
  }
  
}
