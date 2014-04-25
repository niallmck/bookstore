package ie.books.action;


import java.util.Collections;
import java.util.List;

import ie.books.compare.BookAuthorComparator;
import ie.books.compare.BookCompareType;
import ie.books.compare.BookPriceComparator;
import ie.books.compare.BookTitleComparator;
import ie.books.model.Book;
import ie.books.model.Category;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

public class BookActionBean extends BaseActionBean implements ValidationErrorHandler {
	
    private static final String VIEW = "/WEB-INF/jsp/books.jsp";
    private static final String DONE = "/WEB-INF/jsp/books.jsp";
    private static final String VIEW_BOOK = "/WEB-INF/jsp/book_view.jsp";
    private static final String SEARCH_RESULTS = "/WEB-INF/jsp/search_results.jsp";
    
    
    
    @DefaultHandler
    @DontValidate
    public Resolution view() {
    	
    	// If a category is specified, only get books from that category.
    	// Otherwise, get all books.
    	if (categoryId != null){
    		books = getCategory().getBooks();
    		setPageTitle(getCategory().getName());
    	}
    	else{
    		setPageTitle("All Books");
    		books = bookDao.read();
    	}
    	if (sortBy != null){
    		sortBooks(books);
    	}
    	
        return new ForwardResolution(VIEW);
    }
    
    @DontValidate
    public Resolution search(){
    	authorBooks = bookDao.searchAuthor(searchTerm);
    	titleBooks = bookDao.searchTitle(searchTerm);
    	
    	if (sortBy != null){
	    	sortBooks(authorBooks);
	    	sortBooks(titleBooks);
    	}
    	return new ForwardResolution(SEARCH_RESULTS);
    }
    
    @DontValidate
    public Resolution promotions(){
    	setPageTitle("Promotions");
    	
    	books = bookDao.getDiscountedBooks();
    	
    	return new ForwardResolution(VIEW);
    }
    
    @DontValidate
    public Resolution bestSellers(){
    	setPageTitle("Best Selling Books");
    	
    	books = bookDao.getBestSellingBooks();
    	
    	return new ForwardResolution(VIEW);
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
    
    
    private BookCompareType sortBy;
    
    public void setSortBy(String sort){
    	sortBy = BookCompareType.valueOf(sort.toUpperCase());
    }
    
    private boolean reverse;
    
    public void setReverse(boolean reverse){
    	this.reverse = reverse;
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
    
    private List<Book> books;
    
    public List<Book> getBooks(){
    	return books;
    }
    
    public void setBooks(List<Book> books){
    	this.books = books;
    }
    
    private List<Book> authorBooks;
    
    public List<Book> getAuthorBooks(){
    	return authorBooks;
    }
    
    private List<Book> titleBooks;
    
    public List<Book> getTitleBooks(){
    	return titleBooks;
    }
    
    private Integer categoryId;
    
    public void setCategoryId(Integer id){
    	categoryId = id;
    }
    
    public Category getCategory(){
    	if (categoryId != null)
			return categoryDao.read(categoryId);
		return null;
    }
    
    private String searchTerm;
    
    public void setSearchTerm(String searchTerm){
    	this.searchTerm = searchTerm;
    }
    
    public String getSearchTerm(){
    	return searchTerm;
    }
    
    private String pageTitle;
    
    public String getPageTitle(){
    	return pageTitle;
    }
    
    public void setPageTitle(String title){
    	pageTitle = title;
    }

    @Override
	public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
		if (errors.hasFieldErrors()) {
			errors.addGlobalError(
			new SimpleError("All fields are required." ));
			}
			return null;
	}
	
}
