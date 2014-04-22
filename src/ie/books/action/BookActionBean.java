package ie.books.action;


import ie.books.model.Book;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

public class BookActionBean extends BaseActionBean implements ValidationErrorHandler {
	
    private static final String VIEW = "/WEB-INF/jsp/books.jsp";
    private static final String DONE = "/WEB-INF/jsp/books.jsp";
    private static final String VIEW_BOOK = "/WEB-INF/jsp/book_view.jsp";
    
    @DefaultHandler
    @DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
    
    public Resolution register() {
        return save();
    }
    public Resolution save() {
        bookDao.save(book);
        bookDao.commit();
        return new RedirectResolution(getClass(), "done");
    }
    @DontValidate
    public Resolution viewBook(){
    	return new ForwardResolution(VIEW_BOOK);
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
    	
    	@Validate(field="title" , required=true),
    	@Validate(field="author" , required=true),
    	@Validate(field="price" , required=true),
    	@Validate(field="imageUrl" , required=true),
    	@Validate(field="stock" , required=true),
    	@Validate(field="category" , required=true)
    	
    })
    private Book book;
    
    private int bookId;
    
    public void setBookId(int id){
    	bookId = id;
    }
    
    public Book getBookDetails(){
    	return bookDao.read(bookId);
    }
    
    public Book getBook(){
    	return book;
    }
    
    public void setBook(Book book){
    	this.book = book;
    }

	@Override
	public Resolution handleValidationErrors(ValidationErrors arg0)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
