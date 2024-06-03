package com.api.music.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name="SONG_MUSIC_BY", uniqueConstraints = @UniqueConstraint(columnNames = {"song_id", "musician_id"}))
@Data
@AllArgsConstructor
public class SongMusicBy {
    private long song_id;
    private long musician_id;
}
