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