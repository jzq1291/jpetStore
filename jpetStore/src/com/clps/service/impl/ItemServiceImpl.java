package com.clps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.CategoryDao;
import com.clps.dao.ItemDao;
import com.clps.dao.ProductDao;
import com.clps.service.ItemService;
import com.clps.utils.Pager;
import com.clps.vo.Item;
import com.clps.vo.Product;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired 
	ProductDao productDao;

	@Override
	public Pager queryItemByProduct(Product product, Pager pager) {
		if (pager.getPage()==0) {
			pager.setPage(1);
		}
		pager.setSize(1);
		
		List<Item> list= itemDao.queryItemByProduct(product,pager);
		int totalsize=itemDao.getTotalPage(product);
		int size=pager.getSize();
		pager.setList(list);
		int totalPage=totalsize % size == 0 ? totalsize / size : totalsize / size + 1;
		pager.setTotalpage(totalPage);
		return pager;
	}


	@Override
	public Product getProductid(String proId) {
		return productDao.getProductById(proId);
	}

	@Override
	public Product getProuctByItemId(String itemId) {
		Item item=itemDao.getItemByitemId(itemId);
		return productDao.getProductById(item.getProductid());
	}


	@Override
	public Item getItemByItemId(String itemId) {
		return itemDao.getItemByitemId(itemId);
	}


	@Override
	public int getQty(String itemid) {
		return itemDao.getQty(itemid);
	}

}
