-- -----------------------------------------------------
-- Table `farmacia_att`.`funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`funcionarios` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`funcionarios` (
                                                             `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                             `nome` VARCHAR(100) NOT NULL,
                                                             `cargo` VARCHAR(45) NOT NULL,
                                                             `salario` DECIMAL(10,2) NOT NULL,
                                                             `data_adimissao` DATE NOT NULL,
                                                             `qtd_vendas` BIGINT NOT NULL,
                                                             `cpf` BIGINT(11) UNSIGNED ZEROFILL NOT NULL,
                                                             `endereco` VARCHAR(45) NOT NULL,
                                                             `bairro` VARCHAR(25) NOT NULL,
                                                             `complemento` VARCHAR(45) NULL,
                                                             `numero` INT NOT NULL,
                                                             PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;