<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="content">
	<img src="${actionBean.book.imageUrl}"/>
	<h2>${actionBean.book.title}</h2>
	<h3>${actionBean.book.author}</h3>
	<h3>${actionBean.book.price}</h3>
	</s:layout-component>
</s:layout-render>