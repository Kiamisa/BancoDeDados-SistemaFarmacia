-- -----------------------------------------------------
-- Table `farmacia_att`.`medicamentos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`medicamentos` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`medicamentos` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `nome` CHAR(100) NOT NULL,
    `descricao` VARCHAR(255) NOT NULL,
    `fabricacao` DATE NOT NULL,
    `validade` DATE NOT NULL,
    `fabricante` VARCHAR(100) NOT NULL,
    `estoque` INT NOT NULL,
    `preco` DECIMAL(10,2) NOT NULL,
    `tipo_medicamento_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_medicamentos_tipo_medicamento1_idx` (`tipo_medicamento_id` ASC) VISIBLE,
    CONSTRAINT `fk_medicamentos_tipo_medicamento1`
    FOREIGN KEY (`tipo_medicamento_id`)
    REFERENCES `farmacia_att`.`tipo_medicamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;