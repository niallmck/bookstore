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
		<h1>Edit Details</h1>
		<s:form beanclass="ie.books.action.AccountActionBean">
			<s:label for="customer.firstName">First Name</s:label>
			<s:text name="customer.firstName" value="${actionBean.context.customer.firstName}"/>
			
			<s:label for="customer.lastName">Last Name</s:label>
			<s:text name="customer.lastName" value="${actionBean.context.customer.lastName}"/>
			
			<!-- 
			<s:label for="customer.password">Password</s:label>
			<s:password name="customer.password"/>
			
			<s:label for="confirmPassword">Confirm Password</s:label>
			<s:password name="confirmPassword"/>
			-->
			
			<s:label for="customer.address">Address</s:label>
			<s:text name="customer.address" value="${actionBean.context.customer.address}"/>
			
			<s:submit name="update" value="Save Changes"/>
		</s:form>
	</s:layout-component>
</s:layout-render>