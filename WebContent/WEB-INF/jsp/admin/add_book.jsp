<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean beanclass="ie.books.action.CategoryActionBean" id="categoryBean"/>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/admin_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Add a Book</h1>
		<s:form beanclass="ie.books.action.BookActionBean">
			<s:label for="book.title">Title</s:label>
			<s:text name="book.title"/>
			
			<s:label for="book.author">Author</s:label>
			<s:text name="book.author"/>
			
			<s:label for="book.price">Price</s:label>
			<s:text name="book.price"/>
			
			<s:label for="book.imageUrl">Image Url</s:label>
			<s:text name="book.imageUrl"/>
			
			<s:label for="book.stock">Stock</s:label>
			<s:text name="book.stock"/>

			<s:label for="book.category">Category</s:label>	
			<select name="book.category">
			<c:forEach var="category" items="${categoryBean.categories}">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
			</select>

			<br>

			<s:submit name="register" value="Add Book"/>
		</s:form>
	</s:layout-component>
</s:layout-render>