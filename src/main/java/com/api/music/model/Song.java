package com.api.music.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="SONG")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@EqualsAndHashCode(exclude = {"songs"})
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private int releaseyear;
	private String createdon;
	private float duration;
	private int likes;
	private int played;   //no of time played will help in the ranking of the songs against other songs.
	private String imgurl;
	private String downloadlink128kbps;
	private String downloadlink320kbps;
	


	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="album_id", referencedColumnName = "id")    
	@Fetch(value = FetchMode.SELECT)
	@JsonIgnoreProperties("songs")
	private Album album;

	
	
	//many to many relationship with musicians
	// @ManyToMany(targetEntity = Musician.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(
	// 		joinColumns = @JoinColumn(name="song_id"),
	// 		inverseJoinColumns = @JoinColumn(name="musician_id")
	// 		)
	// @Fetch(value = FetchMode.SELECT)
	// @JsonIgnoreProperties("songs")
	// private Set<Musician> musicBy = new HashSet<Musician>();

	//@OneToMany(targetEntity=SongMusicBy.class, mappedBy="song",cascade= {CascadeType.MERGE} , fetch = FetchType.LAZY)
	private Set<SongMusicBy> musicBy = new HashSet<SongMusicBy>();
	
	
	// //many to many relationship with artists
	// @ManyToMany(targetEntity = Artist.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(
	// 		joinColumns = @JoinColumn(name="song_id"),
	// 		inverseJoinColumns = @JoinColumn(name="artist_id")
	// 		)
	// @Fetch(value = FetchMode.SELECT)
	// @JsonIgnoreProperties("songs")
	// private Set<Artist> artists = new HashSet<Artist>();

	//@OneToMany(targetEntity=SongArtists.class, mappedBy="song",cascade= {CascadeType.MERGE} , fetch = FetchType.LAZY)
	private Set<SongArtists> artists = new HashSet<SongArtists>();
	
	
	//many to many relationship with genre
	// @ManyToMany(targetEntity = Genre.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(
	// 		joinColumns = @JoinColumn(name="song_id"),
	// 		inverseJoinColumns = @JoinColumn(name="genre_id")
	// 		)
	// @Fetch(value = FetchMode.SELECT)
	// @JsonIgnoreProperties("songs")
	// private Set<Genre> genres = new HashSet<Genre>();
		
	//@OneToMany(targetEntity=SongGenres.class, mappedBy="song",cascade= {CascadeType.MERGE} , fetch = FetchType.LAZY)
	private Set<SongGenres> genres = new HashSet<SongGenres>();

	//many to many with playlists
	// @Fetch(value = FetchMode.SELECT)
	// @ManyToMany(mappedBy = "songs",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JsonIgnoreProperties("songs")
	// private Set<Playlist> playlists = new HashSet<Playlist>();

	//@OneToMany(targetEntity=SongPlaylists.class, mappedBy="song",cascade= {CascadeType.MERGE} , fetch = FetchType.LAZY)
	private Set<SongPlaylists> playlists = new HashSet<SongPlaylists>();
	
	public void addArtist(Artist artist) {
		this.artists.add(new SongArtists(this.id, artist.getId()));
	}

	public void addArtists(Set<Artist> artists) {
		for(Artist artist : artists) {
			this.artists.add(new SongArtists(this.id, artist.getId()));
		}
	}

	public void addMusician(Musician musician) {
		this.musicBy.add(new SongMusicBy(this.id, musician.getId()));
	}

	public void addMusicians(Set<Musician> musicians) {
		for(Musician musician : musicians) {
			this.musicBy.add(new SongMusicBy(this.id, musician.getId()));
		}
	}

	public void addGenre(Genre genre) {
		this.genres.add(new SongGenres(this.id, genre.getId()));
	}

	public void addGenres(Set<Genre> genres) {
		for(Genre genre : genres) {
			this.genres.add(new SongGenres(this.id, genre.getId()));
		}
	}

	public void addPlaylist(Playlist playlist) {
		this.playlists.add(new SongPlaylists(this.id, playlist.getId()));
	}

	public void addPlaylists(Set<Playlist> playlists) {
		for(Playlist playlist : playlists) {
			this.playlists.add(new SongPlaylists(this.id, playlist.getId()));
		}
	}
}