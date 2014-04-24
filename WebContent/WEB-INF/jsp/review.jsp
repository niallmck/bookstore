<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/account_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
	<h1>Write a Review</h1>
	<div id="bookImage">
		<img src="${actionBean.book.imageUrl}"/>
	</div>
	<div id="bookDetails">
		<h3>${actionBean.book.title}</h3>
		<span>Title</span>
		<h3>${actionBean.book.author}</h3>
		<span>Author</span>
		<h3>${actionBean.book.displayPrice}</h3>
		<span>Price</span>
		<h3>${actionBean.book.averageRating}</h3>
		<span>Average Rating</span>
	</div>
		
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
			<s:textarea name="review.message"/>
			
			<s:hidden name="review.book"
			value="${actionBean.book.id }" />
			<s:hidden name="review.customer"  
			value="${actionBean.context.customer.id }" />
			

			<br>

			<s:submit name="submit" value="Submit Review"/>
		</s:form>
	</s:layout-component>
</s:layout-render>