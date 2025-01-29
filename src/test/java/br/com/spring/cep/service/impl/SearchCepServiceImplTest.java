package br.com.spring.cep.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
		
		when(cepClient.searchCep(any())).thenReturn(any());
		when(loggerCepRepository.saveAndFlush(any())).thenReturn(any());
		
		suite.searchCep(cep);
		
		
	}
}
