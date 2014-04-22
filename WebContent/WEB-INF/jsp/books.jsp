<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean beanclass="ie.books.action.CategoryActionBean" id="categoryBean"/>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">

	<s:layout-component name="content">
		<div id="books">
			<h2>${categoryBean.category.name}</h2>
			<ul>
				<c:forEach var="book" items="${categoryBean.category.books}">
				<li class="book">
				<s:link beanclass="ie.books.action.BookActionBean" event="viewBook">
					<s:param name="bookId" value="${book.id }"/>
					<img src="${book.imageUrl}"/>
					<p>${book.title}</p>
					<p>by ${book.author}</p>
					<p>${book.displayPrice}</p>
				</s:link>
				</li>
			</c:forEach>
			</ul>
		</div>
	</s:layout-component>
</s:layout-render>