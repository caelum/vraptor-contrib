package br.com.caelum.vraptor.view.j2html.rederers.impl;

import static j2html.TagCreator.body;
import static j2html.TagCreator.rawHtml;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.caelum.vraptor.view.j2html.exception.ViewJ2HtmlException;
import br.com.caelum.vraptor.view.j2html.rederers.BodyRenderer;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

/**
 * Classe default de implementacao da renderizacao do elemento body do html.
 * Essa classe pode ser sobrescrita usando a anotacao @Specializes do CDI
 * 
 * @author giovanny.brandalise
 *
 */
@RequestScoped
public class DefaultBodyRenderer implements BodyRenderer {

	private Logger log;

	/**
	 * @deprecated CDI eyes onlye
	 */
	@Deprecated
	protected DefaultBodyRenderer() {
		this(null);
	}

	@Inject
	public DefaultBodyRenderer(Logger log) {
		this.log = log;
	}

	@Override
	public ContainerTag getContainer(DomContent... content) throws ViewJ2HtmlException {
		log.debug("DefaultBodyRenderer accessed");
		return body(content);
	}

	@Override
	public ContainerTag getContainer(String content) throws ViewJ2HtmlException {
		log.debug("DefaultBodyRenderer accessed");
		return body(rawHtml(content));
	}
}
