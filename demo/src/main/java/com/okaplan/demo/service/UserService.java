package com.okaplan.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaplan.demo.dao.UserRepo;
import com.okaplan.demo.entity.User;

@Transactional
@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public void createUser(User user) {
		userRepo.save(user);
		int id=user.getId();
		userRepo.existsById(id);
	}
	
	public Optional<User> findByid(int id) {
		return userRepo.findById(id);
	}
	
	public boolean login(String username) {
	//return	userRepo.existsById(id);
	int userid=userRepo.findByUsername(username);
	
	Optional<User> user=userRepo.findById(userid);
	return user!=null ? true: false;
	}
	
	
}
