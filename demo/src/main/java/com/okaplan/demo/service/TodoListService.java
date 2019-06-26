package com.okaplan.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaplan.demo.dao.TodolistRepo;
import com.okaplan.demo.entity.Todolist;

@Transactional
@Service
public class TodoListService {

	@Autowired
	TodolistRepo todolistRepo;
	
	public List<Todolist> getAllTodoList(){
		return todolistRepo.findAll();
	}
	
	public Todolist saveTodoList(Todolist todolist) {
		return todolistRepo.save(todolist);
	}
}
