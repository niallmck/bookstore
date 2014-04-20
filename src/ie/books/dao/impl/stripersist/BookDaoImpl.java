package ie.books.dao.impl.stripersist;

import ie.books.dao.BookDao;
import ie.books.model.Book;

public class BookDaoImpl extends BaseDaoImpl<Book,Integer> implements BookDao{
	
	public Book findByTitle(String title) {
		return findBy("title", title);
	}
}
