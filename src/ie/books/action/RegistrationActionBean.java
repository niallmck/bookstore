
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

@Wizard(startEvents={"view","done"})
public class RegistrationActionBean extends BaseActionBean implements ValidationErrorHandler{
	
	private static final String VIEW = "/WEB-INF/jsp/registration.jsp";
	private static final String DONE = "/WEB-INF/jsp/registration_complete.jsp";
	
    @DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    
    public Resolution register() {
        return save();
    }
    public Resolution save() {
        customerDao.save(customer);
        customerDao.commit();
        return new RedirectResolution(getClass(), "done");
    }
    @DontValidate
    public Resolution done() {
        return new ForwardResolution(DONE);
    }
    
    @ValidateNestedProperties({
    	@Validate(field="firstName" , required=true),
    	@Validate(field="lastName" , required=true),
    	@Validate(field="email" , required=true),
    	@Validate(field="password" , required=true),
    	@Validate(field="address" , required=true)
    })
    private Customer customer;
    
    public Customer getCustomer(){
    	return customer;
    }
    
    public void setCustomer(Customer customer){
    	this.customer = customer;
    }
    
    @Validate(required=true)
    private String confirmPassword;
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    @ValidationMethod
    public void validateUsernameAndPasswords(ValidationErrors errors){
        String email = customer.getEmail();
        if (customerDao.findByEmail(email) != null) {
            errors.addGlobalError(
                new SimpleError("An account for " + email + " already exists."));
        }
        if (!customer.getPassword().equals(confirmPassword)) {
            errors.addGlobalError(
                new SimpleError("The passwords do not match."));
        }
    }

	@Override
	public Resolution handleValidationErrors(ValidationErrors errors) {
		if (errors.hasFieldErrors()) {
            errors.addGlobalError(
                new SimpleError("All fields are required."));
        }
        return null;
	}
    
}

