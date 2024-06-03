package com.api.music.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="SONG_ARTISTS", uniqueConstraints = @UniqueConstraint(columnNames = {"song_id", "artist_id"}))
public class SongArtists {

    long song_id;
    long artist_id;
}
