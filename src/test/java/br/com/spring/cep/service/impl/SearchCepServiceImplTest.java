package br.com.spring.cep.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import br.com.spring.cep.exception.CepNotFoundException;
import br.com.spring.cep.model.dto.ResponseClientDTO;
import br.com.spring.cep.model.entity.LoggerCepEntity;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.spring.cep.client.CepClient;
import br.com.spring.cep.repository.LoggerCepRepository;

@ExtendWith(MockitoExtension.class)
public class SearchCepServiceImplTest {

	@InjectMocks
	private CepServiceImpl suite;

	@Mock
	private CepClient cepClient;

	@Mock
	private LoggerCepRepository loggerCepRepository;

	@Test
	public void shouldSearchCepSucess() {
		String cep = "12345678";
		var jsonResponse = toJson();

		LoggerCepEntity entitySaved = LoggerCepEntity.builder().idRequestLog(1L).build();

		when(cepClient.searchCep(cep)).thenReturn(jsonResponse);
		when(loggerCepRepository.saveAndFlush(any())).thenReturn(entitySaved);

		ResponseClientDTO cepResponse = suite.searchCep(cep);

		Assertions.assertEquals(cepResponse.getCep(), cep);

		verify(cepClient, times(1)).searchCep(any());
		verify(loggerCepRepository, times(1)).saveAndFlush(any());
	}

	@Test
	public void shouldBeThrowCepNotFoundException() {
		String cep = "12345678";

		var jsonResponse = toJson();

		LoggerCepEntity entitySaved = LoggerCepEntity.builder().idRequestLog(0L).build();

		when(cepClient.searchCep(cep)).thenReturn(jsonResponse);
		when(loggerCepRepository.saveAndFlush(any())).thenReturn(entitySaved);

		Assertions.assertThrows(CepNotFoundException.class, () -> suite.searchCep(cep));

		verify(cepClient, times(1)).searchCep(any());
		verify(loggerCepRepository, times(1)).saveAndFlush(any());
	}

	private String toJson() {
		Gson gson = new Gson();
		var response = ResponseClientDTO.builder().uf("uf").cep("12345678").city("city").neighborhood("neigh")
				.state("state").street("street").build();
		return gson.toJson(response);
	}
}