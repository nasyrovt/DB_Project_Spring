CREATE TABLE `client_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_station` (
  `station_id` bigint NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `classification` int DEFAULT NULL,
  PRIMARY KEY (`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_client` (
  `client_id` bigint NOT NULL AUTO_INCREMENT,
  `code_secret` varchar(255) DEFAULT NULL,
  `numero_cb` bigint DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=303 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_velo` (
  `velo_id` bigint NOT NULL AUTO_INCREMENT,
  `etat_de_velo` int DEFAULT NULL,
  `date_de_mise_en_service` datetime DEFAULT NULL,
  `nom_du_modele` varchar(255) DEFAULT NULL,
  `prix_du_modele` float DEFAULT NULL,
  `numero_de_puce` int NOT NULL,
  PRIMARY KEY (`velo_id`),
  UNIQUE KEY `puce_unique` (`numero_de_puce`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_abonne` (
  `abonne_id` bigint NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `date_den` datetime DEFAULT NULL,
  `date_debut_abonnement` datetime DEFAULT NULL,
  `date_end_abonnement` datetime DEFAULT NULL,
  `final_reduction` float DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `prime` float DEFAULT NULL,
  `sexe` int DEFAULT NULL,
  PRIMARY KEY (`abonne_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_bornette` (
  `bornette_id` bigint NOT NULL AUTO_INCREMENT,
  `etat_bornette` int DEFAULT NULL,
  `station_mere` bigint DEFAULT NULL,
  `current_velo` bigint DEFAULT NULL,
  `tbl_bornettecol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bornette_id`),
  KEY `FK5emwhr8pf64n7iprdoivi9u3x` (`station_mere`),
  KEY `FK_Velo_idx` (`current_velo`),
  CONSTRAINT `FK5emwhr8pf64n7iprdoivi9u3x` FOREIGN KEY (`station_mere`) REFERENCES `tbl_station` (`station_id`),
  CONSTRAINT `FK_Velo` FOREIGN KEY (`current_velo`) REFERENCES `tbl_velo` (`velo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_location` (
  `location_id` bigint NOT NULL AUTO_INCREMENT,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `station_arrive` bigint DEFAULT NULL,
  `station_depart` bigint DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `velo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`location_id`),
  KEY `FKs5qxj7u1qaxe5ufcc4chyn82q` (`station_arrive`),
  KEY `FK_id_client_idx` (`client_id`),
  KEY `FK_id_velo_idx` (`velo_id`),
  KEY `FKbgoi8k6rh01dsy5p3wgjuobvo` (`station_depart`),
  CONSTRAINT `FKbgoi8k6rh01dsy5p3wgjuobvo` FOREIGN KEY (`station_depart`) REFERENCES `tbl_station` (`station_id`),
  CONSTRAINT `FKip5a7ufcu0rl1ximw4wcj0urr` FOREIGN KEY (`client_id`) REFERENCES `tbl_client` (`client_id`),
  CONSTRAINT `FKlmb5ix40l38d1blbm4csea9eb` FOREIGN KEY (`velo_id`) REFERENCES `tbl_velo` (`velo_id`),
  CONSTRAINT `FKs5qxj7u1qaxe5ufcc4chyn82q` FOREIGN KEY (`station_arrive`) REFERENCES `tbl_station` (`station_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


