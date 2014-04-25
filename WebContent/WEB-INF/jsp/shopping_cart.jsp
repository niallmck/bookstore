<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/account_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Your Shopping Cart</h1>
		
		
		<c:choose>
		<c:when  test="${actionBean.context.customer.shoppingCart.size()  > 0}">
			
			<c:forEach var="item" items="${actionBean.context.customer.shoppingCart}">
				<div class="bookItem">
					<img src="${item.book.imageUrl }" />
					<div>
					<p>${item.book.title }</p>
					<p>${item.book.author }</p>
					<s:link beanclass="ie.books.action.ShoppingCartActionBean" event="removeItem">
						<s:param name="bookId" value="${item.book.id }"/>
						Remove
					</s:link>
					</div>
				</div>
			</c:forEach>
			
			
			
			<div id="cartTotal">
			<h2>Total: &#8364;${actionBean.context.customer.cartTotal}</h2>
			<s:link class="cartButton" beanclass="ie.books.action.ShoppingCartActionBean" event="emptyCart">Empty Cart</s:link>
			<s:link class="cartButton"  beanclass="ie.books.action.SaleActionBean" event="checkout">Checkout</s:link>
			</div>
		
		</c:when>
		
		
		<c:otherwise>
			
			<p>Your cart is empty. Go buy some books!</p>
		
		</c:otherwise>
		</c:choose>
		
		
		
	</s:layout-component>
</s:layout-render>
