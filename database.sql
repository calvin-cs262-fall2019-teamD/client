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
DROP TABLE IF EXISTS Leaderboard;


CREATE TABLE Leaderboard (
	ID integer PRIMARY KEY,
	time timestamp
	);

CREATE TABLE Player (
	ID integer PRIMARY KEY,
	name varchar(35) NOT NULL,
	elo integer,
	location integer,
	UNIQUE (elo, location)
	);

CREATE TABLE Game (
	leaderboardID integer REFERENCES Leaderboard(ID),
	player1ID integer REFERENCES Player(ID),
	player2ID integer REFERENCES Player(ID),
	player1location integer REFERENCES Player(location),
	player2location integer REFERENCES Player(location),
	UNIQUE(player1ID, player2ID),
	time timestamp,
	score float
	);

--
GRANT SELECT ON Leaderboard TO PUBLIC;
GRANT SELECT ON Player TO PUBLIC;
GRANT SELECT ON Game TO PUBLIC;


INSERT INTO Leaderboard VALUES (1, '2019-05-24 08:00:00');


INSERT INTO Player VALUES (1, 'Allen', 645523, 6);
INSERT INTO Player VALUES (2, 'Ben', 445523, 7);

INSERT INTO Game VALUES (1, 1, 2, 6, 7, '2019-05-26 10:00:00', 19.21)
