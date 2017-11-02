package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}