package ie.books.action;

import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;

public class LogoutActionBean extends BaseActionBean {
    public Resolution logout() {
        getContext().logout();
        return new RedirectResolution(LoginActionBean.class);
    }
}
