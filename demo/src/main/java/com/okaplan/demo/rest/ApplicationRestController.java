package com.okaplan.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okaplan.demo.dao.TodoListDao;
import com.okaplan.demo.entity.Todolist;

@RestController
@RequestMapping("/api")
public class ApplicationRestController {

	
	@Autowired
	TodoListDao todoListDao;
	
 
	
	@GetMapping("/getAllTodoList")
	public List<Todolist> getAllTodoList() {
		return todoListDao.getAllTodoList();
	}
	
	
	
	@PostMapping("/createlist")
	public void addEmployee(@RequestBody Todolist todolist) {
		todoListDao.saveTodoList(todolist);
		}
}
