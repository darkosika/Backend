package com.okaplan.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaplan.demo.dao.TodolistRepo;
import com.okaplan.demo.dao.UserRepo;
import com.okaplan.demo.entity.Todolist;
import com.okaplan.demo.entity.User;

@Transactional
@Service
public class TodoListService {

	@Autowired
	TodolistRepo todolistRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public List<Todolist> getAllTodoList(){
		return todolistRepo.findAll();
	}
	
	public int saveTodoList(int id,Todolist todolist) {
		Optional<User> user=userRepo.findById(id);
		List<Todolist> todos=new ArrayList<>();
		todos.add(todolist);
		user.get().setTodolist(todos);
		userRepo.save(user.get());
		return todolist.getId();
		//return todolistRepo.save(todolist);
	}
	
	public void deletelist(int id) {
		todolistRepo.deleteById(id);
	}
}
