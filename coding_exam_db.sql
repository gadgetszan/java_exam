CREATE TABLE `exchangerate` (
  `date` datetime NOT NULL,
  `currency` varchar(45) NOT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`date`,`currency`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `transactions` (
  `transaction_date` datetime NOT NULL,
  `accountno` int NOT NULL,
  `transaction` varchar(45) DEFAULT NULL,
  `transaction_amount` decimal(19,4) DEFAULT NULL,
  KEY `fk_accountno_idx` (`accountno`),
  CONSTRAINT `fk_accountno` FOREIGN KEY (`accountno`) REFERENCES `users` (`accountno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `accountno` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `balance` decimal(19,4) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`accountno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
