<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/login_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<s:form beanclass="ie.books.action.RegistrationActionBean">
			<h2>Register an Account!</h2>
			<p>To join Books.ie fill in your details below.</p>
			<s:label for="customer.firstName">First Name</s:label>
			<s:text name="customer.firstName" value="g"/>
			
			<s:label for="customer.lastName">Last Name</s:label>
			<s:text name="customer.lastName" value="g"/>
			
			<s:label for="customer.email">Email</s:label>
			<s:text name="customer.email" value="g"/>
			
			<s:label for="customer.password">Password</s:label>
			<s:password name="customer.password" value="g"/>
			
			<s:label for="confirmPassword">Confirm Password</s:label>
			<s:password name="confirmPassword" value="g"/>
			
			<s:label for="customer.address">Address</s:label>
			<s:text name="customer.address" value="g"/>
			<br>
			<s:submit name="register" value="Continue"/>
            <s:submit name="cancel" value="Cancel"/>
		</s:form>
	</s:layout-component>
</s:layout-render>