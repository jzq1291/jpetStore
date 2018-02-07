package com.clps.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.dao.CartDao;
import com.clps.dao.ItemDao;
import com.clps.service.ShoppingCartService;
import com.clps.vo.Cart;
import com.clps.vo.Item;
import com.clps.vo.ShoppingCart;
import com.clps.vo.ShoppingCartItem;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ItemDao itemDao;

	@Override
	public void add(String signonId, String itemId) {
		List<Cart> list = cartDao.findCartItem(signonId, itemId);
		if(list.size()>0){
			Cart cart = list.get(0);
			cart.setQuantity(cart.getQuantity()+1);
			cartDao.save(cart);
		}else {
			cartDao.save(new Cart(signonId, itemId, 1));
		}
	}

	@Override
	public void sub(String signonId, String itemId) {
		List<Cart> list = cartDao.findCartItem(signonId, itemId);
		Cart cart = list.get(0);
		if(cart.getQuantity()>1){
			cart.setQuantity(cart.getQuantity()-1);
			cartDao.save(cart);	
		}else{
			cartDao.delete(cart);
		}
	}
	
	@Override
	public ShoppingCart query(String signonId) {
		ShoppingCart myCart = new ShoppingCart();
		List<Cart> list = (List<Cart>) cartDao.query(signonId);
		for(Cart s:list){
			Item item = itemDao.getItemByitemId(s.getItemid());
			for(int i=0;i<s.getQuantity();i++){
				myCart.add(item.getItemid(), item);
			}
		}
		return myCart;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void persistence(ShoppingCart myCart,String signonId) {
		Collection<ShoppingCartItem> valueCollection = myCart.getItems();
		List<ShoppingCartItem> list = new ArrayList<>(valueCollection);
		
		for(ShoppingCartItem cartItem:list){
			Cart cart = new Cart(signonId, ((Item) cartItem.getItem()).getItemid(), cartItem.getQuantity());
			
			//是否存在此购物车项
			List<Cart> carts = cartDao.findCartItem(signonId,((Item) cartItem.getItem()).getItemid());
			if(carts.size()>0){
				//如果存在修改cart 的之后再存入
				cart.setId(carts.get(0).getId());
				cart.setQuantity((cart.getQuantity()+carts.get(0).getQuantity()));
				cartDao.save(cart);
			}else {
				//否则直接插入新的
				cartDao.save(cart);
				
			}
		}
	}

	@Override
	public void remove(String signonId, String itemId) {
		List<Cart> list = cartDao.findCartItem(signonId, itemId);
		Cart cart = list.get(0);
//		Cart cart = new Cart(signonId, itemId, null);
		cartDao.delete(cart);
	}

	@Override
	public void modify(String signonId, String itemId, int count) {
		Cart cart = cartDao.findCartItem(signonId, itemId).get(0);
		cart.setQuantity(count);
		cartDao.save(cart);
	}

}
