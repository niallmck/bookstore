package ie.books.dao;

import ie.books.model.Category;


public interface CategoryDao  extends Dao<Category,Integer>{
	
	public Category findByName(String name);
}
