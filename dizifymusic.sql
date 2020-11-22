-- phpMyAdmin SQL Dump
-- version 4.9.7deb1~bpo10+1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : Dim 22 nov. 2020 à 19:37
-- Version du serveur :  10.3.25-MariaDB-0+deb10u1
-- Version de PHP : 7.3.19-1~deb10u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `dizifymusic`
--
CREATE DATABASE IF NOT EXISTS `dizifymusic` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dizifymusic`;

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `id` bigint(20) NOT NULL,
  `email_user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`id`, `email_user`) VALUES
(2, 'admin@admin.fr'),
(1, 'test@test.fr');

-- --------------------------------------------------------

--
-- Structure de la table `album`
--

CREATE TABLE `album` (
  `id` int(11) NOT NULL,
  `annee` int(11) DEFAULT NULL,
  `entitled` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `id_artist` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `album`
--

INSERT INTO `album` (`id`, `annee`, `entitled`, `image`, `id_artist`) VALUES
(1, 2013, 'Løve', '104', 1),
(2, 2020, 'J’aime le le vin', '105', 23);

-- --------------------------------------------------------

--
-- Structure de la table `artist`
--

CREATE TABLE `artist` (
  `id` int(11) NOT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `annee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `artist`
--

INSERT INTO `artist` (`id`, `alias`, `avatar`, `annee`) VALUES
(1, 'Julien Dioré', '99', 2020),
(4, 'Mie', '2', 5),
(13, 'Moe', '3', 2020),
(15, 'CorCor', '4', 2005),
(22, 'Alias', '5', 0),
(23, 'JM Bigard', '6', 1954),
(24, 'Jennifer', '7', 1800),
(25, 'Android user', '78', 1000);

-- --------------------------------------------------------

--
-- Structure de la table `favoris`
--

CREATE TABLE `favoris` (
  `id` int(11) NOT NULL,
  `id_user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `favoris`
--

INSERT INTO `favoris` (`id`, `id_user`) VALUES
(5, 'jmb'),
(4, 'test@test.fr'),
(6, 'toto@toto.fr');

-- --------------------------------------------------------

--
-- Structure de la table `playlist`
--

CREATE TABLE `playlist` (
  `id` int(11) NOT NULL,
  `id_user` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `playlist`
--

INSERT INTO `playlist` (`id`, `id_user`, `nom`, `image`) VALUES
(2, 'toto@toto.fr', 'sssd', '203'),
(3, 'toto@toto.fr', 'Play!', '204'),
(5, 'toto@toto.fr', 'Zefedfdsfsdds', '205'),
(6, 'toto@toto.fr', 'Sddssdsdssddqssqqdsqdqsdqsd', '206'),
(9, 'Up@up.fr', 'Tes', '306');

-- --------------------------------------------------------

--
-- Structure de la table `title`
--

CREATE TABLE `title` (
  `id` int(11) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `duree` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `id_album` int(11) DEFAULT NULL,
  `id_artist` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `title`
--

INSERT INTO `title` (`id`, `designation`, `duree`, `image`, `id_album`, `id_artist`) VALUES
(1, ' Je suis Debout', 200, '87', NULL, 1),
(2, 'Moi, lolita', 200, '88', 2, 23),
(4, 'FreezeRahel', 299, '89', 1, 15),
(5, 'Moi Président', 1, '100', NULL, 23);

-- --------------------------------------------------------

--
-- Structure de la table `t_favoris_album`
--

CREATE TABLE `t_favoris_album` (
  `id_favoris` int(11) NOT NULL,
  `id_album` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `t_favoris_album`
--

INSERT INTO `t_favoris_album` (`id_favoris`, `id_album`) VALUES
(4, 2),
(6, 2);

-- --------------------------------------------------------

--
-- Structure de la table `t_favoris_artist`
--

CREATE TABLE `t_favoris_artist` (
  `id_favoris` int(11) NOT NULL,
  `id_artist` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `t_favoris_artist`
--

INSERT INTO `t_favoris_artist` (`id_favoris`, `id_artist`) VALUES
(4, 1),
(4, 13),
(6, 15),
(4, 22),
(5, 22),
(4, 23),
(6, 25);

-- --------------------------------------------------------

--
-- Structure de la table `t_favoris_title`
--

CREATE TABLE `t_favoris_title` (
  `id_title` int(11) NOT NULL,
  `id_favoris` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `t_favoris_title`
--

INSERT INTO `t_favoris_title` (`id_title`, `id_favoris`) VALUES
(2, 5),
(4, 5),
(2, 6),
(4, 6);

-- --------------------------------------------------------

--
-- Structure de la table `t_playlist_title`
--

CREATE TABLE `t_playlist_title` (
  `id_title` int(11) NOT NULL,
  `id_playlist` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `t_playlist_title`
--

INSERT INTO `t_playlist_title` (`id_title`, `id_playlist`) VALUES
(1, 2),
(1, 3),
(2, 5),
(2, 6);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `email` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `pseudo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`email`, `avatar`, `pseudo`, `password`) VALUES
('admin@admin.fr', NULL, 'admin', '$2a$10$1/qJpC4IeTsRWHE7j115MeleNmTBZjwvSRTUOHUnl1fjt.EeHDLV.'),
('cle@cle.fr', NULL, 'cle', '$2y$10$JjNjeXFvMJRwpcnLT57GcObH5fFQUBEvHWX7cjHRxsBLxaimcYByC'),
('gtgt@gtgt.fr', '433', 'gtgt', '$2a$10$tNZIVEFfnr7ito4z0TT00OS/SfvKbRpO8PVmXkjLUCI4b4I8EQD7S'),
('jmb', '', 'JMB', '$2y$10$yy37Dw7ia5y3shsaEuGnIe5xc7XCm1gOYwR/uRsxGOaJ8hNvj7xfG'),
('momo@momo.fr', '211', 'momo', NULL),
('test@test.fr', '', 'TestUser', '$2a$10$XxMvb.FMFnHb0VGkVifWWumRKBgPQv6AzPfeFyp69NbkFiV/NH6r6'),
('toto@toto.fr', '900', 'toto titles', '$2y$10$un0YXarkMGlU5kMd9SbrRe9T96yXoACPyMobIc1KGviQu.alWV.yS'),
('Up@up.fr', NULL, 'Up', '$2a$10$IYCIn6sSf7uThDzxLKGVSOzFXuxAuURuUCFXLfOoNR6iPEiiy6jz6');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKotapmj5nf7ek0eb25lvp9a31l` (`email_user`);

--
-- Index pour la table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl3bqdt5k2t9yt6tkbf5jsqo9w` (`id_artist`);

--
-- Index pour la table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `favoris`
--
ALTER TABLE `favoris`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfp6rnjup48fxwf07k4gx38a5e` (`id_user`);

--
-- Index pour la table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo9wdmdfvwr0chfx6kdf64yrf7` (`id_user`);

--
-- Index pour la table `title`
--
ALTER TABLE `title`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgxf2hepjgfrddy5x0lj3dm2tf` (`id_album`),
  ADD KEY `FKd66tdwampnt7i3krob0uf7vqh` (`id_artist`);

--
-- Index pour la table `t_favoris_album`
--
ALTER TABLE `t_favoris_album`
  ADD PRIMARY KEY (`id_album`,`id_favoris`),
  ADD KEY `FKfd0usa7l0mnxcw93i8vt4xb59` (`id_favoris`);

--
-- Index pour la table `t_favoris_artist`
--
ALTER TABLE `t_favoris_artist`
  ADD PRIMARY KEY (`id_artist`,`id_favoris`),
  ADD KEY `FK8pfno90b0o2gngplbldr4lh2s` (`id_favoris`);

--
-- Index pour la table `t_favoris_title`
--
ALTER TABLE `t_favoris_title`
  ADD PRIMARY KEY (`id_favoris`,`id_title`),
  ADD KEY `FKr02tkyj4kewg5xctatgw62mht` (`id_title`);

--
-- Index pour la table `t_playlist_title`
--
ALTER TABLE `t_playlist_title`
  ADD PRIMARY KEY (`id_playlist`,`id_title`),
  ADD KEY `FKjtcex254xt4fveivo6e2bu2eg` (`id_title`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `album`
--
ALTER TABLE `album`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `artist`
--
ALTER TABLE `artist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `favoris`
--
ALTER TABLE `favoris`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `title`
--
ALTER TABLE `title`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD CONSTRAINT `FKotapmj5nf7ek0eb25lvp9a31l` FOREIGN KEY (`email_user`) REFERENCES `user` (`email`);

--
-- Contraintes pour la table `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `FKl3bqdt5k2t9yt6tkbf5jsqo9w` FOREIGN KEY (`id_artist`) REFERENCES `artist` (`id`);

--
-- Contraintes pour la table `favoris`
--
ALTER TABLE `favoris`
  ADD CONSTRAINT `FKfp6rnjup48fxwf07k4gx38a5e` FOREIGN KEY (`id_user`) REFERENCES `user` (`email`);

--
-- Contraintes pour la table `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `FKo9wdmdfvwr0chfx6kdf64yrf7` FOREIGN KEY (`id_user`) REFERENCES `user` (`email`);

--
-- Contraintes pour la table `title`
--
ALTER TABLE `title`
  ADD CONSTRAINT `FKd66tdwampnt7i3krob0uf7vqh` FOREIGN KEY (`id_artist`) REFERENCES `artist` (`id`),
  ADD CONSTRAINT `FKgxf2hepjgfrddy5x0lj3dm2tf` FOREIGN KEY (`id_album`) REFERENCES `album` (`id`);

--
-- Contraintes pour la table `t_favoris_album`
--
ALTER TABLE `t_favoris_album`
  ADD CONSTRAINT `FK5dvihliy98dm574990wjcspkr` FOREIGN KEY (`id_album`) REFERENCES `album` (`id`),
  ADD CONSTRAINT `FKfd0usa7l0mnxcw93i8vt4xb59` FOREIGN KEY (`id_favoris`) REFERENCES `favoris` (`id`);

--
-- Contraintes pour la table `t_favoris_artist`
--
ALTER TABLE `t_favoris_artist`
  ADD CONSTRAINT `FK1i1oeepfnq43l6s9v53v048f4` FOREIGN KEY (`id_artist`) REFERENCES `artist` (`id`),
  ADD CONSTRAINT `FK8pfno90b0o2gngplbldr4lh2s` FOREIGN KEY (`id_favoris`) REFERENCES `favoris` (`id`);

--
-- Contraintes pour la table `t_favoris_title`
--
ALTER TABLE `t_favoris_title`
  ADD CONSTRAINT `FK33vqrxj6ekqtovhh86lyjkrlg` FOREIGN KEY (`id_favoris`) REFERENCES `favoris` (`id`),
  ADD CONSTRAINT `FKr02tkyj4kewg5xctatgw62mht` FOREIGN KEY (`id_title`) REFERENCES `title` (`id`);

--
-- Contraintes pour la table `t_playlist_title`
--
ALTER TABLE `t_playlist_title`
  ADD CONSTRAINT `FKj08y2y2874g5nr1lsedp39prc` FOREIGN KEY (`id_playlist`) REFERENCES `playlist` (`id`),
  ADD CONSTRAINT `FKjtcex254xt4fveivo6e2bu2eg` FOREIGN KEY (`id_title`) REFERENCES `title` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
