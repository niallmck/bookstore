package ie.books.dao;

import ie.books.model.Book;
import ie.books.model.Review;

public interface ReviewDao extends Dao<Review, Integer>{
	
	public Review findByBook(Book book);

}
