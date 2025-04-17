-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pixup
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pixup` ;

-- -----------------------------------------------------
-- Schema pixup
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pixup` DEFAULT CHARACTER SET utf8mb3 ;
SHOW WARNINGS;
USE `pixup` ;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_artista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_artista` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_artista` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_disquera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_disquera` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_disquera` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_genero_musical`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_genero_musical` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_genero_musical` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_disco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_disco` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_disco` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TITULO` VARCHAR(200) NOT NULL,
  `PRECIO` FLOAT NOT NULL,
  `EXISTENCIA` INT NOT NULL,
  `DESCUENTO` FLOAT NOT NULL,
  `FECHA_LANZAMIENTO` VARCHAR(40) NOT NULL,
  `IMAGEN` VARCHAR(120) NOT NULL,
  `TBL_ARTISTA_ID` INT NOT NULL,
  `TBL_DISQUERA_ID` INT NOT NULL,
  `TBL_GENERO_MUSICAL_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_DISCO_TBL_ARTISTA1`
    FOREIGN KEY (`TBL_ARTISTA_ID`)
    REFERENCES `pixup`.`tbl_artista` (`ID`),
  CONSTRAINT `fk_TBL_DISCO_TBL_DISQUERA1`
    FOREIGN KEY (`TBL_DISQUERA_ID`)
    REFERENCES `pixup`.`tbl_disquera` (`ID`),
  CONSTRAINT `fk_TBL_DISCO_TBL_GENERO_MUSICAL1`
    FOREIGN KEY (`TBL_GENERO_MUSICAL_ID`)
    REFERENCES `pixup`.`tbl_genero_musical` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_DISCO_TBL_ARTISTA1_idx` ON `pixup`.`tbl_disco` (`TBL_ARTISTA_ID` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_DISCO_TBL_DISQUERA1_idx` ON `pixup`.`tbl_disco` (`TBL_DISQUERA_ID` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_DISCO_TBL_GENERO_MUSICAL1_idx` ON `pixup`.`tbl_disco` (`TBL_GENERO_MUSICAL_ID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_cancion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_cancion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_cancion` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TITULO` VARCHAR(100) NOT NULL,
  `DURACION` VARCHAR(40) NOT NULL,
  `TBL_DISCO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_CANCION_TBL_DISCO1`
    FOREIGN KEY (`TBL_DISCO_ID`)
    REFERENCES `pixup`.`tbl_disco` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_CANCION_TBL_DISCO1_idx` ON `pixup`.`tbl_cancion` (`TBL_DISCO_ID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_estado` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_estado` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ESTADO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_municipio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_municipio` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_municipio` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `MUNICIPIO` VARCHAR(45) NOT NULL,
  `TBL_ESTADO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_MUNICIPIO_TBL_ESTADO`
    FOREIGN KEY (`TBL_ESTADO_ID`)
    REFERENCES `pixup`.`tbl_estado` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_MUNICIPIO_TBL_ESTADO_idx` ON `pixup`.`tbl_municipio` (`TBL_ESTADO_ID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_colonia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_colonia` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_colonia` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `CP` CHAR(5) NULL DEFAULT NULL,
  `TBL_MUNICIPIO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_COLONIA_TBL_MUNICIPIO1`
    FOREIGN KEY (`TBL_MUNICIPIO_ID`)
    REFERENCES `pixup`.`tbl_municipio` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_COLONIA_TBL_MUNICIPIO1_idx` ON `pixup`.`tbl_colonia` (`TBL_MUNICIPIO_ID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_usuario` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_usuario` (
  `ID` INT NOT NULL,
  `NOMBRE` VARCHAR(40) NOT NULL,
  `PRIMER_APELLIDO` VARCHAR(40) NOT NULL,
  `SEGUNDO_APELLIDO` VARCHAR(40) NOT NULL,
  `PASSWORD` CHAR(150) NOT NULL,
  `EMAIL` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_orden`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_orden` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_orden` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `COSTO_TOTAL` FLOAT NOT NULL,
  `FECHA` VARCHAR(40) NOT NULL,
  `CANTIDAD_TOTAL` INT NOT NULL,
  `ESTATUS_ENVIO` TINYINT(1) NOT NULL,
  `COSTO_ENVIO` FLOAT NOT NULL,
  `TBL_USUARIO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_ORDEN_TBL_USUARIO1`
    FOREIGN KEY (`TBL_USUARIO_ID`)
    REFERENCES `pixup`.`tbl_usuario` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_ORDEN_TBL_USUARIO1_idx` ON `pixup`.`tbl_orden` (`TBL_USUARIO_ID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_detalle_orden`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_detalle_orden` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_detalle_orden` (
  `ID_DISCO` INT NULL DEFAULT NULL,
  `ID_ORDEN` INT NULL DEFAULT NULL,
  `CANTIDAD` INT NOT NULL,
  `COSTO` FLOAT NOT NULL,
  `TBL_ORDEN_ID` INT NOT NULL,
  `TBL_DISCO_ID` INT NOT NULL,
  PRIMARY KEY (`TBL_ORDEN_ID`, `TBL_DISCO_ID`),
  CONSTRAINT `fk_TBL_DETALLE_ORDEN_TBL_DISCO1`
    FOREIGN KEY (`TBL_DISCO_ID`)
    REFERENCES `pixup`.`tbl_disco` (`ID`),
  CONSTRAINT `fk_TBL_DETALLE_ORDEN_TBL_ORDEN1`
    FOREIGN KEY (`TBL_ORDEN_ID`)
    REFERENCES `pixup`.`tbl_orden` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_DETALLE_ORDEN_TBL_DISCO1_idx` ON `pixup`.`tbl_detalle_orden` (`TBL_DISCO_ID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_tipo_domicilio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_tipo_domicilio` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_tipo_domicilio` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_domicilio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_domicilio` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_domicilio` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `CALLE` VARCHAR(60) NOT NULL,
  `NUM_EXTERIOR` VARCHAR(30) NOT NULL,
  `NUM_INTERIOR` VARCHAR(30) NOT NULL,
  `TBL_COLONIA_ID` INT NOT NULL,
  `TBL_TIPO_DOMICILIO_ID` INT NOT NULL,
  `TBL_USUARIO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_DOMICILIO_TBL_COLONIA1`
    FOREIGN KEY (`TBL_COLONIA_ID`)
    REFERENCES `pixup`.`tbl_colonia` (`ID`),
  CONSTRAINT `fk_TBL_DOMICILIO_TBL_TIPO_DOMICILIO1`
    FOREIGN KEY (`TBL_TIPO_DOMICILIO_ID`)
    REFERENCES `pixup`.`tbl_tipo_domicilio` (`ID`),
  CONSTRAINT `fk_TBL_DOMICILIO_TBL_USUARIO1`
    FOREIGN KEY (`TBL_USUARIO_ID`)
    REFERENCES `pixup`.`tbl_usuario` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_DOMICILIO_TBL_COLONIA1_idx` ON `pixup`.`tbl_domicilio` (`TBL_COLONIA_ID` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_DOMICILIO_TBL_TIPO_DOMICILIO1_idx` ON `pixup`.`tbl_domicilio` (`TBL_TIPO_DOMICILIO_ID` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_DOMICILIO_TBL_USUARIO1_idx` ON `pixup`.`tbl_domicilio` (`TBL_USUARIO_ID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_tipo_notificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_tipo_notificacion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_tipo_notificacion` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` VARCHAR(40) NOT NULL,
  `RUTA_PLANTILLA` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_notificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_notificacion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_notificacion` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FECHA_NOTIFICACION` VARCHAR(40) NOT NULL,
  `TBL_USUARIO_ID` INT NOT NULL,
  `TBL_TIPO_NOTIFICACION_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_NOTIFICACION_TBL_TIPO_NOTIFICACION1`
    FOREIGN KEY (`TBL_TIPO_NOTIFICACION_ID`)
    REFERENCES `pixup`.`tbl_tipo_notificacion` (`ID`),
  CONSTRAINT `fk_TBL_NOTIFICACION_TBL_USUARIO1`
    FOREIGN KEY (`TBL_USUARIO_ID`)
    REFERENCES `pixup`.`tbl_usuario` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_NOTIFICACION_TBL_USUARIO1_idx` ON `pixup`.`tbl_notificacion` (`TBL_USUARIO_ID` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_NOTIFICACION_TBL_TIPO_NOTIFICACION1_idx` ON `pixup`.`tbl_notificacion` (`TBL_TIPO_NOTIFICACION_ID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `pixup`.`tbl_pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pixup`.`tbl_pago` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `pixup`.`tbl_pago` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NUMERO_TARJETA` CHAR(4) NOT NULL,
  `FECHA` VARCHAR(40) NOT NULL,
  `TBL_ORDEN_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_PAGO_TBL_ORDEN1`
    FOREIGN KEY (`TBL_ORDEN_ID`)
    REFERENCES `pixup`.`tbl_orden` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

SHOW WARNINGS;
CREATE INDEX `fk_TBL_PAGO_TBL_ORDEN1_idx` ON `pixup`.`tbl_pago` (`TBL_ORDEN_ID` ASC) VISIBLE;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
