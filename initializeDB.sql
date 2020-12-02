CREATE DATABASE IF NOT EXISTS `resource_mgmt`;
USE `resource_mgmt`;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `resource`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `resource`
(
    `resource_id`   int NOT NULL AUTO_INCREMENT,
    `resource_name` TEXT,
    `resource_code` int,
    PRIMARY KEY (`resource_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = latin1;

LOCK TABLES `resource` WRITE;
INSERT INTO `resource`
VALUES (0, 'Procurement and Contracting Requirements', 1000),
       (1, 'General Requirements', 200),
       (2, 'Existing Conditions', 200),
       (3, 'Concrete', 700),
       (4, 'Masonry', 1000),
       (5, 'Metals', 1000),
       (6, 'Wood, Plastics, and Composites', 1000),
       (7, 'Thermal and Moisture Protection', 10000),
       (8, 'Openings', 080000),
       (9, 'Finishes', 090000),
       (10, 'Specialities', 100000),
       (11, 'Equipment', 110000),
       (12, 'Furnishings', 120000),
       (13, 'Special Construction', 130000),
       (14, 'Conveying Equipment', 140000);
UNLOCK TABLES;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `project`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `project`
(
    `project_id`   int NOT NULL AUTO_INCREMENT,
    `project_name` TEXT,
    PRIMARY KEY (`project_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = latin1;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `project_resource`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `project_resource`
(
    `project_resource_id` int NOT NULL AUTO_INCREMENT,
    `project`             int,
    `resource`            int,
    PRIMARY KEY (`project_resource_id`),
    FOREIGN KEY (project) references project (project_id),
    FOREIGN KEY (resource) references resource (resource_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = latin1;
