package ie.books.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ShoppingCartItem extends ModelBase{

	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Book book;
	
	private int quantity;

	public ShoppingCartItem(){};
	
	public ShoppingCartItem(Customer customer, Book book) {
		this.customer = customer;
		this.book = book;
		this.quantity = 1;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void incrementQuantity(){
		quantity += 1;
	}
	
	public void decrementQuantity(){
		quantity -= 1;
	}
	
	
}
