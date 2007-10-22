-- ****************************************************************************
-- MySQL basic tables creation script.
-- ****************************************************************************

-- *************************************************
-- UserProfile
-- *************************************************

DROP TABLE Usuario CASCADE;
CREATE TABLE Usuario (
	nick VARCHAR(40) NOT NULL,
	password VARCHAR(11) NOT NULL,
        nombre VARCHAR(40) NOT NULL,
	apellido VARCHAR(40) NOT NULL,
        email VARCHAR(40) NOT NULL,
	PRIMARY KEY (nick)
);

