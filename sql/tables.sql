create database conygre;
use conygre;


CREATE TABLE `quotations` (
                              `id` int  PRIMARY KEY NOT NULL AUTO_INCREMENT,
                              `last_name` varchar(45) NOT NULL,
                              `first_name` varchar(45) NOT NULL,
                              `registration` varchar(45) NOT NULL,

                              `bodytype` varchar(45) NOT NULL,
                              `marketvalue` varchar(45) NOT NULL,
                              `owner` varchar(45) NOT NULL,
                              `othervehicles` int NOT NULL,
                              `registereddate` varchar(45) NOT NULL,
                              `enginecc` int NOT NULL,
                              `manufactureresspec` varchar(45) NOT NULL,
                              `accident` varchar(45) NOT NULL,
                              `quote` double NOT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM conygre.quotations;