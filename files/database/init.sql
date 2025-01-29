DROP DATABASE IF EXISTS searchcep_db;

CREATE DATABASE searchcep_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE searchcep_db;

-- -----------------------------------------------------
-- Table `tb_request_logs` - TABELA DE LOGS DAS REQUISIÇÕES
-- -----------------------------------------------------
CREATE TABLE 
	IF NOT EXISTS `tb_request_logs`(
		`id_request_log` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		`street` VARCHAR(255) NOT NULL,
		`cep` VARCHAR(8) NOT NULL,
		`neighborhood` VARCHAR(255) NOT NULL,
		`city` VARCHAR(50) NOT NULL,
		`state` VARCHAR(50) NOT NULL,
		`region` VARCHAR(50) NOT NULL,
		`uf` VARCHAR(2) NOT NULL,
		`time_created` TIME NOT NULL
	);
    
