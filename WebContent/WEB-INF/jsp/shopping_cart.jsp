<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/account_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Your Shopping Cart</h1>
		<c:forEach var="item" items="${actionBean.context.customer.shoppingCart}">
			<p>${item.book.title } - ${item.quantity }</p>
		</c:forEach>
		<s:link beanclass="ie.books.action.ShoppingCartActionBean" event="emptyCart">Empty Cart</s:link>
		<s:link beanclass="ie.books.action.SaleActionBean" event="checkout">Checkout</s:link>
	</s:layout-component>
</s:layout-render>
