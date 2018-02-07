package com.clps.dao.impl;

import org.springframework.stereotype.Repository;

import com.clps.dao.InventoryDao;
import com.clps.utils.BaseHibernateDAO;
import com.clps.vo.Inventory;

@Repository
public class InventoryDaoImpl extends BaseHibernateDAO  implements InventoryDao {

	@Override
	public int getInventory(String itemId) {
		Inventory inventory = (Inventory) getHibernateTemplate().load(Inventory.class, itemId);
		return inventory.getQty();
	}

}
