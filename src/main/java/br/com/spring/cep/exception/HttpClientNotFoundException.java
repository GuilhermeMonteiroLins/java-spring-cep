package br.com.spring.cep.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class HttpClientNotFoundException extends RuntimeException {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * If the constructor is empty, the exception message will be in English.
	 */
	public HttpClientNotFoundException() {
		super("Unable to connect to external api");
	}

	/**
	 * If there is a parameter in the constructor, it will display the message sent.
	 *
	 * @param message
	 */
	public HttpClientNotFoundException(String message) {
		super(message);
	}
}
