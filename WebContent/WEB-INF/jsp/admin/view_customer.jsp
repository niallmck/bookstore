<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/admin_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Customer Details</h1>
		<div id="customerDetails">
			<h2>${actionBean.customer.fullName }</h2>
			<span>Name</span>
			
			<h2>${actionBean.customer.email }</h2>
			<span>Email</span>
			
			<h2>${actionBean.customer.address }</h2>
			<span>Address</span>
		</div>
		
		<div id="sales">
			<c:forEach var="sale" items="${actionBean.customer.salesByDate}">
				<div class="sale">
					<h4>Sale ID: ${sale.id } <span>Date: ${sale.purchaseDate }</span></h4>
					
					
					<c:forEach var="item" items="${sale.items}">
						<span class="title">${item.book.title }</span>
						<span>${item.displayPrice }</span>
						<span>${item.quantity }</span>
						<span>${item.unitPrice * item.quantity }</span>
					</c:forEach>
					<p class="total">Total: <span>${sale.total }</span></p>
				</div>
			</c:forEach>
		</div>

	</s:layout-component>
</s:layout-render>