package com.api.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.music.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	List<Album> findByName(String name);
}
