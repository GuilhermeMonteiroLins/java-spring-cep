package br.com.spring.cep.client;

public interface CepClient {

	/**
	 * This method is responsible for retrieving information from the client.
	 * 
	 * @param cep
	 * @return body response
	 */
	String searchCep(String cep);
}
