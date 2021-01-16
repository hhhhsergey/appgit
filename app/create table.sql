/* для приложения app */
CREATE DATABASE `mathapp`;
use hhhh;

CREATE TABLE `mathapp`.`user_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `active` TINYINT NULL,
  `userrole` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `mathapp`.`math_table` (
  `id_math` INT NOT NULL AUTO_INCREMENT,
  `rank` DOUBLE NOT NULL,
  `rank_total` DOUBLE NOT NULL,
  `date` DATE NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_math`),
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `mathapp`.`user_table` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

use mathapp;
insert into user_table (username,password)values('bob','bob');
select*from user_table;
select username,password from user_table where username ='bob';
select * from user_table where username='sergey';
select*from math_table;
insert into math_table (rank,rank_total,date,id_user)values(1,1,'2020/11/09',1);
insert into math_table ('rank','rank_total','date','id_user')values('1','1','2020/11/09','1');
select * from math_table where date>'2021-01-01';
select * from math_table where date>'2020-01-01';
INSERT INTO `math_table` (`rank`, `rank_total`, `date`, `id_user`) VALUES ('2', '2', '2020/11/09', '2');
select username,password,active from user_table where username = 'bob';
select username,userrole from user_table where username = 'bob';
select username from user_table where username='tom';
select *from math_table where id_user ='2';
SELECT COUNT(*) FROM math_table WHERE id_user='1';
SELECT COUNT(*) FROM math_table WHERE id_user='2';
select * from math_table where id_user='2' order by id_math desc limit 0,1 ;
