CREATE SEQUENCE "public".hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_admins START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_chauffeur START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_client START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_types START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_types_vehicule START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".seq_vehicule START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".admins ( 
	id                   integer  NOT NULL  ,
	nom                  varchar(30)  NOT NULL  ,
	prenom               varchar(100)    ,
	email                varchar(25)    ,
	mdp                  varchar(100)    ,
	CONSTRAINT admins_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".client ( 
	id                   integer  NOT NULL  ,
	nom                  varchar(30)  NOT NULL  ,
	prenom               varchar(100)    ,
	email                varchar(25)    ,
	mdp                  varchar(100)    ,
	CONSTRAINT admins_pkey_0 PRIMARY KEY ( id )
 );

CREATE  TABLE "public".datenow ( 
	id                   integer  NOT NULL  ,
	datenowvalue         timestamp    ,
	etat                 varchar(255)    ,
	CONSTRAINT datenow_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".historique ( 
	id                   integer  NOT NULL  ,
	datedebut            timestamp    ,
	datefin              timestamp    ,
	delaidepart          varchar(255)    ,
	durree               time    ,
	idclient             integer    ,
	idreservation        integer    ,
	idsortie             integer    ,
	idvehicule           varchar(255)    ,
	montant              double precision    ,
	nom                  varchar(255)    ,
	numeroparking        integer    ,
	prenom               varchar(255)    ,
	CONSTRAINT historique_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".parking ( 
	id                   integer  NOT NULL  ,
	taille               double precision    ,
	numero               integer    ,
	CONSTRAINT parking_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".pfvalide ( 
	id                   integer  NOT NULL  ,
	idclient             integer    ,
	montant              double precision    ,
	idpfvirtuel          integer    ,
	CONSTRAINT pk_pfvirtuelle_0 PRIMARY KEY ( id ),
	CONSTRAINT fk_pfvalide_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id )   
 );

CREATE  TABLE "public".pfvirtuelle ( 
	id                   integer  NOT NULL  ,
	idclient             integer    ,
	montant              double precision    ,
	CONSTRAINT pk_pfvirtuelle PRIMARY KEY ( id ),
	CONSTRAINT fk_pfvirtuelle_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id )   
 );

CREATE  TABLE "public".tarif ( 
	id                   integer  NOT NULL  ,
	durree               time    ,
	montant              double precision    ,
	CONSTRAINT tarif_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".amende ( 
	id                   integer  NOT NULL  ,
	idclient             integer    ,
	montant              double precision    ,
	CONSTRAINT amende_pkey PRIMARY KEY ( id ),
	CONSTRAINT fk_amende_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id )   
 );

CREATE  TABLE "public".amendepaye ( 
	id                   integer  NOT NULL  ,
	idamende             integer    ,
	idclient             integer    ,
	CONSTRAINT amende_paye_pkey PRIMARY KEY ( id ),
	CONSTRAINT fk_amendepaye_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id )   
 );

CREATE  TABLE "public".reservation ( 
	id                   integer  NOT NULL  ,
	datedebut            timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	idparking            integer    ,
	idvehicule           varchar(20)    ,
	idtarif              integer    ,
	idclient             integer    ,
	CONSTRAINT reservation_pkey PRIMARY KEY ( id ),
	CONSTRAINT fk_reservation_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id )   ,
	CONSTRAINT fk_reservation_parking FOREIGN KEY ( idparking ) REFERENCES "public".parking( id )   ,
	CONSTRAINT fk_reservation_tarif FOREIGN KEY ( idtarif ) REFERENCES "public".tarif( id )   
 );

CREATE  TABLE "public".sortie ( 
	id                   integer  NOT NULL  ,
	idreservation        integer    ,
	datesortie           timestamp    ,
	CONSTRAINT sortie_pkey PRIMARY KEY ( id ),
	CONSTRAINT fk_sortie_reservation FOREIGN KEY ( idreservation ) REFERENCES "public".reservation( id )   
 );

CREATE OR REPLACE FUNCTION public.getdatenow()
 RETURNS timestamp without time zone
 LANGUAGE plpgsql
AS $function$
    BEGIN
        return (SELECT datenowvalue from datenow order by id desc limit 1 );
    END;
$function$
;

