-- -----------------------------------------------------
-- Table `farmacia_att`.`prescricoes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`prescricoes` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`prescricoes` (
                                                            `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                            `Clientes_id` BIGINT NOT NULL,
                                                            `data_presc` DATE NOT NULL,
                                                            `descricao` TEXT NOT NULL,
                                                            `medicamentos_id` BIGINT NOT NULL,
                                                            PRIMARY KEY (`id`),
                                                            INDEX `fk_prescricoes_Clientes_idx` (`Clientes_id` ASC) VISIBLE,
                                                            INDEX `fk_prescricoes_medicamentos1_idx` (`medicamentos_id` ASC) VISIBLE,
                                                            CONSTRAINT `fk_prescricoes_Clientes`
                                                                FOREIGN KEY (`Clientes_id`)
                                                                    REFERENCES `farmacia_att`.`clientes` (`id`),
                                                            CONSTRAINT `fk_prescricoes_medicamentos1`
                                                                FOREIGN KEY (`medicamentos_id`)
                                                                    REFERENCES `farmacia_att`.`medicamentos` (`id`)
                                                                    ON DELETE NO ACTION
                                                                    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;