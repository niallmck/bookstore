package ie.books.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;
import ie.books.model.Customer;

public class LoginActionBean extends BaseActionBean{
	private static final String VIEW = "/WEB-INF/jsp/login.jsp";
	
	private Customer customer;
	public String loginUrl;
	
	
	@DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    public Resolution login() {
        getContext().setCustomer(customer);
        if (loginUrl != null) {
            return new RedirectResolution(loginUrl);
        }
        return new RedirectResolution(AccountActionBean.class);
    }
    
    @Validate(required=true)
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Validate(required=true)
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @ValidationMethod
    public void validateUser(ValidationErrors errors) {
        customer = customerDao.findByEmail(email);
        
        if (customer == null) {
            errors.addGlobalError(
            		new SimpleError("Email not recognised."));
        }
        else if (!customer.getPassword().equals(password)) {
            errors.addGlobalError(
            		new SimpleError("Incorrect Password."));
        }
        
    }

}
