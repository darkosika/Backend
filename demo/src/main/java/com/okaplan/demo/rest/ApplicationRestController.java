package com.okaplan.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okaplan.demo.entity.Item;
import com.okaplan.demo.entity.Todolist;
import com.okaplan.demo.entity.User;
import com.okaplan.demo.service.ItemService;
import com.okaplan.demo.service.TodoListService;
import com.okaplan.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class ApplicationRestController {

	
	@Autowired
	TodoListService todoListService;
	@Autowired
	UserService userService;
	@Autowired
	ItemService itemService;
	
 
	
	@GetMapping("/getAllTodoList")
	public List<Todolist> getAllTodoList() {
		return todoListService.getAllTodoList();
	}
	
	@PostMapping("/createlist")
	public void addEmployee(@RequestBody Todolist todolist) {
		todoListService.saveTodoList(todolist);
		}
	
	@PostMapping("/register")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
		}
	@PostMapping("/login/{username}")
	public boolean login(@PathVariable String username) {
		return userService.login(username);
		}
	@GetMapping("/getUser/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userService.findByid(id);
	}
	
	@PostMapping("/createItem")
	public void createItem(@RequestBody Item item) {
		itemService.createItem(item);
		}
	@GetMapping("/getItems")
	public List<Item> getItems() {
		return itemService.findByAll();
	}
	
	@DeleteMapping("deleteItem/{id}")
	public void deleteItem(@PathVariable int id) {
		itemService.DeleteItem(id);
	}
	
}
