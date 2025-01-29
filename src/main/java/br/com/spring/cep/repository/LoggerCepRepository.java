package br.com.spring.cep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.cep.model.entity.LoggerCepEntity;

@Repository
public interface LoggerCepRepository extends JpaRepository<LoggerCepEntity, Long> {

}
