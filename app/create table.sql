/* для приложения app */
CREATE DATABASE `mathapp`;

CREATE TABLE `mathapp`.`user_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `mathapp`.`math_table` (
  `id_math` INT NOT NULL AUTO_INCREMENT,
  `rank` DOUBLE NULL,
  `rank_total` DOUBLE NULL,
  `date` DATE NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_math`),
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `mathapp`.`user_table` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
