package com.okaplan.demo.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private Timestamp createdate;
    
    @Column(name="Deadline")
    private Timestamp deadline;
    
    @Column(name="Status")
    private Timestamp status;
	

	public Item() {}

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

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public Timestamp getStatus() {
		return status;
	}

	public void setStatus(Timestamp status) {
		this.status = status;
	}

	
    
}
