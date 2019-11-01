--
-- This SQL script models a potential database schema for Pandab's Snappong application.
--
--
--
--
--

-- Drop previous versions of the tables if they exist, in reverse order of foreign keys
DROP TABLE IF EXISTS Game;
DROP TABLE IF EXISTS Player;

CREATE TABLE Player (
	ID integer PRIMARY KEY,
	name varchar(35) NOT NULL,
	elo integer,
	location integer
	);

CREATE TABLE Game (
	player1ID integer NOT NULL UNIQUE REFERENCES Player(ID),
	player2ID integer NOT NULL UNIQUE REFERENCES Player(ID),
	time timestamp,
	score float
	);

--

GRANT SELECT ON Player TO PUBLIC;
GRANT SELECT ON Game TO PUBLIC;


INSERT INTO Player VALUES (1, 'Allen', 645523, 6);
INSERT INTO Player VALUES (2, 'Ben', 445523, 7);
INSERT INTO Game VALUES (1, 2, '2019-05-26 10:00:00', 19.21);

SELECT location FROM Player;
SELECT score FROM Game;
