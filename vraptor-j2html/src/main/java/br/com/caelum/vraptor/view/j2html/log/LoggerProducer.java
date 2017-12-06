package br.com.caelum.vraptor.view.j2html.log;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe produtora de loggers usada no cdi
 *
 */
public class LoggerProducer {

	/**
	 * @param injectionPoint
	 *            Ponto de injecao de dependencia
	 * @return Instancia do Logger para a classe em que esta injetado
	 */
	@Produces
	public Logger produceLogger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

}
