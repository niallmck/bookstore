
package ie.books.action;

import java.util.Date;
import java.util.Random;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class HelloActionBean implements ActionBean {
    private ActionBeanContext ctx;
    public ActionBeanContext getContext() { return ctx; }
    public void setContext(ActionBeanContext ctx) { this.ctx = ctx; }

    private Date date;
    public Date getDate() {
        return date;
    }
    @DefaultHandler
    public Resolution currentDate() {
        date = new Date();
        return new ForwardResolution(VIEW);
    }
    public Resolution randomDate() {
        long max = System.currentTimeMillis();
        long random = new Random().nextLong() % max;
        date = new Date(random);
        return new ForwardResolution(VIEW);
    }
    private static final String VIEW = "/WEB-INF/jsp/hello.jsp";
}

