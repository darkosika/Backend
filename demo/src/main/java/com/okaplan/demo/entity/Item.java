package com.okaplan.demo.entity;

import java.security.Timestamp;
import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    
    @Column(name="Name")
    private String name;
    
    @Column(name="Description")
    private String description;
    
    @Column(name="Createdate")
    private Date createdate;
    
    @Column(name="Deadline")
    private Timestamp deadline;
    
    @Column(name="Status")
    private String status;
    
    @Column(name="Dependecy")
    private String item;
	

	public Item() {
		createdate=new Date(System.currentTimeMillis()); 
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	
    
}
