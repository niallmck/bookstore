package ie.books.dao.impl.stripersist;

import java.util.List;

import org.stripesstuff.stripersist.Stripersist;

import ie.books.dao.BookDao;
import ie.books.model.Book;

public class BookDaoImpl extends BaseDaoImpl<Book,Integer> implements BookDao{
	
	public Book findByTitle(String title) {
		return findBy("title", title);
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> searchAuthor(String author){
		return Stripersist.getEntityManager()
				.createQuery("FROM Book WHERE author LIKE :author")
				.setParameter("author", "%"+author+"%")
				.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> searchTitle(String title){
		return Stripersist.getEntityManager()
				.createQuery("FROM Book WHERE title LIKE :title")
				.setParameter("title", "%"+title+"%")
				.getResultList();
		
	}
}
