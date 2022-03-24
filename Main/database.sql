drop table TBL_VELO;
drop table TBL_ABONNE;
drop table TBL_CLIENT;
drop table TBL_BORNETTE;
drop table TBL_LOCATION;
drop table TBL_STATION;

create table TBL_VELO
(
    VELO_ID                 NUMBER(3) not null
        constraint PKVELO
            primary key,
    NOM_DU_MODELE           VARCHAR2(20),
    PRIX_DU_MODELE          NUMBER(3),
    ETAT_DE_VELO            VARCHAR2(20),
    DATE_DE_MISE_EN_SERVICE DATE,
    NUMERO_DE_PUCE          NUMBER(3)
);


create table TBL_CLIENT
(
    client_id int
        constraint TBL_CLIENT_PK
            primary key,
    "numero_CB" int not null,
    code_secret varchar2(5) not null
);

create table TBL_ABONNE
(
    abonne_id int
        constraint TABLE_ABONNE_PK
            primary key,
    nom varchar2(30) not null,
    prenom varchar2(30) not null,
    "dateDeN" date not null,
    sexe int not null,
    adresse varchar2(50),
    final_reduction float,
    date_debut_abonnement date not null,
    date_end_abonnement date,
    prime float
);

create table TBL_STATION
(
    STATION_ID     NUMBER(3) not null
        constraint PKSTATION
            primary key,
    ADRESSE        VARCHAR2(20),
    CLASSIFICATION VARCHAR2(20)
);

create table TBL_LOCATION
(
    LOCATION_ID    NUMBER(3) not null
        constraint PKLOCATION
            primary key,
    START_DATE     DATE,
    END_DATE       DATE,
    STATION_DEPART NUMBER(3)
        references TBL_STATION,
    STATION_ARRIVE NUMBER(3)
        references TBL_STATION
);

create table TBL_BORNETTE
(
    BORNETTE_ID   NUMBER(3) not null
        constraint PKBORNETTE
            primary key,
    ETAT_BORNETTE VARCHAR2(20),
    STATION_MERE  NUMBER(3)
        references TBL_STATION
);

