package com.api.music.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SongDetails {
    Song song;
    Set<Artist> artists;
    Set<Genre> genres;
    Set<Musician> musicians;
    Set<Playlist> playlists;
}
