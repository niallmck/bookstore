package ie.books.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends ModelBase {
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Customer customer;

}
