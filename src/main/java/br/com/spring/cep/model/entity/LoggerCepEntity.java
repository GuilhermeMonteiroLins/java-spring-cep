package br.com.spring.cep.model.entity;

import java.time.LocalTime;

import br.com.spring.cep.model.dto.ResponseClientDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "tb_request_logs")
public class LoggerCepEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_request_log", nullable = false)
	private Long idRequestLog;

	@Column(name = "street", length = 255, nullable = false)
	private String street;

	@Column(name = "cep", length = 8, nullable = false)
	private String cep;

	@Column(name = "neighborhood", length = 255, nullable = false)
	private String neighborhood;

	@Column(name = "city", length = 50, nullable = false)
	private String city;

	@Column(name = "state", length = 50, nullable = false)
	private String state;

	@Column(name = "region", length = 50, nullable = false)
	private String region;

	@Column(name = "uf", length = 2, nullable = false)
	private String uf;

	@Column(name = "time_created", nullable = false, updatable = false, columnDefinition = "TIME NOT NULL")
	private LocalTime timeCreated;

	/**
	 * Convert DTO to entity
	 * 
	 * @param responseDTO
	 * @return
	 */
	public static LoggerCepEntity convertToEntity(ResponseClientDTO responseDTO) {

		return LoggerCepEntity.builder()
				.street(responseDTO.getStreet())
				.cep(responseDTO.getCep().replaceAll("-", ""))
				.neighborhood(responseDTO.getNeighborhood())
				.city(responseDTO.getCity())
				.state(responseDTO.getState())
				.region(responseDTO.getRegion())
				.uf(responseDTO.getUf())
				.timeCreated(LocalTime.now())
				.build();
	}
}
