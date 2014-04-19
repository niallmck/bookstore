package ie.books.dao.impl.stripersist;

import org.springframework.stereotype.Repository;

import ie.books.dao.BaseDaoImpl;
import ie.books.dao.BookDao;
import ie.books.model.Book;

@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl<Book,Integer> implements BookDao{
	
	@Override
	public Book findByTitle(String title) {
		return findBy("title", title);
	}
}
