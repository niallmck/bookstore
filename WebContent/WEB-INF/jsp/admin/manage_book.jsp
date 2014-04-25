<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/admin_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
	<h1>Manage Book</h1>
	<div id="bookImage">
		<img src="${actionBean.book.imageUrl}"/>
	</div>
	<div id="bookDetails">
		<h3>${actionBean.book.title}</h3>
		<span>Title</span>
		<h3>${actionBean.book.author}</h3>
		<span>Author</span>
		<h3>&#8364;${actionBean.book.displayPrice}
		
		<c:if test="${actionBean.book.discountPercentage > 0 }">
		<span>(${actionBean.book.discountPercentage} % off - Was &#8364;${actionBean.book.originalPrice})</span>
			 
		</c:if>
		
		</h3>
		<span>Price</span>
		<h3>${actionBean.book.stock}</h3>
		<span>Stock Available</span>
	</div>
	
	<s:form beanclass="ie.books.action.AdminActionBean">
		<s:label for="additionalStock">Add Stock</s:label>
		<s:text name="additionalStock"/>
		<s:hidden name="bookId" value="${actionBean.book.id}"></s:hidden>
		<br>
		<s:submit name="addStock" value="Add Stock"/>
	</s:form>
	
	<s:form beanclass="ie.books.action.AdminActionBean">
		<s:label for="discount">Set Discount</s:label>
		<s:text name="discount"/>
		<s:hidden name="bookId" value="${actionBean.book.id}"></s:hidden>
		<br>
		<s:submit name="applyDiscount" value="Apply Discount"/>
	</s:form>

	</s:layout-component>
</s:layout-render>