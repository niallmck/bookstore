package ie.books.action;

import ie.books.model.Customer;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.Wizard;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

public class AccountActionBean extends BaseActionBean{
	private static final String VIEW = "/WEB-INF/jsp/account_view.jsp";
	private static final String EDIT = "/WEB-INF/jsp/account_edit.jsp";
	
	//private Customer customer;
	
	@DefaultHandler
	@DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
	
	@DontValidate
    public Resolution edit() {
        return new ForwardResolution(EDIT);
    }
	
	public Resolution update() {
		//Customer a = getCustomer();
		Customer customer = getCustomer(); //customerDao.read(updatedCustomer.getId());
		customer.setAddress(address);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		
		if (oldPassword != null && oldPassword.equals(customer.getPassword())){
			if (newPassword.equals(confirmPassword)){
				customer.setPassword(newPassword);
			}
		}
		
		customerDao.save(customer);
		customerDao.commit();
		
        //return save();
        return new ForwardResolution(VIEW);
    }
	/*
    public Resolution save() {
        customerDao.save(getContext().getCustomer());
        customerDao.commit();
        return new RedirectResolution(getClass(), "done");
    }*/
    
   /*
    private Customer customer;
    
    public void setCustomer(Customer customer){
    	this.customer = customer;
    }*/
    
	/*
	public Customer getCustomer(){
		return getContext().getCustomer();
	}*/
	
    private String firstName;
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    private String lastName;
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    private String address;
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    private String newPassword;
    
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
	
	private String confirmPassword;

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    
    private String oldPassword;
    
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
