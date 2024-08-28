package com.api.music.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.api.music.model.Song;
import com.api.music.repository.SongRepository;

@ExtendWith(MockitoExtension.class)
class SongServiceImplTests {

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	SongRepository songRepository;
	
	
	private SongServiceImpl songServiceImpl;
	
	@BeforeEach
	public void setup() {
		
		
		System.out.println("before all ran");
		
		try {
			songServiceImpl = new SongServiceImpl();
			MockitoAnnotations.openMocks(songServiceImpl);
			ReflectionTestUtils.setField(songServiceImpl, "songRepository", songRepository);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error occured");
			e.printStackTrace();
		}
	} 
	
	@Test
	void getByIdTestTrue() {
		System.out.println("test1 is running");
		Song song = new Song();
		Optional<Song> osong = Optional.of(song);
		song.setId(123);
		song.setName("song1");
		when(songRepository.findById(123L)).thenReturn(osong);
		
		assertEquals("song1", songServiceImpl.getById(123L).getName());
	}
	
	
	@Test
	void getByIdTestFalse() {
		System.out.println("test2 is running");
		when(songRepository.findById(12L)).thenReturn(Optional.empty());
		
		assertNull(songServiceImpl.getById(12L));
	}
	
	@Test
	void testTure() {
		assertTrue(true);
	}
}
