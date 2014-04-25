<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
	<s:layout-component name="content">
	<h1>Book Details</h1>
	<div id="bookImage">
		<img src="${actionBean.bookDetails.imageUrl}"/>
	</div>
	<div id="bookDetails">
		<h3>${actionBean.bookDetails.title}</h3>
		<span>Title</span>
		<h3>${actionBean.bookDetails.author}</h3>
		<span>Author</span>
		<h3>&#8364;${actionBean.bookDetails.displayPrice}
		
		<c:if test="${actionBean.bookDetails.discountPercentage > 0 }">
		<span>(${actionBean.bookDetails.discountPercentage} % off - Was &#8364;${actionBean.bookDetails.originalPrice})</span>
			 
		</c:if>
		
		</h3>
		<span>Price</span>
		<h3>${actionBean.bookDetails.averageRating}</h3>
		<span>Average Rating</span>
		<s:link beanclass="ie.books.action.ShoppingCartActionBean" event="addItem">
			<s:param name="bookId" value="${actionBean.bookDetails.id }"/>
			Add to Cart
		</s:link>
	</div>
	
	<c:if test="${actionBean.bookDetails.reviews.size()  > 0}">		
	<div id="reviews">
		<h1>Reviews</h1>
		<c:forEach var="review" items="${actionBean.bookDetails.reviews}">
			
			<div class="review">
				<h2>
					<span class="${review.rating }stars">
						<c:forEach begin="1" end="${review.rating}" var="i">
						<img src="css/img/star.png"/>
						</c:forEach>
					</span>
				
				
				${review.customer.fullName}</h2>
				<p id="${review.id}">${review.message}</p>
			</div>
		</c:forEach>
	</div>
	</c:if>
	</s:layout-component>
</s:layout-render>