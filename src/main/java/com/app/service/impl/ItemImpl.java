package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.repo.ItemRepository;
import com.app.service.IItemService;

@Service
public class ItemImpl implements IItemService {

	
	@Autowired
	private ItemRepository repo;
	
	@Transactional
	public Integer saveItem(Item item) {
		return  repo.save(item).getItemId();
	}

	@Transactional(readOnly = true)
	public List<Item> getAllItems() {
		List<Item> itm=repo.findAll();
		return itm;
	}

	@Transactional
	public void deleteItem(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Integer updateItem(Item item) {
		Integer result = null;
		if(repo.save(item)!=null)
			{
			 result=1;
			}
		return result;
	}

}
