
CREATE TABLE `transaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `accountnumber` VARCHAR(45) NULL,
  `accounttype` VARCHAR(45) NULL,
  `amount` DOUBLE(20,2) NULL,
  `balance` DOUBLE(20,2) NULL,
  `crdr` VARCHAR(45) NULL,
  `description` VARCHAR(400) NULL,
  `processingdate` DATETIME NULL,
  `userid` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `goals` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `accounttype` VARCHAR(30) NULL,
  `createddate` DATETIME NULL,
  `duedate` DATE NULL,
  `goalamount` DOUBLE(20,2) NULL,
  `goalnote` VARCHAR(400) NULL,
  `goalreward` DOUBLE(20,2) NULL,
  `goalstatus` VARCHAR(30) NULL,
  `title` VARCHAR(100) NULL,
  `userid` INT NULL,
  `goaltype` VARCHAR(50) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(300) NULL,
  `username` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY(`username`));

