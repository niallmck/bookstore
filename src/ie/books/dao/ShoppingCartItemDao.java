package ie.books.dao;

import java.util.List;

import ie.books.model.Customer;
import ie.books.model.ShoppingCartItem;


public interface ShoppingCartItemDao extends Dao<ShoppingCartItem, Integer>{
	
	//public List<ShoppingCartItem> findByCustomer(Customer customer);

}