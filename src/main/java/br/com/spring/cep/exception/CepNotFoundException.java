package br.com.spring.cep.exception;

public class CepNotFoundException extends RuntimeException {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * If the constructor is empty, the exception message will be in English.
	 */
	public CepNotFoundException() {
		super("Unable to find the cep you searched for");
	}

	/**
	 * If there is a parameter in the constructor, it will display the message sent.
	 *
	 * @param message
	 */
	public CepNotFoundException(String message) {
		super(message);
	}
}
