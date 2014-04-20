package ie.books.dao.impl.stripersist;

import ie.books.dao.ReviewDao;
import ie.books.model.Book;
import ie.books.model.Review;

public class ReviewDaoImpl extends BaseDaoImpl<Review, Integer> implements ReviewDao{

	public Review findByBook(Book book) {
		return findBy("book", book);
	}

}
