package ie.books.compare;

import ie.books.model.Book;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		return Double.compare(book1.getPrice(), book2.getPrice());
	}

}