-- -----------------------------------------------------
-- Table `farmacia_att`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`clientes` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`clientes` (
     `id` BIGINT NOT NULL,
     `nome` VARCHAR(60) NOT NULL,
     `endereco` VARCHAR(80) NOT NULL,
     `complemento` VARCHAR(45) NULL DEFAULT NULL,
     `bairro` VARCHAR(10) NOT NULL,
     `numero` INT NOT NULL DEFAULT '0',
     `cidades_id` INT NOT NULL,
     `telefone1` VARCHAR(16) NOT NULL,
     `email` VARCHAR(120) NOT NULL,
     `telefone2` VARCHAR(16) NULL DEFAULT NULL,
     `cpf` BIGINT(11) UNSIGNED ZEROFILL NOT NULL,
     `dt_nascimento` DATE NOT NULL,
     `nome_pai` VARCHAR(60) NULL DEFAULT NULL,
     `nome_mae` VARCHAR(60) NOT NULL,
     PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;