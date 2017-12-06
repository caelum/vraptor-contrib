package br.com.caelum.vraptor.view.j2html.rederers.impl;

import static j2html.TagCreator.html;
import static j2html.TagCreator.rawHtml;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.caelum.vraptor.view.j2html.exception.ViewJ2HtmlException;
import br.com.caelum.vraptor.view.j2html.rederers.BodyRenderer;
import br.com.caelum.vraptor.view.j2html.rederers.HeadRenderer;
import br.com.caelum.vraptor.view.j2html.rederers.HtmlRenderer;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

/**
 * Classe default de implementacao da renderizacao do elemento html do html.
 * Essa classe pode ser sobrescrita usando a anotacao @Specializes do CDI
 * 
 * @author giovanny.brandalise
 *
 */
@RequestScoped
public class DefaultHtmlRenderer implements HtmlRenderer {

	private BodyRenderer bodyRenderer;
	private HeadRenderer headRenderer;
	private Logger log;

	/**
	 * @deprecated CDI eyes onlye
	 */
	@Deprecated
	protected DefaultHtmlRenderer() {
		this(null, null, null);
	}

	@Inject
	public DefaultHtmlRenderer(HeadRenderer headRenderer, BodyRenderer bodyRenderer, Logger log) {
		this.headRenderer = headRenderer;
		this.bodyRenderer = bodyRenderer;
		this.log = log;
	}

	@Override
	public ContainerTag getContainer(DomContent... content) throws ViewJ2HtmlException {
		log.debug("DefaultHtmlRenderer accessed");
		return html(headRenderer.getContainer(), bodyRenderer.getContainer(content));
	}

	@Override
	public ContainerTag getContainer(String content) throws ViewJ2HtmlException {
		log.debug("DefaultHtmlRenderer accessed");
		return html(headRenderer.getContainer(), bodyRenderer.getContainer(rawHtml(content)));
	}

}
