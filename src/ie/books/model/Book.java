package ie.books.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Book extends ModelBase {
	
	@OneToMany(mappedBy="review")
	private Set<Review> reviews;
	@ManyToMany(mappedBy="saleItem")
	private Set<Sale> sales;

}
