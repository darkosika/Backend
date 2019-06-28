package com.okaplan.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaplan.demo.dao.ItemRepo;
import com.okaplan.demo.dao.TodolistRepo;
import com.okaplan.demo.entity.Item;
import com.okaplan.demo.entity.Todolist;
import com.okaplan.demo.entity.User;


@Transactional
@Service
public class ItemService {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private TodolistRepo todolistrepo;
	
	public void createItem(Integer id,Item item) {
		Optional<Todolist> todolist=todolistrepo.findById(id);
		List<Item> itemlist=new ArrayList<>();
		itemlist.add(item);
		todolist.get().setItemList(itemlist);
		todolistrepo.save(todolist.get());
	}
	
	public List<Item> findByAll() {
		return itemRepo.findAll();
	}
	
	public void DeleteItem(int id) {
		itemRepo.deleteById(id);
	}
	
	public void UpdateItem(int id,String status) {
		Optional<Item> item=itemRepo.findById(id);
		item.get().setStatus(status);
		itemRepo.save(item.get());
	}
}
