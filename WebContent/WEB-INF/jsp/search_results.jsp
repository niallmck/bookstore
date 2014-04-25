<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<script src="js/sortHighlight.js" ></script>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">

	<s:layout-component name="content">
		<div id="sortBar">
			<p>
				<span>Author</span>
				<s:link beanclass="${actionBean.class}" event="search">
					<s:param name="sortBy" value="Author"/>
					<s:param name="searchTerm" value="${actionBean.searchTerm}"/>
					<img src="css/img/up.png" id="author"/>
				</s:link>
				
				<s:link beanclass="${actionBean.class}" event="search">
					<s:param name="sortBy" value="Author"/>
					<s:param name="reverse" value="true"/>
					<s:param name="searchTerm" value="${actionBean.searchTerm}"/>
					<img src="css/img/down.png" id="authorreverse"/>
				</s:link>
			</p>
			
			<p>
				<span>Title</span>
				<s:link beanclass="${actionBean.class}" event="search">
					<s:param name="sortBy" value="Title"/>
					<s:param name="searchTerm" value="${actionBean.searchTerm}"/>
					<img src="css/img/up.png" id="title"/>
				</s:link>
				
				<s:link beanclass="${actionBean.class}" event="search">
					<s:param name="sortBy" value="Title"/>
					<s:param name="reverse" value="true"/>
					<s:param name="searchTerm" value="${actionBean.searchTerm}"/>
					<img src="css/img/down.png" id="titlereverse"/>
				</s:link>
			</p>
			
			<p>
				<span>Price</span>
				<s:link beanclass="${actionBean.class}" event="search">
					<s:param name="sortBy" value="Price"/>
					<s:param name="searchTerm" value="${actionBean.searchTerm}"/>
					<img src="css/img/up.png" id="price"/>
				</s:link>
				
				<s:link beanclass="${actionBean.class}" event="search">
					<s:param name="sortBy" value="Price"/>
					<s:param name="reverse" value="true"/>
					<s:param name="searchTerm" value="${actionBean.searchTerm}"/>
					<img src="css/img/down.png" id="pricereverse"/>
				</s:link>
			</p>
			
		</div>
		<div id="books">
			<h2>Titles like <span class="searchTerm">'${actionBean.searchTerm}'</span></h2>
			<c:choose>
			<c:when  test="${actionBean.titleBooks.size()  > 0}">	
			<ul>
				<c:forEach var="book" items="${actionBean.titleBooks}">
				<li class="book">
				<s:link beanclass="ie.books.action.BookActionBean" event="viewBook">
					<s:param name="bookId" value="${book.id }"/>
					<img src="${book.imageUrl}"/>
					<p>${book.title}</p>
					<p>by ${book.author}</p>
					<p>${book.displayPrice}</p>
				</s:link>
				</li>
			</c:forEach>
			</ul>
			</c:when>
			<c:otherwise>
				<p>No Results</p>
			</c:otherwise>
			</c:choose>
			
			<h2>Authors like <span class="searchTerm">'${actionBean.searchTerm}'</span></h2>
			<c:choose>
			<c:when test="${actionBean.authorBooks.size()  > 0}">	
			<ul>
				<c:forEach var="book" items="${actionBean.authorBooks}">
				<li class="book">
				<s:link beanclass="ie.books.action.BookActionBean" event="viewBook">
					<s:param name="bookId" value="${book.id }"/>
					<img src="${book.imageUrl}"/>
					<p>${book.title}</p>
					<p>by ${book.author}</p>
					<p>${book.displayPrice}</p>
				</s:link>
				</li>
			</c:forEach>
			</ul>
			</c:when>
			<c:otherwise>
				<p>No Results</p>
			</c:otherwise>
			</c:choose>
		</div>
	</s:layout-component>
</s:layout-render>