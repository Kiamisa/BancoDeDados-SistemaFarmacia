SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema farmacia_att
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `farmacia_att` ;

-- -----------------------------------------------------
-- Schema farmacia_att
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `farmacia_att` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `farmacia_att` ;
-- Configuração final
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
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
-- -----------------------------------------------------
-- Table `farmacia_att`.`tipo_medicamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `farmacia_att`.`tipo_medicamento` ;

CREATE TABLE IF NOT EXISTS `farmacia_att`.`tipo_medicamento` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `descricao` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;
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
-- -----------------------------------------------------
-- Procedure `AtualizarMedicamentosVencidos`
-- -----------------------------------------------------
DELIMITER $$
CREATE PROCEDURE `AtualizarMedicamentosVencidos`()
BEGIN
    UPDATE medicamentos
    SET estoque = 0
    WHERE validade <= CURDATE() AND estoque > 0;
END$$
DELIMITER ;
-- -----------------------------------------------------
-- Trigger `AtualizarEstoqueVenda`
-- -----------------------------------------------------
DELIMITER $$
CREATE TRIGGER `AtualizarEstoqueVenda`
    AFTER INSERT ON `item_venda`
    FOR EACH ROW
BEGIN
    UPDATE medicamentos
    SET estoque = estoque - NEW.quantidade
    WHERE id = NEW.medicamentos_id;
END$$
DELIMITER ;