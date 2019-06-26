package com.okaplan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.okaplan.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("Select id from User where fullName= ?1")
	int findByUsername(String username);
}
