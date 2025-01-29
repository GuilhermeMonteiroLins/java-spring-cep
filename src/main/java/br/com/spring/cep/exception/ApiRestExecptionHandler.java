package br.com.spring.cep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.spring.cep.model.dto.ApiResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiRestExecptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Generic RuntimeException formated JSON.
	 *
	 * @param exception
	 * @return JSON formated @ErrorResponseDTO
	 */
	@ExceptionHandler(Exception.class)
	private ResponseEntity<ApiResponseDTO> runtimeErrorHandler(Exception exception) {
		log.atError().setCause(exception).log(
				"[INTERNAL SERVER ERROR] There was an internal server error --- [EXCEPTION] : {}",
				exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO(
				HttpStatus.INTERNAL_SERVER_ERROR, "There was an error performing the action, please try again!"));
	}

	/**
	 * Exception cep not found.
	 *
	 * @param exception
	 * @return JSON formated @ApiResponseDTO
	 */
	@ExceptionHandler(CepNotFoundException.class)
	private ResponseEntity<ApiResponseDTO> cepNotFoundHandler(CepNotFoundException exception) {
		log.error("[ERROR] An error occurred while performing the fetch action CEP. --- [EXCEPTION] : {}",
				exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponseDTO(HttpStatus.NOT_FOUND, exception.getMessage()));
	}

	/**
	 * Exception external api not found.
	 *
	 * @param exception
	 * @return JSON formated @ApiResponseDTO
	 */
	@ExceptionHandler(HttpClientNotFoundException.class)
	private ResponseEntity<ApiResponseDTO> externalApiNotFoundHandler(HttpClientNotFoundException exception) {
		log.error("[ERROR] An error occurred while trying to connect to the external API. --- [EXCEPTION] : {}",
				exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponseDTO(HttpStatus.NOT_FOUND, exception.getMessage()));
	}
}
