package com.api.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.music.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
