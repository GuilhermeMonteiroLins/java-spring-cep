package br.com.spring.cep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.spring.cep.client.CepClient;
import br.com.spring.cep.exception.CepNotFoundException;
import br.com.spring.cep.model.dto.ResponseClientDTO;
import br.com.spring.cep.model.entity.LoggerCepEntity;
import br.com.spring.cep.repository.LoggerCepRepository;
import br.com.spring.cep.service.CepService;
import br.com.spring.cep.util.CepUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CepServiceImpl implements CepService {

	@Autowired
	private CepClient cepClient; 
	
	@Autowired
	private LoggerCepRepository searchCepRepository;
	
	@Override
	public ResponseClientDTO searchCep(String cep) {
		String normalizedCep = CepUtil.normalizeCep(cep);
		
		String body = cepClient.searchCep(normalizedCep);
		
		Gson gson = new Gson();
		ResponseClientDTO responseApi = gson.fromJson(body, ResponseClientDTO.class);

		saveRequestLog(responseApi);
		
		return responseApi;
	}

	/**
	 * This method is responsible for saving the request log made by the API
	 * 
	 * @param cepDTO
	 */
	@Transactional(rollbackOn = Exception.class)
	private void saveRequestLog(ResponseClientDTO cepDTO) {
		if(!cepDTO.getCep().isEmpty()) {
			LoggerCepEntity requestLogEntity = searchCepRepository.saveAndFlush(LoggerCepEntity.convertToEntity(cepDTO));
			
			if(requestLogEntity.getIdRequestLog() <= 0) {
				log.error("[ERROR] Unable to save search log CEP: {}", cepDTO.getCep());
				throw new CepNotFoundException("Unable to save search log CEP " + cepDTO.getCep());
			}
		}
	}

}
