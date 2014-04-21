package ie.books.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ie.books.dao.AdminDao;
import ie.books.dao.BookDao;
import ie.books.dao.CategoryDao;
import ie.books.dao.CustomerDao;
import ie.books.dao.impl.stripersist.AdminDaoImpl;
import ie.books.dao.impl.stripersist.BookDaoImpl;
import ie.books.dao.impl.stripersist.CategoryDaoImpl;
import ie.books.dao.impl.stripersist.CustomerDaoImpl;
import ie.books.ext.MyActionBeanContext;
import ie.books.model.Customer;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public abstract class BaseActionBean implements ActionBean {
	private MyActionBeanContext context;

    public MyActionBeanContext getContext() {
        return context;
    }
    public void setContext(ActionBeanContext context) {
        this.context = (MyActionBeanContext)context;
    }
    
    protected BookDao bookDao = new BookDaoImpl();
    protected CustomerDao customerDao = new CustomerDaoImpl();
    //protected ReviewDao reviewDao = new ReviewDaoImpl();
    //protected SaleDao messageDao = new SaleDaoImpl();
    protected CategoryDao categoryDao = new CategoryDaoImpl();
    protected AdminDao adminDao = new AdminDaoImpl();
    
    public Customer getCustomer(){
    	return getContext().getCustomer();
    }
    
    
    public String getLastUrl() {
        HttpServletRequest req = getContext().getRequest();
        StringBuilder sb = new StringBuilder();

        // Start with the URI and the path
        String uri = (String)
            req.getAttribute("javax.servlet.forward.request_uri");
        String path = (String)
            req.getAttribute("javax.servlet.forward.path_info");
        if (uri == null) {
            uri = req.getRequestURI(); 
            path = req.getPathInfo(); 
        }
        sb.append(uri);
        if (path != null) { sb.append(path); }

        // Now the request parameters
        sb.append('?');
        Map<String,String[]> map =
            new HashMap<String,String[]>(req.getParameterMap());

        // Append the parameters to the URL
        for (String key : map.keySet()) {
            String[] values = map.get(key);
            for (String value : values) {
                sb.append(key).append('=').append(value).append('&');
            }
        }
        // Remove the last '&'
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}

