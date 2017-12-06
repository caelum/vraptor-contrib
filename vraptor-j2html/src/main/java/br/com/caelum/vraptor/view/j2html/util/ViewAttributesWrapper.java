package br.com.caelum.vraptor.view.j2html.util;

import javax.enterprise.inject.Vetoed;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe util usada para recuperar os atributos escritos no request e na
 * session na classe de renderizacao da view
 * 
 * @author giovanny.brandalise
 *
 */
@Vetoed
public class ViewAttributesWrapper {

	private HttpServletRequest request;

	public ViewAttributesWrapper(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * Metodo responsavel por retornar os atributos escritos no request
	 * 
	 * @param attributeName
	 *            chave do atributo escrito na request
	 * @param clazz
	 *            classe de retorno responsavel por fazer o cast automatico
	 * @return objeto do tipo da classe passada como parametro
	 */
	public <T> T getRequestAttribute(String attributeName, Class<T> clazz) {
		return getAttribute(attributeName, clazz, false);
	}

	/**
	 * Metodo responsavel por retornar os atributos escritos na session
	 * 
	 * @param attributeName
	 *            chave do atributo escrito na request
	 * @param clazz
	 *            classe de retorno responsavel por fazer o cast automatico
	 * @return objeto do tipo da classe passada como parametro
	 */
	public <T> T getSessionAttribute(String attributeName, Class<T> clazz) {
		return getAttribute(attributeName, clazz, true);
	}

	@SuppressWarnings("unchecked")
	private <T> T getAttribute(String attributeName, Class<T> clazz, boolean session) {
		Object o = null;
		if (session) {
			o = request.getSession().getAttribute(attributeName);
		} else {
			o = request.getAttribute(attributeName);
		}
		if (o != null && clazz.isAssignableFrom(o.getClass())) {
			return (T) o;
		}
		return null;
	}

}
