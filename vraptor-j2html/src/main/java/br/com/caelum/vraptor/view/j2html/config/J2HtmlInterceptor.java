package br.com.caelum.vraptor.view.j2html.config;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;

/**
 * Classe responsavel por interceptar todas as chamadas aos metodos e verificar
 * se possui a anotacao @J2HtmlRenderer ou nao Caso o metodo possua a anotacao,
 * usa a view J2HtmlView para renderizacao
 * 
 * @author giovanny.brandalise
 *
 */

@Intercepts
public class J2HtmlInterceptor implements Interceptor {

	private Result result;
	private Logger log;

	/**
	 * @deprecated CDI eyes only
	 */
	@Deprecated
	protected J2HtmlInterceptor() {
		this(null, null);
	}

	@Inject
	public J2HtmlInterceptor(Result result, Logger log) {
		this.result = result;
		this.log = log;
	}

	/**
	 * Metodo responsavel por interceptar as chamadas aos metodos dos controllers
	 * que possuem a anotacao @J2HtmlRenderer e utilizar a classe view J2HtmlView
	 * para escrita do html
	 */
	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method, Object controllerInstance)
			throws InterceptionException {
		log.debug("intercept accessed");
		stack.next(method, controllerInstance);
		try {
			this.result.use(J2HtmlView.class).writeJ2Html(method);
		} catch (IOException e) {
			throw new InterceptionException(e);
		}
		this.result.nothing();
	}

	/**
	 * Metodo responsavel por validar se a anotacao @J2HtmlRenderer esta presente no
	 * metodo ou na classe controller
	 */
	@Override
	public boolean accepts(ControllerMethod method) {
		log.debug("accepts accessed");
		return method.getMethod().isAnnotationPresent(J2HtmlRenderer.class)
				|| method.getController().getType().getClass().isAnnotationPresent(J2HtmlRenderer.class);
	}

}
