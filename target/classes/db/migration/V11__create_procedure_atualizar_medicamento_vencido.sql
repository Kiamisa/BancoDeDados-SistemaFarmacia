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