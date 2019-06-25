package com.okaplan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaplan.demo.entity.Todolist;

@Repository
public interface TodolistRepo extends JpaRepository<Todolist, Integer> {

}
