package com.api.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.music.model.Musician;


@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

}
