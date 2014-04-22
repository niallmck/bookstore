package ie.books.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sale extends ModelBase{
	
	private Date purchaseDate;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy="sale")
	private List<SaleItem> items;

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<SaleItem> getItems() {
		return items;
	}

	public void setItems(List<SaleItem> items) {
		this.items = items;
	}
	
	public void addItem(SaleItem item){
		items.add(item);
	}
	
	

}
