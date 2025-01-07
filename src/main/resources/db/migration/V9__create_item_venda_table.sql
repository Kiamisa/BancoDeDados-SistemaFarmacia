-- -----------------------------------------------------
-- Table `farmacia_att`.`item_venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`item_venda` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`item_venda` (
                                                           `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                           `quantidade` INT NOT NULL,
                                                           `preco_uni` DECIMAL(10,2) NOT NULL,
                                                           `vendas_id` BIGINT NOT NULL,
                                                           `medicamentos_id` BIGINT NOT NULL,
                                                           PRIMARY KEY (`id`),
                                                           INDEX `fk_item_venda_vendas1_idx` (`vendas_id` ASC) VISIBLE,
                                                           INDEX `fk_item_venda_medicamentos1_idx` (`medicamentos_id` ASC) VISIBLE,
                                                           CONSTRAINT `fk_item_venda_medicamentos1`
                                                               FOREIGN KEY (`medicamentos_id`)
                                                                   REFERENCES `farmacia_att`.`medicamentos` (`id`),
                                                           CONSTRAINT `fk_item_venda_vendas1`
                                                               FOREIGN KEY (`vendas_id`)
                                                                   REFERENCES `farmacia_att`.`vendas` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;