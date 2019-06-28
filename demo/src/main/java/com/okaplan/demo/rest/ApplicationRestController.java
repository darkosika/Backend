package com.okaplan.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@PostMapping("/register")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
		}
	@PostMapping("/login")
	public boolean login(@RequestParam String username,@RequestParam String password) {
		return userService.login(username,password);
		}
	@GetMapping("/getUser/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userService.findByid(id);
	}
	
	@GetMapping("/getAllTodoList")
	public List<Todolist> getAllTodoList() {
		return todoListService.getAllTodoList();
	}
	
	@PostMapping("/createlist")
	public int createlist(@RequestParam int id ,@RequestBody Todolist todolist) {
		return todoListService.saveTodoList(id,todolist);
	}
		
	@DeleteMapping("deletelist/{id}")
	public void deletelist(@PathVariable int id) {
		todoListService.deletelist(id);
	}
	
	@PostMapping("/createItem")
	public void createItem(@RequestParam Integer id,@RequestBody Item item) {
		itemService.createItem(id,item);
		}
	@GetMapping("/getItems")
	public List<Item> getItems() {
		return itemService.findByAll();
	}
	
	@PutMapping("updateItem/")
	public void deleteItem(@RequestParam int id,@RequestParam String status) {
		itemService.UpdateItem(id, status);
	}
	
	@PutMapping("updateItem/{id}")
	public void Updateitem(@PathVariable int id) {
		
	}
	
}
