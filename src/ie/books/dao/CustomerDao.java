package ie.books.dao;

import ie.books.model.Customer;

public interface CustomerDao extends Dao<Customer, Integer>{
	
	public Customer findByEmail(String email);

}
