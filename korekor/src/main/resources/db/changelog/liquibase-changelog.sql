--liquibase formatted sql

--changeset MoriMorou:1
--comment create security tables

CREATE TABLE IF NOT EXISTS `korekor`.`brands` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UC_BRANDSNAME_COL` (`name` ASC) VISIBLE)
    ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `korekor`.`categories` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UC_CATEGORIESNAME_COL` (`name` ASC) VISIBLE)
    ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `korekor`.`pictures_data` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `data` MEDIUMBLOB NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `korekor`.`pictures` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `content_type` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `picture_data_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UK_ehsu2tyinopypjox1ijxt3g3c` (`picture_data_id` ASC) VISIBLE,
    CONSTRAINT `FKe9cv52k04xoy6cj8xy308gnw3`
        FOREIGN KEY (`picture_data_id`)
            REFERENCES `korekor`.`pictures_data` (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



CREATE TABLE IF NOT EXISTS `korekor`.`products` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `price` DECIMAL(19,2) NULL DEFAULT NULL,
    `brand_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `FKa3a4mpsfdf4d2y6r8ra3sc8mv` (`brand_id` ASC) VISIBLE,
    CONSTRAINT `FKa3a4mpsfdf4d2y6r8ra3sc8mv`
        FOREIGN KEY (`brand_id`)
            REFERENCES `korekor`.`brands` (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `korekor`.`products_categories` (
    `product_id` BIGINT(20) NOT NULL,
    `category_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`product_id`, `category_id`),
    INDEX `FKqt6m2o5dly3luqcm00f5t4h2p` (`category_id` ASC) VISIBLE,
    CONSTRAINT `FKqt6m2o5dly3luqcm00f5t4h2p`
        FOREIGN KEY (`category_id`)
            REFERENCES `korekor`.`categories` (`id`),
            CONSTRAINT `FKtj1vdea8qwerbjqie4xldl1el`
                FOREIGN KEY (`product_id`)
                    REFERENCES `korekor`.`products` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



CREATE TABLE IF NOT EXISTS `korekor`.`products_pictures` (
    `product_id` BIGINT(20) NOT NULL,
    `picture_id` BIGINT(20) NOT NULL,
    INDEX `FKh3amnci4cl7xcl1al140xw79e` (`product_id` ASC) VISIBLE,
    INDEX `FKloucf8ggy74nmdej2jmvttvi4` (`picture_id` ASC) VISIBLE,
    CONSTRAINT `FKh3amnci4cl7xcl1al140xw79e`
        FOREIGN KEY (`product_id`)
            REFERENCES `korekor`.`products` (`id`),
            CONSTRAINT `FKloucf8ggy74nmdej2jmvttvi4`
                FOREIGN KEY (`picture_id`)
                    REFERENCES `korekor`.`pictures` (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



CREATE TABLE IF NOT EXISTS `korekor`.`roles` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name` (`name` ASC) VISIBLE)
    ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `korekor`.`users` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(512) NOT NULL,
    `first_name` VARCHAR(50) NULL DEFAULT NULL,
    `last_name` VARCHAR(50) NULL DEFAULT NULL,
    `email` VARCHAR(50) NULL DEFAULT NULL,
    `photo` MEDIUMBLOB NULL DEFAULT NULL,
    `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username` (`username` ASC) VISIBLE)
    ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `korekor`.`users_roles` (
    `user_id` INT(11) NOT NULL,
    `role_id` INT(11) NOT NULL,
    INDEX `fk_user_id` (`user_id` ASC) VISIBLE,
    INDEX `fk_role_id` (`role_id` ASC) VISIBLE,
    CONSTRAINT `fk_role_id`
        FOREIGN KEY (`role_id`)
            REFERENCES `korekor`.`roles` (`id`),
            CONSTRAINT `fk_user_id`
                FOREIGN KEY (`user_id`)
                    REFERENCES `korekor`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

--changeset MoriMorou:2
--comment create User
INSERT INTO `users` VALUES (1,'admin','$2a$10$/z5jkuuGfN9nlynG3jhlS.YxvTjPniXS3eiQdjVp369jOdKHZKoCe','Mori','Morou','mori_morou@mail.ru', NULL, '2019-07-08 23:41:53', '2019-07-08 23:41:53'), (2, 'user', '$2a$10$ab8/UIVfC4cSCQgYWvbUluHKXmPxgLuxKJX7E5vGf3Qf.EaUn8Y6.', 'Dany', 'Morou', 'danyM@mail.ru', NULL, '2019-07-08 23:41:53', '2019-07-08 23:41:53');
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'), (2,'ROLE_USER'), (3,'ROLE_SALESMAN');
INSERT INTO `users_roles` VALUES (1,1), (2,2);

--changeset MoriMorou:3
--comment create product details
INSERT INTO `categories` VALUES (1, 'cat1'), (2, 'cat2');
INSERT INTO `brands` VALUES (1,'br1'), (2,'br2'), (3,'br3');
