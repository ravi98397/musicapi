package com.api.music.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Optional;

import org.aspectj.util.Reflection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.MockitoCore;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ReflectionUtils;

import com.api.music.exceptions.IdNotFoundException;
import com.api.music.model.Song;
import com.api.music.repository.SongRepository;

import io.netty.util.internal.ReflectionUtil;

@ExtendWith(MockitoExtension.class)
public class SongServiceImplTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	SongRepository songRepository;
	
	
	private SongServiceImpl songServiceImpl;
	
	@BeforeEach
	public void setup() {
		songServiceImpl = new SongServiceImpl();
		
		System.out.println("before all ran");
		
		Field repoField;
		try {
			repoField = songServiceImpl.getClass().getDeclaredField("songRepository");		
			repoField.setAccessible(true);
//			ReflectionUtils.setField(repoField, songServiceImpl, songRepository);
			ReflectionTestUtils.setField(songServiceImpl, "songRepository", songRepository);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void getByIdTet() {
		System.out.println("test1 is running");
		Song song = new Song();
		Optional<Song> osong = Optional.of(song);
		song.setId(123);
		song.setName("song1");
		when(songRepository.findById(123L)).thenReturn(osong);
		
		assertEquals("song1", songServiceImpl.getById(123).getName());
	}
	
	@Test
	void getByInvalidIdTest() {
		when(songRepository.findById(12L)).thenReturn(Optional.empty());
		assertThrows(IdNotFoundException.class, () -> {
				songServiceImpl.getById(12L);
		});
	}
}
