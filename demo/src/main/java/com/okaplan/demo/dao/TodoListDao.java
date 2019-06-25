package com.okaplan.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaplan.demo.entity.Todolist;
import com.okaplan.demo.repository.TodolistRepo;

@Transactional
@Service
public class TodoListDao {

	@Autowired
	TodolistRepo todolistRepo;
	
	public List<Todolist> getAllTodoList(){
		return todolistRepo.findAll();
	}
	
	public Todolist saveTodoList(Todolist todolist) {
		return todolistRepo.save(todolist);
	}
}