CREATE VIEW "public".amendenonpayee AS  SELECT amende.id AS amende,
    amende.idclient AS id,
    client.nom,
    client.prenom,
    amende.montant
   FROM ((amende
     JOIN client ON ((amende.idclient = client.id)))
     LEFT JOIN amendepaye ON ((amendepaye.idamende = amende.id)))
  WHERE (amendepaye.idamende IS NULL);

CREATE VIEW "public".infosparking AS  SELECT parking.id,
    parkingoccupe.nom,
    parkingoccupe.prenom,
    parkingoccupe.datesortie,
    COALESCE(parkingoccupe.idreservation, 0) AS idreservation,
    parking.numero AS numeroparking,
    COALESCE(parkingoccupe.idsortie, 0) AS idsortie,
    COALESCE(parkingoccupe.idclient, 0) AS idclient,
    COALESCE(parkingoccupe.idvehicule, '0'::character varying) AS idvehicule,
    parkingoccupe.datedebut,
    parkingoccupe.datefin,
    parkingoccupe.delaidepart,
    parkingoccupe.durree,
        CASE
            WHEN (parkingoccupe.datesortie IS NULL) THEN
            CASE
                WHEN (parkingoccupe.datefin < getdatenow()) THEN 'infraction'::text
                WHEN (parkingoccupe.datefin > getdatenow()) THEN 'occupee'::text
                ELSE 'libre'::text
            END
            ELSE
            CASE
                WHEN ((parkingoccupe.datefin < getdatenow()) AND (getdatenow() < parkingoccupe.datesortie)) THEN 'infraction'::text
                WHEN ((getdatenow() < parkingoccupe.datesortie) AND (parkingoccupe.datesortie < parkingoccupe.datefin)) THEN 'occupee'::text
                ELSE NULL::text
            END
        END AS type,
    COALESCE(parkingoccupe.montant, (0.0)::double precision) AS montant
   FROM (parkingoccupe
     RIGHT JOIN parking ON ((parking.id = parkingoccupe.id)))
  ORDER BY parking.numero;

CREATE VIEW "public".parkingoccupe AS  SELECT parking.id,
    client.nom,
    client.prenom,
    sortie.datesortie,
    COALESCE(reservation.id, 0) AS idreservation,
    parking.numero AS numeroparking,
    COALESCE(sortie.idreservation, 0) AS idsortie,
    COALESCE(reservation.idclient, 0) AS idclient,
    COALESCE(reservation.idvehicule, '0'::character varying) AS idvehicule,
    reservation.datedebut,
    (reservation.datedebut + (tarif.durree)::interval) AS datefin,
    (((reservation.datedebut + (tarif.durree)::interval))::timestamp with time zone - CURRENT_TIMESTAMP) AS delaidepart,
    tarif.durree,
    COALESCE(tarif.montant, (0.0)::double precision) AS montant
   FROM ((((parking
     JOIN reservation ON ((parking.id = reservation.idparking)))
     LEFT JOIN client ON ((client.id = reservation.idclient)))
     LEFT JOIN sortie ON ((reservation.id = sortie.idreservation)))
     LEFT JOIN tarif ON ((tarif.id = reservation.idtarif)))
  WHERE (((reservation.datedebut < getdatenow()) AND (sortie.datesortie IS NULL)) OR (sortie.datesortie < getdatenow()))
  ORDER BY parking.numero;

CREATE VIEW "public".pfnonvalide AS  SELECT pfvirtuelle.id AS pfvirtuelle,
    pfvirtuelle.idclient AS id,
    client.nom,
    client.prenom,
    pfvirtuelle.montant
   FROM ((pfvirtuelle
     JOIN client ON ((pfvirtuelle.idclient = client.id)))
     LEFT JOIN pfvalide ON ((pfvalide.idpfvirtuel = pfvirtuelle.id)))
  WHERE (pfvalide.idpfvirtuel IS NULL);

