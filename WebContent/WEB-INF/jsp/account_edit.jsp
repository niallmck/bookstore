<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
<!--<s:useActionBean beanclass="ie.books.action.AccountActionBean" id="account"/>-->
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/account_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Edit Details</h1>
		<s:form beanclass="ie.books.action.AccountActionBean">
			<s:label for="firstName">First Name</s:label>
			<s:text name="firstName" value="${actionBean.context.customer.firstName}"/>
			
			<s:label for="lastName">Last Name</s:label>
			<s:text name="lastName" value="${actionBean.context.customer.lastName}"/>
			
			<s:label for="oldPassword">Current Password</s:label>
			<s:password name="oldPassword"/>
			
			
			<s:label for="newPassword">New Password</s:label>
			<s:password name="newPassword"/>
			
			<s:label for="confirmPassword">Confirm Password</s:label>
			<s:password name="confirmPassword"/>
			
			
			<s:label for="address">Address</s:label>
			<s:text name="address" value="${actionBean.context.customer.address}"/>
			<br>
			<s:submit name="update" value="Save Changes"/>
		</s:form>
	</s:layout-component>
</s:layout-render>