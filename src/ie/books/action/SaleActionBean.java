package ie.books.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.books.model.Sale;
import ie.books.model.SaleItem;
import ie.books.model.ShoppingCartItem;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class SaleActionBean extends BaseActionBean {

	private static final String VIEW = "/WEB-INF/jsp/sales.jsp";
	
	@DefaultHandler
	@DontValidate
    public Resolution view() {
        return new ForwardResolution(VIEW);
    }
	
    public Resolution checkout() {
    	    	
    	Sale sale = new Sale();
    	sale.setCustomer(getCustomer());
    	sale.setPurchaseDate(new Date());
    	
    	List<ShoppingCartItem> cart = getCustomer().getShoppingCart();
    	
    	List<SaleItem> saleItems = new ArrayList<SaleItem>();
    	for (ShoppingCartItem cartItem: cart){
    		SaleItem saleItem = new SaleItem();
    		saleItem.setBook(cartItem.getBook());
    		saleItem.setQuanitity(cartItem.getQuantity());
    		saleItem.setUnitPrice(cartItem.getBook().getPrice());
    		saleItem.setSale(sale);
    		
    		saleItems.add(saleItem);
    		
    		saleItemDao.save(saleItem);
    		
    	}
    	
    	sale.setItems(saleItems);
    	
    	saleDao.save(sale);
    	saleItemDao.commit();
    	saleDao.commit();
    	
        return new ForwardResolution(VIEW);
    }
}
