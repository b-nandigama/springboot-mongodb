package com.mongodb.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.springbootdemo.model.Item;
import com.mongodb.springbootdemo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	/* getting items by category from collection */
	public List<Item> getItemByCategory(String category) {
		return itemRepository.findByCategory(category);
	}

	/* get specific item by item id from collection */
	public Item getItemByItemId(long itemId) {
		return itemRepository.findByItemId(itemId);
	}

	/* Adding/inserting item into collection */
	public Item addItem(Item item) {
		Item item2 = itemRepository.save(item);
		return item2;
	}

	/* Updating an item from collection */
	public Item updateItem(Item item) {
		Item response = itemRepository.findByItemId(item.getItemId());
		response.setCategory(item.getCategory());
		response.setItemId(item.getItemId());
		response.setName(item.getName());
		response.setSerialNumber(item.getSerialNumber());
		if (response != null) {
			response = itemRepository.save(response);
		}
		return response;
	}
	
	/* Delete an item from collection */
	public Item deleteItem(Item item) {
		Item response = itemRepository.findByItemId(item.getItemId());
		if (response != null) {
			itemRepository.deleteById(response.getItemId());
		}
		return response;
	}
}
