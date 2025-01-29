package br.com.spring.cep.client.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.spring.cep.client.CepClient;
import br.com.spring.cep.exception.CepNotFoundException;
import br.com.spring.cep.exception.HttpClientNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CepClientImpl implements CepClient{

	@Value("${api.client.cep.endpoint}")
	private String endpoint;
	
	@Autowired
	private HttpClient httpClient;

	
	@Override
	public String searchCep(String cep) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endpoint.concat(cep).concat("/json")))
				.GET()
				.build();
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			
			if (response.statusCode() != HttpStatus.OK.value()) {
				log.error("[ERROR] Unable to find CEP: {}", cep);
				throw new CepNotFoundException("Unable to find CEP: " + cep);
			}
			
			return response.body();
		} catch (IOException | InterruptedException e) {
			log.error("[ERROR] Unable to connect to external api ---[EXCEPTION]: {}", e.getMessage());
			throw new HttpClientNotFoundException("Unable to connect to external api " + e.getMessage());
		}
	}
}
