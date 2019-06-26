package com.okaplan.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okaplan.demo.entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

}
