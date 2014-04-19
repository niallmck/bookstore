
package ie.books.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class RegistrationActionBean implements ActionBean {
    private ActionBeanContext ctx;
    public ActionBeanContext getContext() { return ctx; }
    public void setContext(ActionBeanContext ctx) { this.ctx = ctx; }

    @DefaultHandler
    public Resolution register() {
        return new ForwardResolution(VIEW);
    }

    private static final String VIEW = "/WEB-INF/jsp/registration.jsp";
}

