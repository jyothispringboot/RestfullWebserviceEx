package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {

	public Integer saveItem(Item item);
	//all
	public List<Item> getAllItems();
	//delete
	public void deleteItem(Integer id);
	//update
	public Integer updateItem(Item item);

}
