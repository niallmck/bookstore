package ie.books.action;

import java.util.List;

import ie.books.model.Book;
import ie.books.model.ShoppingCartItem;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;

public class ShoppingCartActionBean extends BaseActionBean {

	private static final String VIEW = "/WEB-INF/jsp/shopping_cart.jsp";
	
	@DefaultHandler
	@DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
	
	public Resolution addItem(){
		
		boolean newItem = true;
		for (ShoppingCartItem item: getCustomer().getShoppingCart()){
			if (item.getBook() == getBook()){
				item.incrementQuantity();
				newItem = false;
				shoppingCartItemDao.save(item);
				shoppingCartItemDao.commit();
				customerDao.commit();
			}
		}
		if(newItem){
			ShoppingCartItem item = new ShoppingCartItem(getCustomer(), getBook());
			getCustomer().addToCart(item);
			shoppingCartItemDao.save(item);
			shoppingCartItemDao.commit();
			customerDao.commit();
		}
		return new ForwardResolution(VIEW);
	}
	
	public Resolution removeItem(){
		for (ShoppingCartItem item: getCustomer().getShoppingCart()){
			if (item.getBook() == getBook()){
				shoppingCartItemDao.delete(item);
				shoppingCartItemDao.commit();
				customerDao.commit();
			}
		}
		return new RedirectResolution(ShoppingCartActionBean.class, "view");
	}
	
	public Resolution emptyCart(){
		for (ShoppingCartItem item: getCustomer().getShoppingCart()){
			shoppingCartItemDao.delete(item);
			shoppingCartItemDao.commit();
		}
		getCustomer().emptyCart();
		customerDao.commit();
		return new ForwardResolution(VIEW);
	}
	
	private int bookId;
    
    public void setBookId(int id){
    	bookId = id;
    }
    
    public Book getBook(){
    	return bookDao.read(bookId);
    }
    
    public List<ShoppingCartItem> getShoppingCart(){
    	return getCustomer().getShoppingCart();
    }
}
