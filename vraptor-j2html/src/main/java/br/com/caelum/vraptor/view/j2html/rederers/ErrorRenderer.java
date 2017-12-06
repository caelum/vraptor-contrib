package br.com.caelum.vraptor.view.j2html.rederers;

import br.com.caelum.vraptor.view.j2html.exception.ViewJ2HtmlException;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

/**
 * Interface de renderizacao da pagina de erro
 * 
 * @author giovanny.brandalise
 *
 */
public interface ErrorRenderer {

	/**
	 * Metodo que recebe uma lista de elementos filhos de DomContent para serem
	 * renderizados dentro do container
	 * 
	 * @param ex
	 *            excecao disparada
	 * @param content
	 *            lista de elementos
	 * @return elemento filho de ContainerTag
	 */
	ContainerTag getContainer(ViewJ2HtmlException ex, DomContent... content);

	/**
	 * Metodo que recebe uma String com o html a ser renderizado dentro do container
	 * 
	 * @param ex
	 *            excecao disparada
	 * @param content
	 *            lista de elementos
	 * @return elemento filho de ContainerTag
	 */
	ContainerTag getContainer(ViewJ2HtmlException ex, String content);

}
