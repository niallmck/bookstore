package ie.books.ext;

import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.action.ActionBeanContext;
import ie.books.dao.impl.stripersist.AdminDaoImpl;
import ie.books.dao.impl.stripersist.CustomerDaoImpl;
import ie.books.model.Admin;
import ie.books.model.Customer;

public class MyActionBeanContext extends ActionBeanContext{
	
    private static final String CUSTOMER = "customer";
    private static final String ADMIN = "admin";
    
    public void setCustomer(Customer customer) {
        if (customer != null) {
            setCurrent(CUSTOMER, customer.getId());
        }
        else {
            setCurrent(CUSTOMER, null);
        }
    }
    
    public Customer getCustomer() {
        Integer customerId = getCurrent(CUSTOMER, null);
        if (customerId == null) { return null ; }
        return new CustomerDaoImpl().read(customerId);
    }
    
    public void logout() {
        setCustomer(null);
        setAdmin(null);

        HttpSession session = getRequest().getSession();
        if (session != null) {
            session.invalidate();
        }
    }
    
    protected void setCurrent(String key, Object value) {
        getRequest().getSession().setAttribute(key, value);
    }
    
    @SuppressWarnings("unchecked")
    protected <T> T getCurrent(String key, T defaultValue) {
        T value = (T) getRequest().getSession().getAttribute(key);
        if (value == null) {
            value = defaultValue;
            setCurrent(key, value);
        }
        return value;
    }

	public void setAdmin(Admin admin) {
		if (admin != null){
			setCurrent(ADMIN, admin.getId());
		}
		else{
			setCurrent(ADMIN, null);
		}
	}
    
	
	public Admin getAdmin() {
        Integer adminId = getCurrent(ADMIN, null);
        if (adminId == null) { return null ; }
        return new AdminDaoImpl().read(adminId);
    }

}
