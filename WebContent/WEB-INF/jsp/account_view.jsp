<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
<!--<s:useActionBean beanclass="ie.books.action.AccountActionBean" id="account"/>-->
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/account_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Hello ${actionBean.context.customer.firstName}</h1>
		
		<br>
		<div id="customerDetails">
			<h2>${actionBean.customer.fullName }</h2>
			<span>Name</span>
			
			<h2>${actionBean.customer.email }</h2>
			<span>Email</span>
			
			<h2>${actionBean.customer.address }</h2>
			<span>Address</span>
		</div>
	</s:layout-component>
</s:layout-render>