package ie.books.dao.impl.stripersist;

import ie.books.dao.CategoryDao;
import ie.books.model.Category;

public class CategoryDaoImpl extends BaseDaoImpl<Category,Integer> implements CategoryDao{

	@Override
	public Category findByName(String name) {
		return findBy("name", name);
	}

}
