package br.com.caelum.vraptor.view.j2html.rederers;

import br.com.caelum.vraptor.view.j2html.exception.ViewJ2HtmlException;
import j2html.tags.DomContent;

/**
 * Interface de renderizacao das views internas de cada pagina
 * 
 * @author giovanny.brandalise
 *
 */
public interface ViewRenderer {

	/**
	 * Metodo de retorno do array de elementos html filhos de DomContent a serem
	 * renderizados dentro dos containers
	 * 
	 * @return array de elementos filhos de DomContent
	 * @throws ViewJ2HtmlException
	 */
	DomContent[] getElements() throws ViewJ2HtmlException;

}
