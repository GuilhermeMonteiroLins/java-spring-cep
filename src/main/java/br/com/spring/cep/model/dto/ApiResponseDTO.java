package br.com.spring.cep.model.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiResponseDTO {

	private HttpStatus httpStatus;
	private String message;
}
