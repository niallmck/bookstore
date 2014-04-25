<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/admin_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Customers</h1>
			<ul id="customers">
				<c:forEach var="customer" items="${actionBean.customers}">
				<li class="customer">
				<s:link beanclass="ie.books.action.AdminActionBean" event="viewCustomer">
					<s:param name="customerId" value="${customer.id }"/>
					${customer.fullName}
				</s:link>
				</li>
			</c:forEach>
			</ul>
	</s:layout-component>
</s:layout-render>