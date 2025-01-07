-- -----------------------------------------------------
-- Table `farmacia_att`.`tipo_medicamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`tipo_medicamento` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`tipo_medicamento` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `descricao` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;