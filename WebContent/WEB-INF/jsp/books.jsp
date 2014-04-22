<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean beanclass="ie.books.action.CategoryActionBean" id="categoryBean"/>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<ul>
			<li><a href="">Top Sellers</a></li>
			<li><a href="">Featured</a></li>
			<li><a href="">Promotions</a></li>
		</ul>
		<ul>
			<c:forEach var="category" items="${categoryBean.categories}">
				<li>
				<s:link beanclass="ie.books.action.BookActionBean">
					<s:param name="categoryId" value="${category.id }"/>
					${category.name}
				</s:link>
				</li>
			</c:forEach>
		</ul>
	</s:layout-component>
	<s:layout-component name="content">
		<div id="books">
			<h2>Featured Books</h2>
			<ul>
				<c:forEach var="book" items="${categoryBean.category.books}">
				<li class="book">
				<s:link beanclass="ie.books.action.BookActionBean" event="viewBook">
					<s:param name="bookId" value="${book.id }"/>
					<img src="${book.imageUrl}"/>
					<p>${book.title}</p>
					<p>by ${book.author}</p>
					<p>${book.price}</p>
				</s:link>
				</li>
			</c:forEach>
			</ul>
		</div>
	</s:layout-component>
</s:layout-render>