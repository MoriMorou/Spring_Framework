--liquibase formatted sql

--changeset MoriMorou:1
--comment create security tables
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
);

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(512) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
);

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `fk_users_roles_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_users_roles_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

--changeset MoriMorou:2
--comment fill security tables
INSERT INTO `users` VALUES (1,'admin','$2a$10$/z5jkuuGfN9nlynG3jhlS.YxvTjPniXS3eiQdjVp369jOdKHZKoCe','Mori','Morou','mori_morou@mail.ru'), (2, 'user', '$2a$10$ab8/UIVfC4cSCQgYWvbUluHKXmPxgLuxKJX7E5vGf3Qf.EaUn8Y6.', 'Dany', 'Morou', 'danyM@mail.ru');
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'), (2,'ROLE_USER'), (3,'ROLE_SALESMAN');
INSERT INTO `users_roles` VALUES (1,1), (2,2);

--changeset MoriMorou:3
--comment create tables for goods
CREATE TABLE `good_type` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)	
);

CREATE TABLE `good_brend` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)	
);

CREATE TABLE `good_size` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `goods` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`model` varchar(100) NOT NULL,
`description` varchar(100) NOT NULL,
`price` varchar(11) NOT NULL,
`good_type_id` int(11) NOT NULL,
`good_brend_id` int(11) NOT NULL,
`good_size_id` int(11) NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_good_type_goods` FOREIGN KEY (`good_type_id`) REFERENCES `good_type`(`id`),
CONSTRAINT `fk_goot_brend_goods` FOREIGN KEY (`good_brend_id`) REFERENCES `good_brend`(`id`)
CONSTRAINT `fk_goot_size_goods` FOREIGN KEY (`good_size_id`) REFERENCES `good_size`(`id`)
);

--changeset MoriMorou:4
--comment fill good tables
INSERT INTO `good_type` VALUES (1, 'clothes'), (2, 'shoes'), (3, 'accessories');
INSERT INTO `good_brend` VALUES (1, 'Michael Kors'), (2, 'Jeffrey Campbell'), (3, 'Dior');
INSERT INTO `good_size` VALUES (1, '44'), (2, '46'), (3, '48');

