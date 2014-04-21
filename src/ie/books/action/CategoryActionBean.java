package ie.books.action;

import java.util.List;

import ie.books.model.Category;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

public class CategoryActionBean extends BaseActionBean implements ValidationErrorHandler {

	private static final String VIEW = "/WEB-INF/jsp/books.jsp";
    private static final String DONE = "/WEB-INF/jsp/books.jsp";
    
    @DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    
    public Resolution addCategory() {
        return save();
    }
    public Resolution save() {
        categoryDao.save(category);
        categoryDao.commit();
        return new RedirectResolution(getClass(), "done");
    }
    @DontValidate
    public Resolution done() {
        return new ForwardResolution(DONE);
    }
    @DontValidate
    public Resolution cancel() {
        return new RedirectResolution(LoginActionBean.class);
    }
    
    @ValidateNestedProperties({
    	@Validate(field="name" , required=true),
    })
    private Category category;
    
    public Category getCategory(){
    	return category;
    }
    
    public void setCategory(Category category){
    	this.category = category;
    }
    
    public List<Category> getCategories(){
    	return categoryDao.read();
    }
	
	@Override
	public Resolution handleValidationErrors(ValidationErrors arg0)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
