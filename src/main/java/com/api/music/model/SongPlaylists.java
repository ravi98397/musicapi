package com.api.music.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name="SONG_PLAYLISTS", uniqueConstraints = @UniqueConstraint(columnNames = {"song_id", "playlist_id"}))
@Data
@AllArgsConstructor
public class SongPlaylists {
    private long song_id;
    private long playlist_id;    
}
