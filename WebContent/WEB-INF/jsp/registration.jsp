<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<ul>
			<li><a href="">New Account</a></li>
		</ul>
	</s:layout-component>
	<s:layout-component name="content">
		<s:form beanclass="ie.books.action.RegistrationActionBean">
			<h2>Register an Account!</h2>
			<p>To join Books.ie fill in your details below.</p>
			<s:label for="customer.firstName">First Name</s:label>
			<s:text name="customer.firstName"/>
			
			<s:label for="customer.lastName">Last Name</s:label>
			<s:text name="customer.lastName"/>
			
			<s:label for="customer.email">Email</s:label>
			<s:text name="customer.email"/>
			
			<s:label for="customer.password">Password</s:label>
			<s:password name="customer.password"/>
			
			<s:label for="confirmPassword">Confirm Password</s:label>
			<s:password name="confirmPassword"/>
			
			<s:label for="customer.address">Address</s:label>
			<s:text name="customer.address"/>
			
			<s:submit name="register" value="Continue"/>
            <s:submit name="cancel" value="Cancel"/>
		</s:form>
	</s:layout-component>
</s:layout-render>