package br.com.caelum.vraptor.view.j2html.exception;

/**
 * Classe responsavel pelas excecoes nas views usando J2Html
 * 
 * @author giovanny.brandalise
 *
 */
public class ViewJ2HtmlException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewJ2HtmlException(Throwable cause) {
		super(cause);
	}

	public ViewJ2HtmlException(String message) {
		super(message);
	}

}
