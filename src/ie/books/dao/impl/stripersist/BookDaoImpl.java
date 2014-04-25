package ie.books.dao.impl.stripersist;

import java.util.ArrayList;
import java.util.List;

import org.stripesstuff.stripersist.Stripersist;

import ie.books.dao.BookDao;
import ie.books.model.Book;
import ie.books.model.SaleItem;

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
	
	@SuppressWarnings("unchecked")
	public List<Book> getDiscountedBooks(){
		return Stripersist.getEntityManager()
				.createQuery("FROM Book WHERE discountPercentage > 0")
				.getResultList();
		
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBestSellingBooks() {
		List<SaleItem> itemsSold= Stripersist.getEntityManager()
				.createQuery("from SaleItem group by book_id order by count(book_id) desc")
				.getResultList();
		
		List<Book> bestSellers = new ArrayList<Book>();
		for (SaleItem item : itemsSold){
			bestSellers.add(item.getBook());
		}
		return bestSellers;
	}
}
