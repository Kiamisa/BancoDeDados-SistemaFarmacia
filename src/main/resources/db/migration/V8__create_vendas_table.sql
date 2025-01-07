-- -----------------------------------------------------
-- Table `farmacia_att`.`vendas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`vendas` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`vendas` (
                                                       `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                       `data_venda` DATE NOT NULL,
                                                       `valor_total` DECIMAL(10,2) NOT NULL,
                                                       `Clientes_id` BIGINT NOT NULL,
                                                       `Funcionarios_id` BIGINT NOT NULL,
                                                       `medicamentos_id` BIGINT NOT NULL,
                                                       `codigo_barras` VARCHAR(45) NOT NULL,
                                                       PRIMARY KEY (`id`),
                                                       INDEX `fk_vendas_Clientes1_idx` (`Clientes_id` ASC) VISIBLE,
                                                       INDEX `fk_vendas_Funcionarios1_idx` (`Funcionarios_id` ASC) VISIBLE,
                                                       INDEX `fk_vendas_medicamentos1_idx` (`medicamentos_id` ASC) VISIBLE,
                                                       CONSTRAINT `fk_vendas_Clientes1`
                                                           FOREIGN KEY (`Clientes_id`)
                                                               REFERENCES `farmacia_att`.`clientes` (`id`),
                                                       CONSTRAINT `fk_vendas_Funcionarios1`
                                                           FOREIGN KEY (`Funcionarios_id`)
                                                               REFERENCES `farmacia_att`.`funcionarios` (`id`),
                                                       CONSTRAINT `fk_vendas_medicamentos1`
                                                           FOREIGN KEY (`medicamentos_id`)
                                                               REFERENCES `farmacia_att`.`medicamentos` (`id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;