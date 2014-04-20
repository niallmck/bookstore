package ie.books.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SaleItem extends ModelBase{
	
	private double unitPrice;
	private int quanitity;
	
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

	public int getQuanitity() {
		return quanitity;
	}

	public void setQuanitity(int quanitity) {
		this.quanitity = quanitity;
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
	
	

}
