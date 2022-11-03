-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 01 nov. 2022 à 17:38
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `invoices_contact`
--

-- --------------------------------------------------------

--
-- Structure de la table `activite_journaliere`
--

CREATE TABLE `activite_journaliere` (
  `id_activite_journaliere` int(11) NOT NULL,
  `debut` datetime DEFAULT NULL,
  `duree_activite` time DEFAULT '00:00:00',
  `isActive_activite` int(1) DEFAULT 1,
  `date` date DEFAULT NULL,
  `client` int(10) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `tarif` float DEFAULT NULL,
  `fin` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` int(10) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `adresse` varchar(150) DEFAULT NULL,
  `code_postale` int(10) DEFAULT NULL,
  `isActive_personne` int(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `id_demande` int(10) NOT NULL,
  `type` int(10) DEFAULT NULL,
  `client` int(10) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `heure` time DEFAULT NULL,
  `duree` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id_facture` int(11) NOT NULL,
  `identifiant` varchar(100) DEFAULT NULL,
  `somme` varchar(50) DEFAULT NULL,
  `payee` int(1) DEFAULT 0,
  `isActive_facture` int(1) DEFAULT 1,
  `nbr_totale_heure` varchar(100) DEFAULT NULL,
  `client` int(10) DEFAULT NULL,
  `date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE `type` (
  `id_type` int(10) NOT NULL,
  `type_mission` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id_utilisateur` int(10) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `adresse` varchar(150) DEFAULT NULL,
  `code_postale` int(10) DEFAULT NULL,
  `isActive_personne` int(1) DEFAULT 1,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `nom`, `prenom`, `telephone`, `email`, `adresse`, `code_postale`, `isActive_personne`, `password`) VALUES
(1, 'Lator', 'jean marie', '0665657880', 'jeanmar-97.1@hotmail.fr', NULL, NULL, 1, '$2a$10$xnQf0cBmpLbuGDzMvqKps.7WfKjG81S8Gi1/DuE84ze8Beio67FKK'),
(2, 'Dutaud', 'Pauline', '0665657880', 'lili@live.fr', NULL, NULL, 1, '$2a$10$CTmWz5s3ycHGKBAAM7itP.1H25V1kmPKir8HFQNuzSLhYsdDD8myK');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `activite_journaliere`
--
ALTER TABLE `activite_journaliere`
  ADD PRIMARY KEY (`id_activite_journaliere`),
  ADD KEY `fk_activite_journaliere_client` (`client`),
  ADD KEY `fk_activite_journaliere_type` (`type`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`id_demande`),
  ADD KEY `fk_demande_type` (`type`),
  ADD KEY `fk_demande_client` (`client`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id_facture`),
  ADD UNIQUE KEY `identifiant` (`identifiant`),
  ADD KEY `fk_facture_client` (`client`);

--
-- Index pour la table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id_type`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id_utilisateur`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `activite_journaliere`
--
ALTER TABLE `activite_journaliere`
  MODIFY `id_activite_journaliere` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `id_demande` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id_facture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT pour la table `type`
--
ALTER TABLE `type`
  MODIFY `id_type` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id_utilisateur` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `activite_journaliere`
--
ALTER TABLE `activite_journaliere`
  ADD CONSTRAINT `fk_activite_journaliere_client` FOREIGN KEY (`client`) REFERENCES `client` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_activite_journaliere_type` FOREIGN KEY (`type`) REFERENCES `type` (`id_type`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `fk_demande_client` FOREIGN KEY (`client`) REFERENCES `client` (`id_client`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_demande_type` FOREIGN KEY (`type`) REFERENCES `type` (`id_type`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `fk_facture_client` FOREIGN KEY (`client`) REFERENCES `client` (`id_client`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
