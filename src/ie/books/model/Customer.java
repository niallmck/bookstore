package ie.books.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends ModelBase {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	
	@OneToMany(mappedBy="customer")
	private Set<Sale> sales;
	
	@OneToMany(mappedBy="customer")
	private Set<Review> reviews;
	
	@OneToMany(mappedBy="customer")
	private List<ShoppingCartItem> shoppingCart;// = new ArrayList<ShoppingCartItem>();
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Set<Sale> getSales() {
		return sales;
	}
	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	public List<ShoppingCartItem> getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(List<ShoppingCartItem> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public void addToCart(ShoppingCartItem item){
		shoppingCart.add(item);
	}
	
	public void removeFromCart(ShoppingCartItem item) {
		shoppingCart.remove(item);
	}
	
	public void emptyCart(){
		shoppingCart.clear();
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
	
	@Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);        
    }
	
	
	

}
