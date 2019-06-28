package com.okaplan.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Todolist")
public class Todolist {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    
    @Column(name="Name")
    private String name;
    
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Item> itemList;

	public Todolist() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
    
    
}
