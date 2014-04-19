package ie.books.model;

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
	
	@Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);        
    }
	
	

}
