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
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

@Wizard(startEvents={"view","edit", "done"})
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
        return save();
    }
    public Resolution save() {
        customerDao.save(getContext().getCustomer());
        customerDao.commit();
        return new RedirectResolution(getClass(), "done");
    }
    
    @ValidateNestedProperties({
    	@Validate(field="firstName" , required=true),
    	@Validate(field="lastName" , required=true),
    	@Validate(field="address" , required=true),
    })
    
    
    private Customer customer;
    
    public void setCustomer(Customer customer){
    	this.customer = customer;
    }
    
	
	public Customer getCustomer(){
		return getContext().getCustomer();
	}
	
}
