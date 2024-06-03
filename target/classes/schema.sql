DROP TABLE IF EXISTS PLAYLIST_SONGS;
DROP TABLE IF EXISTS SONG_ARTISTS;
DROP TABLE IF EXISTS SONG_GENRES;
DROP TABLE IF EXISTS SONG_MUSIC_BY;
DROP TABLE IF EXISTS ALBUM_ARTISTS;
DROP TABLE IF EXISTS ALBUM_GENRES;
DROP TABLE IF EXISTS SONG;
DROP TABLE IF EXISTS ALBUM;
DROP TABLE IF EXISTS ARTIST;
DROP TABLE IF EXISTS GENRE;
DROP TABLE IF EXISTS MUSICIAN;
DROP TABLE IF EXISTS PLAYLIST;
DROP TABLE IF EXISTS USERS;

CREATE TABLE album (
id bigint NOT NULL AUTO_INCREMENT,
name varchar(255) NOT NULL,
imgurl varchar(255) DEFAULT NULL,
PRIMARY KEY (id),
UNIQUE (name)
);

CREATE TABLE musician (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);



CREATE TABLE artist (
id bigint NOT NULL AUTO_INCREMENT,
age int NOT NULL,
name varchar(255) DEFAULT NULL,
PRIMARY KEY (id)
);


CREATE TABLE genre (
id bigint NOT NULL AUTO_INCREMENT,
name varchar(255) DEFAULT NULL,
PRIMARY KEY (id),
UNIQUE (name)
);

CREATE TABLE song (
id bigint NOT NULL AUTO_INCREMENT,
createdon varchar(255) DEFAULT NULL,
duration float NOT NULL,
likes int NOT NULL,
name varchar(255) DEFAULT NULL,
played int NOT NULL,
releaseyear int NOT NULL,
album_id bigint DEFAULT NULL,
imgurl varchar(255) DEFAULT NULL,
downloadlink128kbps varchar(255) DEFAULT NULL,
downloadlink320kbps varchar(255) DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (album_id) REFERENCES album (id)
);


CREATE TABLE song_artists (
song_id bigint NOT NULL,
artist_id bigint NOT NULL,
FOREIGN KEY (artist_id) REFERENCES artist (id),
FOREIGN KEY (song_id) REFERENCES song (id)
);


CREATE INDEX song_artists_artist_id ON song_artists (artist_id);
CREATE INDEX song_artists_song_id ON song_artists (song_id);


CREATE TABLE song_genres (
song_id bigint NOT NULL,
genre_id bigint NOT NULL,
FOREIGN KEY (genre_id) REFERENCES genre (id),
FOREIGN KEY (song_id) REFERENCES song (id)
);

CREATE INDEX song_genres_genre_id ON song_genres (genre_id);
CREATE INDEX song_genres_song_id ON song_genres (song_id);


CREATE TABLE album_artists (
album_id bigint NOT NULL,
artist_id bigint NOT NULL,
FOREIGN KEY (artist_id) REFERENCES artist (id),
FOREIGN KEY (album_id) REFERENCES album (id)
);
  
CREATE INDEX album_artists_artist_id ON album_artists (artist_id);
CREATE INDEX album_artists_album_id ON album_artists (album_id);


CREATE TABLE album_genres (
album_id bigint NOT NULL,
genre_id bigint NOT NULL,
FOREIGN KEY (genre_id) REFERENCES genre (id),
FOREIGN KEY (album_id) REFERENCES album (id)
);

CREATE TABLE song_music_by (
    song_id bigint NOT NULL,
    musician_id bigint NOT NULL,
    FOREIGN KEY (musician_id) REFERENCES musician (id),
    FOREIGN KEY (song_id) REFERENCES song (id)
);

CREATE INDEX song_music_by_musician_id ON song_music_by (musician_id);
CREATE INDEX song_music_by_song_id ON song_music_by (song_id);


CREATE INDEX album_genres_genre_id ON album_genres (genre_id);
CREATE INDEX album_genres_album_id ON album_genres (album_id);



CREATE TABLE playlist (
id bigint NOT NULL AUTO_INCREMENT,
name varchar(255) DEFAULT NULL,
PRIMARY KEY (id),
UNIQUE (name)
);



CREATE TABLE users (
id bigint NOT NULL AUTO_INCREMENT,
dob varchar(255) DEFAULT NULL,
fname varchar(255) DEFAULT NULL,
lname varchar(255) DEFAULT NULL,
email varchar(255) DEFAULT NULL,
gender varchar(255) DEFAULT NULL,
password varchar(255) NOT NULL,
username varchar(255) NOT NULL,
phoneno bigint NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username),
    UNIQUE (phoneno),
    UNIQUE (email)
)


