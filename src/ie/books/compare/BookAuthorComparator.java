package ie.books.compare;

import ie.books.model.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		return book1.getAuthor().compareTo(book2.getAuthor());
	}

}
