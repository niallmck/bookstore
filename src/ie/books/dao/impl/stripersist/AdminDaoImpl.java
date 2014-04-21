package ie.books.dao.impl.stripersist;

import ie.books.dao.AdminDao;
import ie.books.model.Admin;

public class AdminDaoImpl extends BaseDaoImpl<Admin,Integer> implements AdminDao{

	@Override
	public Admin findByEmail(String email) {
		return findBy("email", email);
	}

}
