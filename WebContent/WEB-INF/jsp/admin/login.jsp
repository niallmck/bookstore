<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<ul>
			<li><a href="">Log In</a></li>
		</ul>
	</s:layout-component>
	<s:layout-component name="content">
		<s:form beanclass="ie.books.action.AdminLoginActionBean">
			<h2>Log In</h2>
			<s:label for="email">Email</s:label>
			<s:text name="email" value="admin@books.ie"/>
			
			<s:label for="password">Password</s:label>
			<s:password name="password" value="admin"/>
					<br>
			<s:submit name="login" value="Log In"/>
		</s:form>
	</s:layout-component>
</s:layout-render>