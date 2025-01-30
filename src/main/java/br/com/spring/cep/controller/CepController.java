package br.com.spring.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.cep.model.dto.ResponseClientDTO;
import br.com.spring.cep.service.CepService;

@RestController
@RequestMapping("/cep")
public class CepController {

	@Autowired
	private CepService cepService;

	/**
	 * This method is responsible for carrying out the CEP search
	 *
	 * @return HTTP response CEP information
	 */
	@GetMapping(value = "/{cep}", produces = "application/json")
	public ResponseEntity<ResponseClientDTO> searchCep(@PathVariable(value = "cep") String cep) {
		return ResponseEntity.status(HttpStatus.OK).body(cepService.searchCep(cep));
	}
}
