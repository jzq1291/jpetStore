package com.clps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.InventoryDao;
import com.clps.dao.ItemDao;
import com.clps.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private ItemDao itemDao;

	@Override
	public int getInventory(String itemId) {
		
//		return inventoryDao.getInventory(itemId);
		return itemDao.getQty(itemId);
		
	}

}
