<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/login_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<s:form beanclass="ie.books.action.AdminLoginActionBean">
			<h2>Log In</h2>
			<s:label for="email">Email</s:label>
			<s:text name="email"/>
			
			<s:label for="password">Password</s:label>
			<s:password name="password"/>
					<br>
			<s:submit name="login" value="Log In"/>
		</s:form>
	</s:layout-component>
</s:layout-render>