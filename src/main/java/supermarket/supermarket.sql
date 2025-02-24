-- MySQL Script generated by MySQL Workbench
-- Fri Jan 24 15:47:11 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Product_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Product_categories` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Product_categories` (
                                                           `category_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                           `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`category_id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Products` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Products` (
                                                 `product_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                 `name` VARCHAR(45) NOT NULL,
    `description` TEXT NOT NULL,
    `price` DECIMAL(10,2) UNSIGNED NOT NULL,
    `quantity` INT UNSIGNED NOT NULL,
    `category_id` BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (`product_id`),
    INDEX `fk_Products_Categories_idx` (`category_id` ASC),
    CONSTRAINT `fk_Products_Categories`
    FOREIGN KEY (`category_id`)
    REFERENCES `mydb`.`Product_categories` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Roles` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Roles` (
                                              `role_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                              `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(255) NULL,
    PRIMARY KEY (`role_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Store`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Store` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Store` (
                                              `store_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                              `address` VARCHAR(255) NOT NULL,
    `postal_code` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`store_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Users` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Users` (
                                              `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                              `username` VARCHAR(50) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `role_id` BIGINT UNSIGNED NOT NULL,
    `store_id` BIGINT UNSIGNED NOT NULL,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`),
    INDEX `fk_Users_Roles1_idx` (`role_id` ASC),
    INDEX `fk_Users_Store1_idx` (`store_id` ASC),
    CONSTRAINT `fk_Users_Roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `mydb`.`Roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_Users_Store1`
    FOREIGN KEY (`store_id`)
    REFERENCES `mydb`.`Store` (`store_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Customers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Customers` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Customers` (
                                                  `customer_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                  `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(255) NULL,
    `birth_date` DATE NOT NULL,
    `contact_number` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`customer_id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Suppliers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Suppliers` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Suppliers` (
                                                  `supplier_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                  `name` VARCHAR(255) NOT NULL,
    `contact_number` VARCHAR(15) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `address` TEXT(255) NOT NULL,
    PRIMARY KEY (`supplier_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Product_supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Product_supplier` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Product_supplier` (
                                                         `supplier_id` BIGINT UNSIGNED NOT NULL,
                                                         `product_id` BIGINT UNSIGNED NOT NULL,
                                                         `quantity` INT UNSIGNED NOT NULL,
                                                         PRIMARY KEY (`supplier_id`, `product_id`),
    INDEX `fk_Suppliers_has_Products_Products1_idx` (`product_id` ASC),
    INDEX `fk_Suppliers_has_Products_Suppliers1_idx` (`supplier_id` ASC),
    CONSTRAINT `fk_Suppliers_has_Products_Suppliers1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `mydb`.`Suppliers` (`supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_Suppliers_has_Products_Products1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`Products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Payment_method`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Payment_method` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Payment_method` (
                                                       `payment_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                       `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`payment_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Checkout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Checkout` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Checkout` (
                                                 `checkout_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                 `store_id` BIGINT UNSIGNED NOT NULL,
                                                 `is_active` TINYINT(1) NOT NULL DEFAULT 0,
    PRIMARY KEY (`checkout_id`, `store_id`),
    INDEX `fk_Checkout_Store1_idx` (`store_id` ASC),
    CONSTRAINT `fk_Checkout_Store1`
    FOREIGN KEY (`store_id`)
    REFERENCES `mydb`.`Store` (`store_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase` (
                                                 `purchase_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                 `payment_method_id` BIGINT UNSIGNED NULL,
                                                 `customer_id` BIGINT UNSIGNED NULL,
                                                 `checkout_id` BIGINT UNSIGNED NOT NULL,
                                                 `store_id` BIGINT UNSIGNED NOT NULL,
                                                 `user_id` BIGINT UNSIGNED NULL,
                                                 `created_at` TIMESTAMP NOT NULL DEFAULT current_timestamp,
                                                 PRIMARY KEY (`purchase_id`),
    INDEX `fk_Purchase_Payment_method1_idx` (`payment_method_id` ASC),
    INDEX `fk_Purchase_Customers1_idx` (`customer_id` ASC),
    INDEX `fk_Purchase_Checkout1_idx` (`checkout_id` ASC, `store_id` ASC),
    INDEX `fk_Purchase_Users1_idx` (`user_id` ASC),
    CONSTRAINT `fk_Purchase_Payment_method1`
    FOREIGN KEY (`payment_method_id`)
    REFERENCES `mydb`.`Payment_method` (`payment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_Purchase_Customers1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `mydb`.`Customers` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_Purchase_Checkout1`
    FOREIGN KEY (`checkout_id` , `store_id`)
    REFERENCES `mydb`.`Checkout` (`checkout_id` , `store_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_Purchase_Users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`Users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Purchase_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Purchase_item` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Purchase_item` (
                                                      `purchase_id` BIGINT UNSIGNED NOT NULL,
                                                      `product_id` BIGINT UNSIGNED NOT NULL,
                                                      `quantity` INT UNSIGNED NOT NULL,
                                                      `price_at_purchase` DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (`purchase_id`, `product_id`),
    INDEX `fk_Purchase_has_Products_Products1_idx` (`product_id` ASC),
    INDEX `fk_Purchase_has_Products_Purchase1_idx` (`purchase_id` ASC),
    CONSTRAINT `fk_Purchase_has_Products_Purchase1`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `mydb`.`Purchase` (`purchase_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_Purchase_has_Products_Products1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`Products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
