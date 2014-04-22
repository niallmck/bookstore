<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/account_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Your Books</h1>
		<c:forEach var="sale" items="${actionBean.context.customer.sales}">
			<c:forEach var="item" items="${sale.items}">
				<p>${item.book.title }</p>
				<s:link beanclass="ie.books.action.ReviewActionBean" >
					<s:param name="bookId" value="${item.book.id }"/>
					Review
				</s:link>
			</c:forEach>
		</c:forEach>
	</s:layout-component>
</s:layout-render>
