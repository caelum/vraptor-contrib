package br.com.caelum.vraptor.view.j2html.rederers;

import br.com.caelum.vraptor.view.j2html.exception.ViewJ2HtmlException;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

/**
 * Interface de renderizacao de elementos container do html (html, head, body,
 * etc)
 * 
 * @author giovanny.brandalise
 *
 */
public interface ContainerRenderer {

	/**
	 * Metodo que recebe uma lista de elementos filhos de DomContent para serem
	 * renderizados dentro do container
	 * 
	 * @param content
	 * @return elemento filho de ContainerTag
	 * @throws ViewJ2HtmlException
	 */
	ContainerTag getContainer(DomContent... content) throws ViewJ2HtmlException;

	/**
	 * Metodo que recebe uma String com o html a ser renderizado dentro do container
	 * 
	 * @param content
	 * @return elemento filho de ContainerTag
	 * @throws ViewJ2HtmlException
	 */
	ContainerTag getContainer(String content) throws ViewJ2HtmlException;

}
