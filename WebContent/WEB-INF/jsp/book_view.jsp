<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="content">
	<img src="${actionBean.bookDetails.imageUrl}"/>
	<h2>${actionBean.bookDetails.title}</h2>
	<h3>${actionBean.bookDetails.author}</h3>
	<h3>${actionBean.bookDetails.displayPrice}</h3>
	<s:link beanclass="ie.books.action.ShoppingCartActionBean" event="addItem">
					<s:param name="bookId" value="${actionBean.bookDetails.id }"/>
					Add to Cart
				</s:link>
	</s:layout-component>
</s:layout-render>