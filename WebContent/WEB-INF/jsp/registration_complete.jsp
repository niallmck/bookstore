<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/login_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<p>Registration Complete!</p>
	</s:layout-component>
</s:layout-render>