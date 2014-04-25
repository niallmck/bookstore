package ie.books.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SaleItem extends ModelBase{
	
	private double unitPrice;
	private int quantity;
	
	@ManyToOne
	private Sale sale;
	
	@ManyToOne
	private Book book;

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	public String getDisplayPrice(){
		return String.format("%10.2f", unitPrice);
	}
	

}
