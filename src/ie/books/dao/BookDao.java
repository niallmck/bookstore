package ie.books.dao;

import ie.books.model.Book;

public interface BookDao extends Dao<Book,Integer>{
	
	public Book findByTitle(String title);
	
	

}
