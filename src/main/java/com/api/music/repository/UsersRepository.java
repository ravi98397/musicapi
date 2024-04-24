package com.api.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.music.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query("SELECT u FROM Users u WHERE u.username = ?1 and u.password = ?2")
	public Users authenticate(String username, String password);
	
	@Query("SELECT u FROM Users u where u.username = ?1")
	public Users findByUsername(String username);
}
