<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
<!--<s:useActionBean beanclass="ie.books.action.AccountActionBean" id="account"/>-->
	<s:layout-component name="sidebar">
		<ul>
			<li><s:link beanclass="ie.books.action.AccountActionBean">My Account</s:link></li>
			<li><s:link beanclass="ie.books.action.AccountActionBean" event="edit">Edit Details</s:link></li>
		</ul>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Hello ${actionBean.context.customer.firstName}</h1>
	</s:layout-component>
</s:layout-render>