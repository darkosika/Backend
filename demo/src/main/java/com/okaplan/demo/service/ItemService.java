package com.okaplan.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okaplan.demo.dao.ItemRepo;
import com.okaplan.demo.entity.Item;


@Transactional
@Service
public class ItemService {
	
	@Autowired
	private ItemRepo itemRepo;
	
	public void createItem(Item item) {
		itemRepo.save(item);
	}
	
	public List<Item> findByAll() {
		return itemRepo.findAll();
	}
	
	public void DeleteItem(int id) {
		itemRepo.deleteById(id);
	}
}
