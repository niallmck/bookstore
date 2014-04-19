package ie.books.dao.impl.stripersist;

import ie.books.dao.BaseDaoImpl;
import ie.books.dao.CustomerDao;
import ie.books.model.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer, Integer> implements CustomerDao {

	@Override
	public Customer findByEmail(String email) {
		return findBy("email", email);
	}

}
