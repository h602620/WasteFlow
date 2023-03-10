DROP TABLE IF EXISTS fest;
CREATE TABLE fest
(
    mobilnummer integer NOT NULL UNIQUE PRIMARY KEY,
    fornavn VARCHAR(20) NOT NULL,
    etternavn VARCHAR(20) NOT NULL,
    kjonn char(1) NOT NULL,
    passord VARCHAR NOT NULL,

    constraint valid_number
        check (mobilnummer <= 99999999)


);