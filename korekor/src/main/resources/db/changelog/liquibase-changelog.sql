--liquibase formatted sql

--changeset morimorou:1
--comment create tables for users
CREATE TABLE `user_roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role` (`role`))
ENGINE = InnoDB;

CREATE TABLE `users` (
  `id` BIGINT(20) NOT NULL, AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(515) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `postcode` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `status` TINYINT NULL,
  `user_roles_id` INT NOT NULL,
  `data` TIMESTAMP(8) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
  INDEX `fk_users_user_roles1_idx` (`user_roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_user_roles`
    FOREIGN KEY (`user_roles_id`)
    REFERENCES `korekor`.`user_roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

--changeset morimorou:2
--comment create tables for product
CREATE TABLE `items` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` DECIMAL(8,2) NULL,
  `description` VARCHAR(1000) NULL,
  `full_description` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `product_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT(300) NULL,
  `barcode-prefix` TEXT(20) NULL,
  `alpha_code` TEXT(20) NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `barcode-prefix_UNIQUE` (`barcode-prefix` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE `color` (
  `id` INT NOT NULL,
  `description` TEXT(20) NULL,
  `barcode_prefix` TEXT(20) NULL,
  `alpha_code` TEXT(20) NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `barcode_prefix_UNIQUE` (`barcode_prefix` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE `size` (
  `id` INT NOT NULL,
  `description` TEXT(20) NULL,
  `barcode_prefix` TEXT(20) NULL,
  `alpha_code` TEXT(20) NULL,
  `status` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `barcode_prefix_UNIQUE` (`barcode_prefix` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE `brands` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `products` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `qty` INT NULL,
  `status` TINYINT NULL,
  `product_type_id` INT NOT NULL,
  `items_id` BIGINT(20) NOT NULL,
  `color_id` INT NOT NULL,
  `size_id` INT NOT NULL,
  `brands_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_products_product_type1_idx` (`product_type_id` ASC) VISIBLE,
  INDEX `fk_products_items1_idx` (`items_id` ASC) VISIBLE,
  INDEX `fk_products_color1_idx` (`color_id` ASC) VISIBLE,
  INDEX `fk_products_size1_idx` (`size_id` ASC) VISIBLE,
  INDEX `fk_products_brands1_idx` (`brands_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_product_type1`
    FOREIGN KEY (`product_type_id`)
    REFERENCES `korekor`.`product_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_items1`
    FOREIGN KEY (`items_id`)
    REFERENCES `korekor`.`items` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_color1`
    FOREIGN KEY (`color_id`)
    REFERENCES `korekor`.`color` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_size1`
    FOREIGN KEY (`size_id`)
    REFERENCES `korekor`.`size` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_brands1`
    FOREIGN KEY (`brands_id`)
    REFERENCES `korekor`.`brands` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION))
ENGINE = InnoDB;

CREATE TABLE `products_categories` (
  `products_id` BIGINT(20) NOT NULL,
  `categories_id` int(11) NOT NULL,
  PRIMARY KEY (`products_id`, `categories_id`),
  CONSTRAINT `fk_products_categories_categories` FOREIGN KEY (`categories_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_categories_products_users` FOREIGN KEY (`products_id`) REFERENCES `users` (`id`)
);

--changeset morimorou:3
--comment create tables for pictures
CREATE TABLE `picture_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `pictures` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `picture_data` MEDIUMBLOB NULL,
  `picture_types_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photos_picture_types1_idx` (`picture_types_id` ASC) VISIBLE,
  CONSTRAINT `fk_pictures_picture_types1`
    FOREIGN KEY (`picture_types_id`)
    REFERENCES `korekor`.`picture_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `pictures_products` (
  `pictures_id` BIGINT(20) NOT NULL,
  `products_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`pictures_id`, `products_id`),
  INDEX `fk_pictures_has_products_products1_idx` (`products_id` ASC) VISIBLE,
  INDEX `fk_pictures_has_products_pictures1_idx` (`pictures_id` ASC) VISIBLE,
  CONSTRAINT `fk_pictures_has_products_pictures1`
    FOREIGN KEY (`pictures_id`)
    REFERENCES `korekor`.`pictures` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pictures_has_products_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `korekor`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
);

--changeset morimorou:4
--comment create tables for staff
CREATE TABLE `staff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `password` VARCHAR(515) NOT NULL,
  `user_roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_staff_user_roles1_idx` (`user_roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_staff_user_roles1`
    FOREIGN KEY (`user_roles_id`)
    REFERENCES `korekor`.`user_roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- НУЖНО ДОДЕЛАТЬ
CREATE TABLE `pictures_staff` (
  `pictures_id` BIGINT(20) NOT NULL,
  `staff_id` INT NOT NULL,
  PRIMARY KEY (`pictures_id`, `staff_id`),
  INDEX `fk_pictures_has_staff_staff1_idx` (`staff_id` ASC) VISIBLE,
  INDEX `fk_pictures_has_staff_pictures1_idx` (`pictures_id` ASC) VISIBLE,
  CONSTRAINT `fk_pictures_has_staff_photos1`
    FOREIGN KEY (`pictures_id`)
    REFERENCES `korekor`.`pictures` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pictures_has_staff_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `korekor`.`staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

--changeset skhanov:5
--create table for orders
CREATE TABLE `orders` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`order_time` timestamp NOT NULL,
`user_id` int(11) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_orders_users` FOREIGN KEY (`user_id`) REFERENCES `users`(`id`)
);

CREATE TABLE `order_items` (
  `id` int(11) NOT NUll AUTO_INCREMENT,
  `order_id` int(11) NOT NUll,
  `product_id` int(11) NOT NUll,
  `quantity` int(11) NOT NUll,
  PRIMARY KEY (`id`),
  CONSTRAINT `order_items_orders` FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`),
  CONSTRAINT `order_items_products` FOREIGN KEY (`product_id`) REFERENCES
  `products`(`id`)
)