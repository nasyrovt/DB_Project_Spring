CREATE TABLE tbl_abonne (
                            abonne_id int NOT NULL,
                            nom varchar(45) NOT NULL,
                            prenom varchar(35) NOT NULL,
                            dateDeN datetime NOT NULL,
                            sexe int NOT NULL,
                            adresse varchar(50) NOT NULL,
                            final_reduction float NOT NULL,
                            date_debut_abonnement datetime NOT NULL,
                            date_end_abonnement datetime NOT NULL,
                            prime float DEFAULT NULL,
                            abonneId bigint NOT NULL,
                            date_den datetime(6) DEFAULT NULL,
                            PRIMARY KEY (abonne_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE tbl_station (
                             station_id int NOT NULL,
                             adresse varchar(50) NOT NULL,
                             calssidication varchar(35) NOT NULL,
                             classification int DEFAULT NULL,
                             PRIMARY KEY (station_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE tbl_bornette (
                              bornette_id int NOT NULL,
                              etat_bornette varchar(35) NOT NULL,
                              station_mere int NOT NULL,
                              bornetteId bigint NOT NULL,
                              PRIMARY KEY (bornette_id),
    KEY fk_station_mere_idx (station_mere),
    CONSTRAINT fk_station_mere FOREIGN KEY (station_mere) REFERENCES tbl_station (station_id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE tbl_client (
                            client_id int NOT NULL,
                            numero_cb int NOT NULL,
                            code_secret varchar(45) DEFAULT NULL,
                            PRIMARY KEY (client_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE tbl_location (
                              location_id int NOT NULL,
                              start_date datetime NOT NULL,
                              end_date datetime NOT NULL,
                              station_depart int NOT NULL,
                              station_arrive int DEFAULT NULL,
                              PRIMARY KEY (location_id),
    KEY fk_station_depart_idx (station_depart),
    KEY fk_station_arrive_idx (station_arrive),
    CONSTRAINT fk_station_arrive FOREIGN KEY (station_arrive) REFERENCES tbl_station (station_id),
    CONSTRAINT fk_station_depart FOREIGN KEY (station_depart) REFERENCES tbl_station (station_id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE tbl_velo (
                          velo_id int NOT NULL,
                          nom_du_modele varchar(45) NOT NULL,
                          prix_du_modele float NOT NULL,
                          etat_de_velo varchar(45) NOT NULL,
                          date_de_mise_en_service datetime NOT NULL,
                          numero_de_puce int NOT NULL,
                          veloId bigint NOT NULL,
                          PRIMARY KEY (velo_id),
                          UNIQUE KEY puce_unique (numero_de_puce)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;