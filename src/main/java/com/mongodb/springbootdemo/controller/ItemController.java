package com.mongodb.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.springbootdemo.model.Item;
import com.mongodb.springbootdemo.service.ItemService;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Item>> getItems(){
		return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
		
	}
	
	@GetMapping("/list/{categoryName}")
	public ResponseEntity<List<Item>> getItemsByCategory(@PathVariable("categoryName") String categoryName){
		return new ResponseEntity<>(itemService.getItemByCategory(categoryName), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemsById(@PathVariable("id") long id){
		return new ResponseEntity<>(itemService.getItemByItemId(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {
		return new ResponseEntity<Item>(item, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) {
		Item itemResponse = itemService.updateItem(item);
		if(itemResponse == null)
			return new ResponseEntity<Item>(itemResponse, HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<Item>(itemResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<Item> deleteItem(@RequestBody Item item) {
		Item itemResponse =  itemService.deleteItem(item);
		if(itemResponse == null)
			return new ResponseEntity<Item>(itemResponse, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Item>(itemResponse, HttpStatus.OK);
	}
	
	
	
	
}
