package ie.books.action;

import ie.books.model.Book;
import ie.books.model.Customer;
import ie.books.model.Review;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class ReviewActionBean extends BaseActionBean{
	
private static final String VIEW = "/WEB-INF/jsp/review.jsp";
	
	@DefaultHandler
	@DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
	
	public Resolution review(){
		reviewDao.save(review);
        reviewDao.commit();
		return new ForwardResolution(VIEW);
	}
	
	private int bookId;
    
    public void setBookId(int id){
    	bookId = id;
    }
    
    public Book getBook(){
    	return bookDao.read(bookId);
    }
    
    
    private int customerId;
    
    public void setCustomerkId(int id){
    	customerId = id;
    }
    
    public Customer getCustomer(){
    	return customerDao.read(customerId);
    }
    
    private Review review;
    
    
    public void setReview(Review review){
    	this.review = review;
    }
    
    private int reviewId;
    
    public void setReviewId(int id){
    	reviewId = id;
    }
    
    public Review getReview(){
    	return reviewDao.read(reviewId);
    }
    

}
