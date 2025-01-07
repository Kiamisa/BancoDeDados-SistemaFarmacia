-- -----------------------------------------------------
-- Table `farmacia_att`.`fornecimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`fornecimento` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`fornecimento` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `data_fornecimento` DATE NOT NULL,
    `quantidade` INT NOT NULL,
    `valor_total` DECIMAL(10,2) NOT NULL,
    `fabricacao` DATE NOT NULL,
    `vencimento` DATE NOT NULL,
    `fornecedores_id` INT NOT NULL,
    `medicamentos_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_fornecimento_fornecedores1_idx` (`fornecedores_id` ASC) VISIBLE,
    INDEX `fk_fornecimento_medicamentos1_idx` (`medicamentos_id` ASC) VISIBLE,
    CONSTRAINT `fk_fornecimento_fornecedores1`
    FOREIGN KEY (`fornecedores_id`)
    REFERENCES `farmacia_att`.`fornecedores` (`id`),
    CONSTRAINT `fk_fornecimento_medicamentos1`
    FOREIGN KEY (`medicamentos_id`)
    REFERENCES `farmacia_att`.`medicamentos` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;