INSERT INTO "public".admins( id, nom, prenom, email, mdp ) VALUES ( 1, 'Randria', 'Tony', 'tony@gmail.com', 'root');
INSERT INTO "public".client( id, nom, prenom, email, mdp ) VALUES ( 189, 'Rakoto', 'cdscdscdsv', 'rakoto@kaly.com', 'root');
INSERT INTO "public".client( id, nom, prenom, email, mdp ) VALUES ( 195, 'tony', 'fenoaina', 'tony@gmail.com', 'root');
INSERT INTO "public".client( id, nom, prenom, email, mdp ) VALUES ( 196, 'tony', 'fenoaina', 'tony@gmail.com', 'root');
INSERT INTO "public".client( id, nom, prenom, email, mdp ) VALUES ( 198, 'Ony', 'Tiana', 'Ony@gmail.com', 'root');
INSERT INTO "public".client( id, nom, prenom, email, mdp ) VALUES ( 341, 'Rakoto', 'Test', 'rakototest@gmail.com', 'root');
INSERT INTO "public".datenow( id, datenowvalue, etat ) VALUES ( 294, '2022-07-16 12:29:00 AM', 'miakatra');
INSERT INTO "public".datenow( id, datenowvalue, etat ) VALUES ( 301, '2022-07-16 12:00:00 PM', 'miakatra');
INSERT INTO "public".datenow( id, datenowvalue, etat ) VALUES ( 307, '2022-07-16 07:27:00 PM', 'miakatra');
INSERT INTO "public".datenow( id, datenowvalue, etat ) VALUES ( 340, '2022-07-16 08:00:00 AM', 'miakatra');
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 304, 1.0, 1);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 316, 2.0, 2);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 317, 3.0, 3);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 318, 4.0, 4);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 319, 5.0, 5);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 320, 6.0, 6);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 321, 7.0, 7);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 322, 8.0, 8);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 323, 9.0, 9);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 324, 10.0, 10);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 325, 11.0, 11);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 326, 12.0, 12);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 327, 13.0, 13);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 328, 14.0, 14);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 329, 15.0, 15);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 330, 16.0, 16);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 331, 17.0, 17);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 332, 18.0, 18);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 333, 19.0, 19);
INSERT INTO "public".parking( id, taille, numero ) VALUES ( 334, 20.0, 20);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 191, 189, 5000.0, 190);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 200, 198, 5000.0, 199);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 233, 198, 2000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 235, 198, 5000.0, 234);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 238, 198, 5000.0, 234);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 239, 198, 5000.0, 236);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 240, 198, 3000.0, 237);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 242, 198, 6000.0, 237);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 243, 198, 11000.0, 241);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 245, 198, 16000.0, 241);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 246, 198, 17000.0, 244);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 248, 198, 18000.0, 244);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 249, 189, 10000.0, 247);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 251, 189, 15000.0, 247);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 252, 198, 19000.0, 250);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 254, 198, 16000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 256, 189, 12000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 258, 198, 13000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 260, 198, 10000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 279, 198, 7000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 281, 189, 9000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 283, 198, 4000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 286, 198, 1000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 291, 198, 1.00001E8, 290);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 293, 198, 9.9998E7, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 298, 198, 9.9995E7, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 300, 198, 9.9992E7, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 303, 198, 9.9989E7, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 306, 198, 9.9986E7, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 309, 198, 9.9983E7, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 311, 198, 9.998E7, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 344, 341, 20000.0, 343);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 346, 341, 5000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 348, 341, 20000.0, 347);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 350, 341, 5000.0, 0);
INSERT INTO "public".pfvalide( id, idclient, montant, idpfvirtuel ) VALUES ( 352, 341, 2000.0, 0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 190, 189, 5000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 199, 198, 5000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 234, 198, 5000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 236, 198, 5000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 237, 198, 3000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 241, 198, 5000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 244, 198, 1000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 247, 189, 5000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 250, 198, 1000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 290, 198, 1.0E8);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 343, 341, 20000.0);
INSERT INTO "public".pfvirtuelle( id, idclient, montant ) VALUES ( 347, 341, 15000.0);
INSERT INTO "public".tarif( id, durree, montant ) VALUES ( 335, '00:30:00', 7000.0);
INSERT INTO "public".tarif( id, durree, montant ) VALUES ( 336, '01:00:00', 15000.0);
INSERT INTO "public".tarif( id, durree, montant ) VALUES ( 337, '02:00:00', 22500.0);
INSERT INTO "public".tarif( id, durree, montant ) VALUES ( 338, '00:15:00', 3000.0);
INSERT INTO "public".reservation( id, datedebut, idparking, idvehicule, idtarif, idclient ) VALUES ( 349, '2022-07-16 08:15:00 AM', 304, '1234TAB', 336, 341);
INSERT INTO "public".reservation( id, datedebut, idparking, idvehicule, idtarif, idclient ) VALUES ( 351, '2022-07-16 08:47:00 AM', 316, '3455TBB', 338, 341);