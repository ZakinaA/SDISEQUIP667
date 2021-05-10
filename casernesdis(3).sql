-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 10 mai 2021 à 12:49
-- Version du serveur :  5.7.31-log
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `casernesdis`
--

-- --------------------------------------------------------

--
-- Structure de la table `assumer`
--

DROP TABLE IF EXISTS `assumer`;
CREATE TABLE IF NOT EXISTS `assumer` (
  `POM_ID` int(10) NOT NULL,
  `FON_ID` int(2) NOT NULL,
  PRIMARY KEY (`POM_ID`,`FON_ID`),
  KEY `I_FK_ASSUMER_POMPIER` (`POM_ID`),
  KEY `I_FK_ASSUMER_FONCTION` (`FON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `assumer`
--

INSERT INTO `assumer` (`POM_ID`, `FON_ID`) VALUES
(1, 50),
(1, 65),
(2, 65),
(2, 75);

-- --------------------------------------------------------

--
-- Structure de la table `caserne`
--

DROP TABLE IF EXISTS `caserne`;
CREATE TABLE IF NOT EXISTS `caserne` (
  `CAS_ID` int(2) NOT NULL AUTO_INCREMENT,
  `CAS_RUE` char(50) DEFAULT NULL,
  `CAS_NOM` char(32) DEFAULT NULL,
  `CAS_CP` char(32) DEFAULT NULL,
  `CAS_VILLE` char(32) DEFAULT NULL,
  PRIMARY KEY (`CAS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `caserne`
--

INSERT INTO `caserne` (`CAS_ID`, `CAS_RUE`, `CAS_NOM`, `CAS_CP`, `CAS_VILLE`) VALUES
(1, 'Rue de Victor Hugo', 'Caserne du feu sacré', '14000', 'Caen'),
(2, 'Rue du mur', 'Caserne de Jacques', 'codePos', 'Bouzolles'),
(5, 'Boulevard Fécho', 'FEU Réedition', 'FLOT', 'Tourcoing'),
(6, 'Rue', 'Caserne Ifs', 'Cp', 'VIlle');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `POM_ID` int(10) NOT NULL,
  `COM_MDP` char(32) DEFAULT NULL,
  `com_type` varchar(1) NOT NULL,
  PRIMARY KEY (`POM_ID`),
  KEY `I_FK_COMPTE_POMPIER` (`POM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`POM_ID`, `COM_MDP`, `com_type`) VALUES
(1, 'pompier', 's'),
(2, 'pompier', 'a');

-- --------------------------------------------------------

--
-- Structure de la table `diriger`
--

DROP TABLE IF EXISTS `diriger`;
CREATE TABLE IF NOT EXISTS `diriger` (
  `POM_ID_EST_DIRIG` int(10) NOT NULL,
  `POM_ID_DIRIGE` int(10) NOT NULL,
  PRIMARY KEY (`POM_ID_EST_DIRIG`,`POM_ID_DIRIGE`),
  KEY `I_FK_DIRIGER_POMPIER` (`POM_ID_EST_DIRIG`),
  KEY `I_FK_DIRIGER_POMPIER1` (`POM_ID_DIRIGE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `engin`
--

DROP TABLE IF EXISTS `engin`;
CREATE TABLE IF NOT EXISTS `engin` (
  `ENG_ID` int(2) NOT NULL AUTO_INCREMENT,
  `ENGTYP_ID` int(2) NOT NULL,
  `CAS_ID` int(2) NOT NULL,
  `ENG_LIBELLE` char(100) DEFAULT NULL,
  PRIMARY KEY (`ENG_ID`),
  KEY `I_FK_ENGIN_ENGINTYPE` (`ENGTYP_ID`),
  KEY `I_FK_ENGIN_CASERNE` (`CAS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `engintype`
--

DROP TABLE IF EXISTS `engintype`;
CREATE TABLE IF NOT EXISTS `engintype` (
  `ENGTYP_ID` int(2) NOT NULL AUTO_INCREMENT,
  `ENGTYP_LIBELLE` char(50) DEFAULT NULL,
  PRIMARY KEY (`ENGTYP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fonction`
--

DROP TABLE IF EXISTS `fonction`;
CREATE TABLE IF NOT EXISTS `fonction` (
  `FON_ID` int(2) NOT NULL AUTO_INCREMENT,
  `FON_LIBELLE` char(100) DEFAULT NULL,
  PRIMARY KEY (`FON_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fonction`
--

INSERT INTO `fonction` (`FON_ID`, `FON_LIBELLE`) VALUES
(45, 'Extincteur'),
(50, 'Driver'),
(65, 'Sauveur de chats'),
(75, 'Porteur échelle');

-- --------------------------------------------------------

--
-- Structure de la table `grade`
--

DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `GRA_ID` int(2) NOT NULL AUTO_INCREMENT,
  `GRA_LIBELLE` char(50) DEFAULT NULL,
  PRIMARY KEY (`GRA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `grade`
--

INSERT INTO `grade` (`GRA_ID`, `GRA_LIBELLE`) VALUES
(1, 'capitaine'),
(2, 'sergent'),
(3, 'caporal');

-- --------------------------------------------------------

--
-- Structure de la table `intervenir`
--

DROP TABLE IF EXISTS `intervenir`;
CREATE TABLE IF NOT EXISTS `intervenir` (
  `POM_ID` int(10) NOT NULL,
  `INT_ID` int(2) NOT NULL,
  PRIMARY KEY (`POM_ID`,`INT_ID`),
  KEY `I_FK_INTERVENIR_POMPIER` (`POM_ID`),
  KEY `I_FK_INTERVENIR_INTERVENTION` (`INT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `intervenir`
--

INSERT INTO `intervenir` (`POM_ID`, `INT_ID`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

DROP TABLE IF EXISTS `intervention`;
CREATE TABLE IF NOT EXISTS `intervention` (
  `INT_ID` int(2) NOT NULL AUTO_INCREMENT,
  `TYP_ID` int(2) NOT NULL,
  `INT_LIEU` char(32) DEFAULT NULL,
  `INT_DATE` date DEFAULT NULL,
  `INT_HEUREAPPEL` time DEFAULT NULL,
  `INT_DUREE` time DEFAULT NULL,
  PRIMARY KEY (`INT_ID`),
  KEY `I_FK_INTERVENTION_TYPE` (`TYP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `intervention`
--

INSERT INTO `intervention` (`INT_ID`, `TYP_ID`, `INT_LIEU`, `INT_DATE`, `INT_HEUREAPPEL`, `INT_DUREE`) VALUES
(1, 1, 'Ifs', '2021-05-04', '14:18:48', '02:18:48'),
(2, 2, 'Caen', '2021-05-06', '07:18:48', '04:00:48');

-- --------------------------------------------------------

--
-- Structure de la table `necessiter`
--

DROP TABLE IF EXISTS `necessiter`;
CREATE TABLE IF NOT EXISTS `necessiter` (
  `INT_ID` int(2) NOT NULL,
  `ENG_ID` int(2) NOT NULL,
  PRIMARY KEY (`INT_ID`,`ENG_ID`),
  KEY `I_FK_NECESSITER_INTERVENTION` (`INT_ID`),
  KEY `I_FK_NECESSITER_ENGIN` (`ENG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pompier`
--

DROP TABLE IF EXISTS `pompier`;
CREATE TABLE IF NOT EXISTS `pompier` (
  `POM_ID` int(10) NOT NULL,
  `GRA_ID` int(2) NOT NULL,
  `CAS_ID` int(2) NOT NULL,
  `POM_NOM` char(50) DEFAULT NULL,
  `POM_PRENOM` char(50) DEFAULT NULL,
  `POM_DATENAISSANCE` date DEFAULT NULL,
  `POM_NUMEROBIP` int(2) DEFAULT NULL,
  `POM_SEXE` char(1) DEFAULT NULL,
  `POM_TELEPHONE` char(32) DEFAULT NULL,
  PRIMARY KEY (`POM_ID`),
  KEY `I_FK_POMPIER_GRADE` (`GRA_ID`),
  KEY `I_FK_POMPIER_CASERNE` (`CAS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pompier`
--

INSERT INTO `pompier` (`POM_ID`, `GRA_ID`, `CAS_ID`, `POM_NOM`, `POM_PRENOM`, `POM_DATENAISSANCE`, `POM_NUMEROBIP`, `POM_SEXE`, `POM_TELEPHONE`) VALUES
(1, 1, 1, 'Richelieu', 'Hubertrand', '2001-09-11', 47, 'H', '0675483435'),
(2, 2, 1, 'Mur', 'Hugo', '2020-06-11', 456, 'H', '54456454646');

-- --------------------------------------------------------

--
-- Structure de la table `profession`
--

DROP TABLE IF EXISTS `profession`;
CREATE TABLE IF NOT EXISTS `profession` (
  `PRO_ID` int(5) NOT NULL AUTO_INCREMENT,
  `PRO_LIBELLE` char(50) DEFAULT NULL,
  `PRO_VILLE` char(50) DEFAULT NULL,
  PRIMARY KEY (`PRO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `profession`
--

INSERT INTO `profession` (`PRO_ID`, `PRO_LIBELLE`, `PRO_VILLE`) VALUES
(1, 'Apiculteur', 'Perpignan'),
(6, 'Ebéniste', 'Metz');

-- --------------------------------------------------------

--
-- Structure de la table `professionnel`
--

DROP TABLE IF EXISTS `professionnel`;
CREATE TABLE IF NOT EXISTS `professionnel` (
  `POM_ID` int(10) NOT NULL,
  `PRO_INDICETRAITEMENT` char(32) DEFAULT NULL,
  `PRO_DATEOBTENTIONINDICE` date DEFAULT NULL,
  PRIMARY KEY (`POM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `professionnel`
--

INSERT INTO `professionnel` (`POM_ID`, `PRO_INDICETRAITEMENT`, `PRO_DATEOBTENTIONINDICE`) VALUES
(1, '485', '2020-11-18');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `TYP_ID` int(2) NOT NULL AUTO_INCREMENT,
  `TYP_LIBELLE` char(100) DEFAULT NULL,
  PRIMARY KEY (`TYP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`TYP_ID`, `TYP_LIBELLE`) VALUES
(1, 'Sauvetage de chats'),
(2, 'Incendie'),
(3, 'Blessure');

-- --------------------------------------------------------

--
-- Structure de la table `volontaire`
--

DROP TABLE IF EXISTS `volontaire`;
CREATE TABLE IF NOT EXISTS `volontaire` (
  `POM_ID` int(10) NOT NULL,
  `PRO_ID` int(5) DEFAULT NULL,
  PRIMARY KEY (`POM_ID`),
  KEY `I_FK_VOLONTAIRE_PROFESSION` (`PRO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `volontaire`
--

INSERT INTO `volontaire` (`POM_ID`, `PRO_ID`) VALUES
(2, 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `assumer`
--
ALTER TABLE `assumer`
  ADD CONSTRAINT `assumer_ibfk_1` FOREIGN KEY (`POM_ID`) REFERENCES `pompier` (`POM_ID`),
  ADD CONSTRAINT `assumer_ibfk_2` FOREIGN KEY (`FON_ID`) REFERENCES `fonction` (`FON_ID`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`POM_ID`) REFERENCES `pompier` (`POM_ID`);

--
-- Contraintes pour la table `diriger`
--
ALTER TABLE `diriger`
  ADD CONSTRAINT `diriger_ibfk_1` FOREIGN KEY (`POM_ID_DIRIGE`) REFERENCES `pompier` (`POM_ID`);

--
-- Contraintes pour la table `engin`
--
ALTER TABLE `engin`
  ADD CONSTRAINT `engin_ibfk_1` FOREIGN KEY (`ENGTYP_ID`) REFERENCES `engintype` (`ENGTYP_ID`),
  ADD CONSTRAINT `engin_ibfk_2` FOREIGN KEY (`CAS_ID`) REFERENCES `caserne` (`CAS_ID`);

--
-- Contraintes pour la table `intervenir`
--
ALTER TABLE `intervenir`
  ADD CONSTRAINT `intervenir_ibfk_1` FOREIGN KEY (`POM_ID`) REFERENCES `pompier` (`POM_ID`),
  ADD CONSTRAINT `intervenir_ibfk_2` FOREIGN KEY (`INT_ID`) REFERENCES `intervention` (`INT_ID`);

--
-- Contraintes pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD CONSTRAINT `intervention_ibfk_1` FOREIGN KEY (`TYP_ID`) REFERENCES `type` (`TYP_ID`);

--
-- Contraintes pour la table `necessiter`
--
ALTER TABLE `necessiter`
  ADD CONSTRAINT `necessiter_ibfk_1` FOREIGN KEY (`INT_ID`) REFERENCES `intervention` (`INT_ID`),
  ADD CONSTRAINT `necessiter_ibfk_2` FOREIGN KEY (`ENG_ID`) REFERENCES `engin` (`ENG_ID`);

--
-- Contraintes pour la table `pompier`
--
ALTER TABLE `pompier`
  ADD CONSTRAINT `pompier_ibfk_1` FOREIGN KEY (`GRA_ID`) REFERENCES `grade` (`GRA_ID`),
  ADD CONSTRAINT `pompier_ibfk_2` FOREIGN KEY (`CAS_ID`) REFERENCES `caserne` (`CAS_ID`);

--
-- Contraintes pour la table `professionnel`
--
ALTER TABLE `professionnel`
  ADD CONSTRAINT `professionnel_ibfk_1` FOREIGN KEY (`POM_ID`) REFERENCES `pompier` (`POM_ID`);

--
-- Contraintes pour la table `volontaire`
--
ALTER TABLE `volontaire`
  ADD CONSTRAINT `volontaire_ibfk_1` FOREIGN KEY (`PRO_ID`) REFERENCES `profession` (`PRO_ID`),
  ADD CONSTRAINT `volontaire_ibfk_2` FOREIGN KEY (`POM_ID`) REFERENCES `pompier` (`POM_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
