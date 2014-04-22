package ie.books.dao.impl.stripersist;

import ie.books.dao.ShoppingCartItemDao;
import ie.books.model.Customer;
import ie.books.model.ShoppingCartItem;

import java.util.List;

public class ShoppingCartItemDaoImpl extends BaseDaoImpl<ShoppingCartItem, Integer> implements ShoppingCartItemDao{

	/*
	@SuppressWarnings("unchecked")
	public List<ShoppingCartItem> findByCustomer(Customer customer) {
		return (List<ShoppingCartItem>) findBy("customer", customer);
	}*/

}
