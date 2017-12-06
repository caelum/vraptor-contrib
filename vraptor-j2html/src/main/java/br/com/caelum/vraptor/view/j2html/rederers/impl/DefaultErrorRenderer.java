package br.com.caelum.vraptor.view.j2html.rederers.impl;

import static j2html.TagCreator.*;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.google.common.collect.Lists;

import br.com.caelum.vraptor.view.j2html.exception.ViewJ2HtmlException;
import br.com.caelum.vraptor.view.j2html.rederers.ErrorRenderer;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

/**
 * Classe default de implementacao da renderizacao da pagina de erro. Essa
 * classe pode ser sobrescrita usando a anotacao @Specializes do CDI
 * 
 * @author giovanny.brandalise
 *
 */
@RequestScoped
public class DefaultErrorRenderer implements ErrorRenderer {

	private Logger log;

	/**
	 * @deprecated CDI eyes only
	 */
	@Deprecated
	protected DefaultErrorRenderer() {
		this(null);
	}

	@Inject
	protected DefaultErrorRenderer(Logger log) {
		this.log = log;
	}

	@Override
	public ContainerTag getContainer(ViewJ2HtmlException ex, DomContent... content) {
		log.debug("DefaultErrorRenderer accessed");
		List<DomContent> contents = Lists.newArrayList(content);
		contents.add(rawHtml(viewExceptionToString(ex)));
		return html(head(), body(contents.toArray(new DomContent[0])));
	}

	@Override
	public ContainerTag getContainer(ViewJ2HtmlException ex, String content) {
		log.debug("DefaultErrorRenderer accessed");
		return html(head(), body(rawHtml(content + viewExceptionToString(ex))));
	}

	private String viewExceptionToString(ViewJ2HtmlException ex) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement ste : ex.getCause().getStackTrace()) {
			sb.append(ste.toString() + "\n");
		}
		return "<!-- Exception: \n" + sb.toString() + "\n-->";
	}

}
