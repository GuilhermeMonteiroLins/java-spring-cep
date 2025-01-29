package br.com.spring.cep.model.dto;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClientDTO {

	@SerializedName("logradouro")
	private String street;

	@SerializedName("cep")
	private String cep;

	@SerializedName("bairro")
	private String neighborhood;

	@SerializedName("localidade")
	private String city;

	@SerializedName("estado")
	private String state;

	@SerializedName("regiao")
	private String region;

	@SerializedName("uf")
	private String uf;
}
