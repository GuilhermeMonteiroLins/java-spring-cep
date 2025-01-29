package br.com.spring.cep.service;

import org.springframework.stereotype.Service;

import br.com.spring.cep.model.dto.ResponseClientDTO;

@Service
public interface CepService {

	/**
	 * This method is responsible for connecting to the external service, and
	 * retrieving information about CEP.
	 *
	 * @param cep
	 * @return Parameters API
	 */
	ResponseClientDTO searchCep(String cep);
}
