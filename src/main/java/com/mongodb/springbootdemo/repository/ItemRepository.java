package com.mongodb.springbootdemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.springbootdemo.model.Item;

public interface ItemRepository extends MongoRepository<Item, Long> {

	List<Item> findByCategory(String category);
	
	Item findByItemId(long itemId); 
}
