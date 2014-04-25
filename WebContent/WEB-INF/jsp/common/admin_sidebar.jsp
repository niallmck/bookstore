
<s:useActionBean beanclass="ie.books.action.CategoryActionBean" id="categoryBean"/>
<ul>
	<li><s:link beanclass="ie.books.action.AdminActionBean">Admin</s:link></li>
	<li><s:link beanclass="ie.books.action.AdminActionBean" event="addCategory">Add Category</s:link></li>
	<li><s:link beanclass="ie.books.action.AdminActionBean" event="addBook">Add Book</s:link></li>
	<li><s:link beanclass="ie.books.action.AdminActionBean" event="customers">Customers</s:link></li>
	
</ul>

<ul>
	<li><s:link beanclass="ie.books.action.AdminActionBean" event="books">Books</s:link></li>
	<c:forEach var="category" items="${categoryBean.categories}">
		<li>
		<s:link beanclass="ie.books.action.AdminActionBean" event="books">
			<s:param name="categoryId" value="${category.id }"/>
			${category.name}
		</s:link>
		</li>
	</c:forEach>
</ul>