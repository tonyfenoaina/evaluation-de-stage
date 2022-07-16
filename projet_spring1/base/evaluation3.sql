


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
	CONSTRAINT pk_pfvirtuelle_0 PRIMARY KEY ( id )
 );

CREATE  TABLE "public".pfvirtuelle ( 
	id                   integer  NOT NULL  ,
	idclient             integer    ,
	montant              double precision    ,
	CONSTRAINT pk_pfvirtuelle PRIMARY KEY ( id )
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
	CONSTRAINT amende_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".amendepaye ( 
	id                   integer  NOT NULL  ,
	idamende             integer    ,
	idclient             integer    ,
	CONSTRAINT amende_paye_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".reservation ( 
	id                   integer  NOT NULL  ,
	datedebut            timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL  ,
	idparking            integer    ,
	idvehicule           varchar(20)    ,
	idtarif              integer    ,
	idclient             integer    ,
	CONSTRAINT reservation_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".sortie ( 
	id                   integer  NOT NULL  ,
	idreservation        integer    ,
	CONSTRAINT sortie_pkey PRIMARY KEY ( id )
 );

ALTER TABLE "public".amende ADD CONSTRAINT fk_amende_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id );

ALTER TABLE "public".amendepaye ADD CONSTRAINT fk_amendepaye_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id );

ALTER TABLE "public".pfvalide ADD CONSTRAINT fk_pfvalide_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id );

ALTER TABLE "public".pfvirtuelle ADD CONSTRAINT fk_pfvirtuelle_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id );

ALTER TABLE "public".reservation ADD CONSTRAINT fk_reservation_client FOREIGN KEY ( idclient ) REFERENCES "public".client( id );

ALTER TABLE "public".reservation ADD CONSTRAINT fk_reservation_parking FOREIGN KEY ( idparking ) REFERENCES "public".parking( id );

ALTER TABLE "public".reservation ADD CONSTRAINT fk_reservation_tarif FOREIGN KEY ( idtarif ) REFERENCES "public".tarif( id );

ALTER TABLE "public".sortie ADD CONSTRAINT fk_sortie_reservation FOREIGN KEY ( idreservation ) REFERENCES "public".reservation( id );

CREATE OR REPLACE view amendenonpayee AS SELECT amende.id AS amende,
    amende.idclient AS id,
    client.nom,
    client.prenom,
    amende.montant
   FROM ((amende
     JOIN client ON ((amende.idclient = client.id)))
     LEFT JOIN amendepaye ON ((amendepaye.idamende = amende.id)))
  WHERE (amendepaye.idamende IS NULL);

CREATE VIEW "public".infosparking AS  SELECT parking.id,
    client.nom,
    client.prenom,
    COALESCE(reservation.id, 0) AS idreservation,
    parking.numero AS numeroparking,
    COALESCE(sortie.idreservation, 0) AS idsortie,
    COALESCE(reservation.idclient, 0) AS idclient,
    COALESCE(reservation.idvehicule, '0'::character varying) AS idvehicule,
    reservation.datedebut,
	reservation.datedebut + tarif.durree as datefin,
	(reservation.datedebut + tarif.durree) - current_timestamp  as delaidepart,
    tarif.durree,
    COALESCE(tarif.montant, (0.0)::double precision) AS montant
   FROM ((((parking
     LEFT JOIN reservation ON ((parking.id = reservation.idparking)))
     LEFT JOIN client ON ((client.id = reservation.idclient)))
     LEFT JOIN sortie ON ((reservation.id = sortie.idreservation)))
     LEFT JOIN tarif ON ((tarif.id = reservation.idtarif)));

CREATE VIEW "public".pfnonvalide AS  SELECT pfvirtuelle.id AS pfvirtuelle,
    pfvirtuelle.idclient AS id,
    client.nom,
    client.prenom,
    pfvirtuelle.montant
   FROM ((pfvirtuelle
     JOIN client ON ((pfvirtuelle.idclient = client.id)))
     LEFT JOIN pfvalide ON ((pfvalide.idpfvirtuel = pfvirtuelle.id)))
  WHERE (pfvalide.idpfvirtuel IS NULL);
    

	CREATE OR REPLACE FUNCTION getDatenow () RETURNS timestamp AS $$
    BEGIN
        return (SELECT datenowvalue from datenow order by id desc limit 1 );
    END;
$$ LANGUAGE plpgsql;





CREATE VIEW ${schema}.${name} AS  SELECT parking.id,
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
  WHERE ((reservation.datedebut < getdatenow()) AND sortie.datesortie is null or sortie.datesortie<getDatenow())
  ORDER BY parking.numero



CREATE VIEW infosparking AS  SELECT parking.id,
    parkingoccupe.nom,
    parkingoccupe.prenom,
	datesortie,
    COALESCE(parkingoccupe.idreservation, 0) AS idreservation,
    parking.numero AS numeroparking,
    coalesce(parkingoccupe.idsortie,0) idsortie,
    COALESCE(parkingoccupe.idclient, 0) AS idclient,
    COALESCE(parkingoccupe.idvehicule, '0'::character varying) AS idvehicule,
    parkingoccupe.datedebut,
    parkingoccupe.datefin,
    parkingoccupe.delaidepart,
    parkingoccupe.durree,
		CASE WHEN datesortie is null then
       	 CASE
        	    WHEN (parkingoccupe.datefin < getdatenow()) THEN 'infraction'::text
         	   WHEN (parkingoccupe.datefin > getdatenow()) THEN 'occupee'::text
          	  ELSE 'libre'::text
			END					
		ELSE
			CASE
        	    WHEN (parkingoccupe.datefin < getdatenow() and getdatenow()<datesortie ) THEN 'infraction'::text
         	   WHEN ( getdatenow()< datesortie  and datesortie<parkingoccupe.datefin) THEN 'occupee'::text
			END
		
        END AS type,
    COALESCE(parkingoccupe.montant, (0.0)::double precision) AS montant
   FROM (parkingoccupe
     RIGHT JOIN parking ON ((parking.id = parkingoccupe.id)))