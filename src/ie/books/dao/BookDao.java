package ie.books.dao;

import java.util.List;

import ie.books.model.Book;

public interface BookDao extends Dao<Book,Integer>{
	
	public Book findByTitle(String title);
	
	public List<Book> searchAuthor(String author);
	
	public List<Book> searchTitle(String title);
	
	

}
