CREATE DATABASE `mathappdemo`;

CREATE TABLE `mathappdemo`.`math_table` (
  `id_math` INT NOT NULL AUTO_INCREMENT,
  `rank` DOUBLE NOT NULL,
  `rank_total` DOUBLE NOT NULL,
  PRIMARY KEY (`id_math`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;