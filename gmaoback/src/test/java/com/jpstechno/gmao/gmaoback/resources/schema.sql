CREATE TABLE materiels(
    id bigint primary key AUTO_INCREMENT,
    codeinterne varchar(50),
    categorie bigint,
    appelation varchar(50),
    marque varchar(50),
    modele varchar(50),
    numeroserie varchar(50),
    description varchar,
    etat varchar(50),
    dateenregistrement datetime
);