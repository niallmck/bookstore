<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/admin_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Add a Category</h1>
		<s:form beanclass="ie.books.action.CategoryActionBean">
			<s:label for="category.name">Category</s:label>
			<s:text name="category.name"/>
			
			<s:submit name="addCategory" value="Add Category"/>
		</s:form>
	</s:layout-component>
</s:layout-render>