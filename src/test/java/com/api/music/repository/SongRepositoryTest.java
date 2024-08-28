package com.api.music.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import com.api.music.model.Song;
import com.api.music.service.impl.SongServiceImpl;

@DataJpaTest
public class SongRepositoryTest {
	
	@Autowired
	SongRepository songRepository;

	
	@Test
	@Commit
	@Order(1)
	public void createSongTest() {
		
		Song song = new Song();
		song.setName("Song1");
		
		song = songRepository.save(song);
		assertThat(song.getId()).isGreaterThan(0);
	}
	
	
	
	@Test
	public void getSongByIdTest() {
		Song song = songRepository.findById(1L).get();
		assertThat(song.getId()).isEqualTo(1L);
	}
	
	
	
	@Test
	public void findAllSongTest() {
		int songlen = songRepository.findAll().size();
		assertThat(songlen).isGreaterThan(0);
	}
	
	@Test
	public void updaeSongTest() {
		Song song = songRepository.findById(1L).get();
		song.setName("song2");
		song = songRepository.save(song);
		
		assertEquals("song2", song.getName());
	}
}
