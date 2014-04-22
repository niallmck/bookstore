<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean beanclass="ie.books.action.CategoryActionBean" id="categoryBean"/>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/account_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<h1>Write a Review</h1>
		<h2>${actionBean.book.title} by ${actionBean.book.author}</h2>
		<s:form beanclass="ie.books.action.ReviewActionBean">
			
			<s:label for="review.rating">Rating</s:label>	
			<select name="review.rating">
				<option value="1">1 out of 5</option>
				<option value="2">2 out of 5</option>
				<option selected="selected" value="3">3 out of 5</option>
				<option value="4">4 out of 5</option>
				<option value="5">5 out of 5</option>
			</select>
			
			<s:label for="review.message">Message</s:label>
			<s:text name="review.message"/>
			
			<input name="review.book" type="hidden" value="${actionBean.book.id }" />
			<input name="review.customer" type="hidden" value="${actionBean.context.customer.id }" />
			
			

			<br>

			<s:submit name="review" value="Submit Review"/>
		</s:form>
	</s:layout-component>
</s:layout-render>