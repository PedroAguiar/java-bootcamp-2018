
CREATE DATABASE shoppingcart;
USE Shoppingcart;


CREATE TABLE `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
  ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
  
CREATE TABLE `order` (
  `idOrder` int(11) NOT NULL AUTO_INCREMENT,
  `nameOrd` varchar(45) DEFAULT NULL,
  `idClient_fk` int(11) NOT NULL,
  PRIMARY KEY (`idOrder`),
  KEY `FK_Clients_Payments_id` (`idClient_fk`),
  CONSTRAINT `FK_Orders_Clients` FOREIGN KEY (`idClient_fk`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


CREATE TABLE `item` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `nameItem` varchar(45) DEFAULT NULL,
  `idOrder_fk` int(11) NOT NULL,
  PRIMARY KEY (`idItem`),
  KEY `fk_Items_orders` (`idOrder_fk`),
  CONSTRAINT `fk_Items_Orders` FOREIGN KEY (`idOrder_fk`) REFERENCES `order` (`idOrder`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

CREATE TABLE `payment` (
  `idPayment` int(11) NOT NULL AUTO_INCREMENT,
  `amount` varchar(45) DEFAULT NULL,
  `idOrder_fk` int(11) NOT NULL,
  PRIMARY KEY (`idPayment`),
  KEY `fk_Payments_orders` (`idOrder_fk`),
  CONSTRAINT `fk_Payments_Orders` FOREIGN KEY (`idOrder_fk`) REFERENCES `order` (`idOrder`) ON DELETE CASCADE ON UPDATE CASCADE 
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
