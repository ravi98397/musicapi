package com.api.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.music.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
	Artist findByName(String name);
}
