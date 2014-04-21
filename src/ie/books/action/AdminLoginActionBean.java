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
import ie.books.model.Admin;

public class AdminLoginActionBean extends BaseActionBean{
	private static final String VIEW = "/WEB-INF/jsp/admin/login.jsp";
	
	private Admin admin;
	public String loginUrl;
	
	
	@DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    public Resolution login() {
        getContext().setAdmin(admin);
        if (loginUrl != null) {
            return new RedirectResolution(loginUrl);
        }
        return new RedirectResolution(AdminActionBean.class);
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
    public void validateAdmin(ValidationErrors errors) {
        admin = adminDao.findByEmail(email);
        
        if (admin == null) {
            errors.addGlobalError(
            		new SimpleError("Email not recognised."));
        }
        else if (!admin.getPassword().equals(password)) {
            errors.addGlobalError(
            		new SimpleError("Incorrect Password."));
        }
        
    }

}
