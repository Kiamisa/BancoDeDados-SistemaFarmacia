-- -----------------------------------------------------
-- Table `farmacia_att`.`fornecedores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`fornecedores` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`fornecedores` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(100) NOT NULL,
    `telefone` VARCHAR(16) NOT NULL,
    `email` VARCHAR(120) NOT NULL,
    `endereco` VARCHAR(80) NOT NULL,
    `complemento` VARCHAR(45) NULL,
    `bairro` VARCHAR(25) NULL,
    `numero` INT NOT NULL,
    `cnpj` BIGINT(14) ZEROFILL NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;