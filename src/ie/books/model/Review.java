package ie.books.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends ModelBase {
	
	
	private int rating;
	private String message;
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Customer customer;
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
