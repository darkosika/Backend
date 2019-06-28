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
@Table(name = "User")
public class User {
	
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    
    @Column(name = "User_Name", length = 64)
    private String fullName;
    
    @Column(name = "Password", length = 32)
    private String password;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Todolist> todolist;
    
    public User() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Todolist> getTodolist() {
		return todolist;
	}

	public void setTodolist(List<Todolist> todolist) {
		this.todolist = todolist;
	}
    
    
}
