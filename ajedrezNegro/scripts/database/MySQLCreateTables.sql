-- ****************************************************************************
-- PostgreSQL basic tables creation script.
-- ****************************************************************************

-- *************************************************
-- Table for ping queries from the connection pool.
-- *************************************************

DROP TABLE PingTable;
CREATE TABLE PingTable (foo CHAR(1));

-- *************************************************
-- UserProfile
-- *************************************************

DROP TABLE usuario CASCADE;
CREATE TABLE usuario (
	nick VARCHAR(40) NOT NULL,
	password VARCHAR(11) NOT NULL,
        nombre VARCHAR(40) NOT NULL,
	apellido VARCHAR(40) NOT NULL,
        email VARCHAR(40) NOT NULL,
	PRIMARY KEY (nick)
);

