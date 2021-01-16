CREATE DATABASE `mathappdemo`;

CREATE TABLE `mathappdemo`.`math_table` (
  `id_math` INT NOT NULL AUTO_INCREMENT,
  `rank` DOUBLE NOT NULL,
  `rank_total` DOUBLE NOT NULL,
  PRIMARY KEY (`id_math`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

use mathappdemo;
insert into math_table (rank, rank_total) values (2.0, 22.0);
INSERT INTO math_table (`rank`, `rank_total`) VALUES ('6', '9');

select * from math_table;