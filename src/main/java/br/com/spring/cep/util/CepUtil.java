package br.com.spring.cep.util;

import br.com.spring.cep.exception.CepNotFoundException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class CepUtil {

	/**
	 * Normalize CEP
	 * 
	 * @param CEP
	 * @return Cep validate
	 */
	public String normalizeCep(String cep) {
		String cepAux = cep.replace("-", "");
		if (cepAux.matches("\\d+") && cepAux.length() == 8) {
			return cepAux;
		}
		log.error("[ERROR] Unable to validate CEP: {} ", cep);
		throw new CepNotFoundException("The CEP must be entered as in the example: 05524320 or 05524-320");
	}
}
