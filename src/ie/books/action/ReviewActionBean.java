package ie.books.action;

import ie.books.model.Book;
import ie.books.model.Review;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

public class ReviewActionBean extends BaseActionBean implements ValidationErrorHandler{
	
	private static final String VIEW = "/WEB-INF/jsp/review.jsp";
	private static final String DONE = "/WEB-INF/jsp/account_view.jsp";
	
	@DefaultHandler
	@DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
	
	public Resolution submit(){
		return save();
	}
	
	public Resolution save(){
		Review review = getReview();
		reviewDao.save(review);
        reviewDao.commit();
        return new ForwardResolution(DONE);
	}
	
	@DontValidate
    public Resolution done() {
        return new ForwardResolution(DONE);
    }
	
	private int bookId;
    
    public void setBookId(int id){
    	bookId = id;
    }
    
    public Book getBook(){
    	return bookDao.read(bookId);
    }
    
    
    @ValidateNestedProperties({
    	@Validate(field="rating" , required=true),
    	@Validate(field="message" , required=true),
    	@Validate(field="book" , required=true),
    	@Validate(field="customer" , required=true)
    })
    
    private Review review;
    
    private Integer reviewId;
    
    
    public void setReview(Review review){
    	this.review = review;
    }
    
    
    public void setReviewId(Integer id){
    	reviewId = id;
    }
    
    public Review getReview(){
    	return review;
    }

	@Override
	public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
		
		String e = errors.toString();
		if (errors.hasFieldErrors()) {
			errors.addGlobalError(
			new SimpleError("All fields are required." ));
			}
			return null;
	}
	
    

}
