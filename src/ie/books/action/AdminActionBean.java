package ie.books.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class AdminActionBean extends BaseActionBean{
	
	private static final String VIEW = "/WEB-INF/jsp/admin/account.jsp";
	private static final String ADD_CATEGORY = "/WEB-INF/jsp/admin/add_category.jsp";
	private static final String ADD_BOOK = "/WEB-INF/jsp/admin/add_book.jsp";
	
	@DefaultHandler
	@DontValidate
    public Resolution view() {
		return forward(VIEW);
        
    }
	
	public Resolution addCategory(){
		return forward(ADD_CATEGORY);
	}
	
	public Resolution addBook(){
		return forward(ADD_BOOK);
	}
	
	public Resolution forward(String path){
		if (getContext().getAdmin() != null){
			return new ForwardResolution(path);
		}
		else{
			return new ForwardResolution(AdminLoginActionBean.class);
		}
	}
	

}
