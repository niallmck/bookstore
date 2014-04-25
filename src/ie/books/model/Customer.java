package ie.books.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	private List<Sale> sales;
	
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
	
	
	public List<Sale> getSales() {
		return sales;
	}
	public void setSales(List<Sale> sales) {
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
	
	public String getCartTotal(){
		double total = 0;
    	for (ShoppingCartItem cartItem: shoppingCart){   		
    		total += cartItem.getQuantity() * cartItem.getBook().getPrice();
    	}
    	return String.format("%10.2f", total);
	}
	
	public List<Sale> getSalesByDate(){
		Collections.sort(sales, new Comparator<Sale>() {
		    public int compare(Sale s1, Sale s2) {
		        return s1.getPurchaseDate().compareTo(s2.getPurchaseDate());
		    }
		});
		Collections.reverse(sales);
		return sales;
	}
	
	@Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);        
    }
	
	
	

}
