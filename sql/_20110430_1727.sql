-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.35


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema assistec
--

CREATE DATABASE IF NOT EXISTS assistec;
USE assistec;

--
-- Definition of table `assistec`.`atendimento`
--

DROP TABLE IF EXISTS `assistec`.`atendimento`;
CREATE TABLE  `assistec`.`atendimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `hora_inicial` time DEFAULT NULL,
  `hora_final` time DEFAULT NULL,
  `descricao` varchar(35) NOT NULL,
  `defeito_constatado` varchar(45) DEFAULT NULL,
  `observacao` varchar(60) DEFAULT NULL,
  `id_tecnico` int(11) NOT NULL,
  `id_chamado` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chamado` (`id_chamado`),
  KEY `fk_tecnico` (`id_tecnico`),
  CONSTRAINT `fk_chamado` FOREIGN KEY (`id_chamado`) REFERENCES `chamado` (`id`),
  CONSTRAINT `fk_tecnico` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `assistec`.`atendimento`
--

/*!40000 ALTER TABLE `atendimento` DISABLE KEYS */;
LOCK TABLES `atendimento` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `atendimento` ENABLE KEYS */;


--
-- Definition of table `assistec`.`chamado`
--

DROP TABLE IF EXISTS `assistec`.`chamado`;
CREATE TABLE  `assistec`.`chamado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_hora_abertura` datetime NOT NULL,
  `data_hora_fechamento` datetime DEFAULT NULL,
  `defeito_reclamado` varchar(35) NOT NULL,
  `solicitante` varchar(20) DEFAULT NULL,
  `aberto` tinyint(1) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_equipamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assistec`.`chamado`
--

/*!40000 ALTER TABLE `chamado` DISABLE KEYS */;
LOCK TABLES `chamado` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `chamado` ENABLE KEYS */;


--
-- Definition of table `assistec`.`cliente`
--

DROP TABLE IF EXISTS `assistec`.`cliente`;
CREATE TABLE  `assistec`.`cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `uf` char(2) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `assistec`.`cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
LOCK TABLES `cliente` WRITE;
INSERT INTO `assistec`.`cliente` VALUES  (5,'cliente 1','endereco 1','cidade 1','AM','111-1111'),
 (6,'CLIENTE 2','ENDERECO 2','CIDADE 2','GO','222-2222'),
 (7,'BANCO D BRASIL','AV. PRES. VARGAS','BELEM','PA','222-2222'),
 (8,'BANCO CENTRAL','AV. GASPAR VIANA','BELEM','PA','333-3333');
UNLOCK TABLES;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `assistec`.`equipamento`
--

DROP TABLE IF EXISTS `assistec`.`equipamento`;
CREATE TABLE  `assistec`.`equipamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  `numeroSerie` varchar(30) DEFAULT NULL,
  `patrimonio` varchar(30) NOT NULL,
  `id_marca` int(11) NOT NULL DEFAULT '0',
  `id_modelo` int(11) NOT NULL DEFAULT '0',
  `id_cliente` int(11) NOT NULL DEFAULT '0',
  `observacao` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_marca` (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assistec`.`equipamento`
--

/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
LOCK TABLES `equipamento` WRITE;
INSERT INTO `assistec`.`equipamento` VALUES  (1,'LEITOR','111','1111',3,6,5,NULL),
 (2,'IMPRESSORA','222','222',4,11,5,NULL),
 (3,'COLETOR','333','333',2,5,5,NULL),
 (4,'LEITOR','444','444',3,6,5,NULL),
 (5,'IMPRESSORA','111','111',4,11,5,NULL),
 (6,'IMPRESSORA','555','5555',4,12,5,NULL),
 (7,'IMPRESSORA','555','5555',4,11,6,NULL),
 (8,'IMPRESSORA','5567','5555',4,11,5,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;


--
-- Definition of table `assistec`.`marca`
--

DROP TABLE IF EXISTS `assistec`.`marca`;
CREATE TABLE  `assistec`.`marca` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(35) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `assistec`.`marca`
--

/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
LOCK TABLES `marca` WRITE;
INSERT INTO `assistec`.`marca` VALUES  (1,'SYMBOL'),
 (2,'MOTOROLA'),
 (3,'CIPHERLAB'),
 (4,'ZEBRA'),
 (5,'Marca 5'),
 (6,'Marca 6'),
 (7,'marca 7'),
 (8,'marca 8');
UNLOCK TABLES;
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;


--
-- Definition of table `assistec`.`modelo`
--

DROP TABLE IF EXISTS `assistec`.`modelo`;
CREATE TABLE  `assistec`.`modelo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `id_marca` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_marca` (`id_marca`),
  CONSTRAINT `FK_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `assistec`.`modelo`
--

/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
LOCK TABLES `modelo` WRITE;
INSERT INTO `assistec`.`modelo` VALUES  (1,'Modelo 1',1),
 (2,'Modelo 2',1),
 (3,'Modelo 3',1),
 (4,'Modelo 4',2),
 (5,'Modelo 5.1',2),
 (6,'Modelo 6',3),
 (7,'Modelo 7',3),
 (8,'LS110',1),
 (9,'PPT2700',1),
 (10,'1600',3),
 (11,'s400',4),
 (12,'s600',4),
 (13,'m',1),
 (14,'m',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;


--
-- Definition of table `assistec`.`tecnico`
--

DROP TABLE IF EXISTS `assistec`.`tecnico`;
CREATE TABLE  `assistec`.`tecnico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assistec`.`tecnico`
--

/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
LOCK TABLES `tecnico` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
