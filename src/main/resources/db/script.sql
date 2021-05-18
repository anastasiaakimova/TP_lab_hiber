CREATE TABLE `gr`.`specialty`
(
    `id_specialty` INT         NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(45) NULL,
    PRIMARY KEY (`id_specialty`)
);

ALTER TABLE `gr`.`gruppyi`
    ADD COLUMN `specialty` INT NULL AFTER `StatusDate`,

;
ALTER TABLE `gr`.`gruppyi`
    ADD CONSTRAINT `fk_specialty`
        FOREIGN KEY (`specialty`)
            REFERENCES `gr`.`specialty` (`id_specialty`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
