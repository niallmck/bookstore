package ie.books.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book extends ModelBase {
	
	private String title;
	private String author;
	private double price;
	private String imageUrl;
	private int stock;
	
	
	@OneToMany(mappedBy="book")
	private Set<SaleItem> saleItems;

	
	@OneToMany(mappedBy="book")
	private Set<Review> reviews;
	
	@ManyToOne
	private Category category;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public Set<Review> getReviews() {
		return reviews;
	}


	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}


	public Set<SaleItem> getSaleItems() {
		return saleItems;
	}


	public void setSaleItems(Set<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	

	
	
}
