package ie.books.action;

import ie.books.dao.BookDao;
import ie.books.dao.CustomerDao;
import ie.books.dao.impl.stripersist.BookDaoImpl;
import ie.books.dao.impl.stripersist.CustomerDaoImpl;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public abstract class BaseActionBean implements ActionBean {
    private ActionBeanContext actionBeanContext;

    public ActionBeanContext getContext() {
        return actionBeanContext;
    }
    public void setContext(ActionBeanContext actionBeanContext) {
        this.actionBeanContext = actionBeanContext;
    }
    
    protected BookDao attachmentDao = new BookDaoImpl();
    protected CustomerDao customerDao = new CustomerDaoImpl();
    //protected ReviewDao reviewDao = new ReviewDaoImpl();
    //protected SaleDao messageDao = new SaleDaoImpl();
}

