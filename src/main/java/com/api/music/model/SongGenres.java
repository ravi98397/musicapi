package com.api.music.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name="SONG_GENRES", uniqueConstraints = @UniqueConstraint(columnNames = {"song_id", "genre_id"}))
@Data
@AllArgsConstructor
public class SongGenres {
    private long song_id;
    private long genre_id;
}
