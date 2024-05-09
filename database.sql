CREATE TABLE `libary`.`book` (
  `bookID` INT NOT NULL,
  `bookName` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `decription` VARCHAR(45) NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`bookID`));
  CREATE TABLE `libary`.`students` (
  `studentID` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `class` VARCHAR(45) NULL,
  PRIMARY KEY (`studentID`));
CREATE TABLE `libary`.`card` (
  `cardID` INT NOT NULL,
  `idBook` INT NULL,
  `idStudent` INT NULL,
  `status` VARCHAR(45) NULL,
  `dayborrow` DATE NULL,
  `datepay` DATE NULL,
  PRIMARY KEY (`cardID`),
  INDEX `fk_IDbook_id_book_idx` (`idBook` ASC) VISIBLE,
  INDEX `fk_IDstudent_id_student_idx` (`idStudent` ASC) VISIBLE,
  CONSTRAINT `fk_IDbook_id_book`
    FOREIGN KEY (`idBook`)
    REFERENCES `libary`.`book` (`bookID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IDstudent_id_student`
    FOREIGN KEY (`idStudent`)
    REFERENCES `libary`.`students` (`studentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    insert into book value (1,"Lao Hac","Nam Cao","Truyen ngan",10);
insert into book value (2,"So Do","Vu Trong Phung","Truyen ngan",5);
insert into book value (3,"Harry poster","Marry jame","Truyen dai",6);