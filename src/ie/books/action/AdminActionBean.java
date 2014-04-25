package ie.books.action;

import ie.books.compare.BookAuthorComparator;
import ie.books.compare.BookCompareType;
import ie.books.compare.BookPriceComparator;
import ie.books.compare.BookTitleComparator;
import ie.books.model.Book;
import ie.books.model.Category;
import ie.books.model.Customer;

import java.util.Collections;
import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class AdminActionBean extends BaseActionBean{
	
	private static final String VIEW = "/WEB-INF/jsp/admin/account.jsp";
	private static final String ADD_CATEGORY = "/WEB-INF/jsp/admin/add_category.jsp";
	private static final String ADD_BOOK = "/WEB-INF/jsp/admin/add_book.jsp";
	private static final String CUSTOMERS = "/WEB-INF/jsp/admin/customers.jsp";
	private static final String VIEW_CUSTOMER = "/WEB-INF/jsp/admin/view_customer.jsp";
	private static final String BOOKS = "/WEB-INF/jsp/admin/books.jsp";
	private static final String MANAGE_BOOK = "/WEB-INF/jsp/admin/manage_book.jsp";
	
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
	
	public Resolution customers(){
		return forward(CUSTOMERS);
	}
	
	public Resolution viewCustomer(){
		return forward(VIEW_CUSTOMER);
	}
	
	public Resolution books(){
		if (getCategory() != null){
    		books = getCategory().getBooks();
    	}
    	else{
    		books = bookDao.read();
    	}
    	if (sortBy != null){
    		sortBooks(books);
    	}
		return forward(BOOKS);
	}
	
	public Resolution manageBook(){
		return forward(MANAGE_BOOK);
	}
	public List<Customer> getCustomers(){
		return customerDao.read();
	}
	
	private Integer customerId;
	
	public void setCustomerId(Integer id){
		customerId = id;
	}
	
	public Customer getCustomer(){
		return customerDao.read(customerId);
	}
	
	private Integer categoryId;
	
	public void setCategoryId(Integer id){
		categoryId = id;
	}
	
	public Category getCategory(){
		return categoryDao.read(categoryId);
	}
	
	private List<Book> books;
 
	public List<Book> getBooks(){
		return books;
	}
	
	public void sortBooks(List<Book> books){
    	// If the user has specified a sort order, use the relevant comparator
    	// to sort the list of books.
		switch(sortBy){
		case AUTHOR:
			Collections.sort(books, new BookAuthorComparator());
			break;
		case PRICE:
			Collections.sort(books, new BookPriceComparator());
			break;
		case TITLE:
			Collections.sort(books, new BookTitleComparator());
			break;
		default:
			break;
    	}
    	
    	// If reverse order is specified, reserved the book list.
    	if (reverse){
    		Collections.reverse(books);
    	}
    }
	
	private BookCompareType sortBy;
    
    public void setSortBy(String sort){
    	sortBy = BookCompareType.valueOf(sort.toUpperCase());
    }
    
    private boolean reverse;
    
    public void setReverse(boolean reverse){
    	this.reverse = reverse;
    }
    
    private Integer bookId;
    
    public void setBookId(Integer id){
    	bookId = id;
    }
    
    public Book getBook(){
    	return bookDao.read(bookId);
    }
}
