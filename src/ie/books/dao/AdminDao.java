package ie.books.dao;

import ie.books.model.Admin;

public interface AdminDao extends Dao<Admin,Integer>{
	
	public Admin findByEmail(String email);
}
