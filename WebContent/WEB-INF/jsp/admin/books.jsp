<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<script src="js/sortHighlight.js" ></script>
<s:layout-render name="/WEB-INF/jsp/common/main_layout.jsp">
<s:layout-component name="sidebar">
		<%@include file="/WEB-INF/jsp/common/admin_sidebar.jsp" %>
	</s:layout-component>
	<s:layout-component name="content">
		<div id="sortBar">
			<p>
				<span>Author</span>
				<s:link beanclass="${actionBean.class}" event="books">
					<s:param name="sortBy" value="Author"/>
					<s:param name="categoryId" value="${actionBean.category.id}"/>
					<img src="css/img/up.png" id="author"/>
				</s:link>
				
				<s:link beanclass="${actionBean.class}" event="books">
					<s:param name="sortBy" value="Author"/>
					<s:param name="reverse" value="true"/>
					<s:param name="categoryId" value="${actionBean.category.id}"/>
					<img src="css/img/down.png" id="authorreverse"/>
				</s:link>
			</p>
			
			<p>
				<span>Title</span>
				<s:link beanclass="${actionBean.class}" event="books">
					<s:param name="sortBy" value="Title"/>
					<s:param name="categoryId" value="${actionBean.category.id}"/>
					<img src="css/img/up.png" id="title"/>
				</s:link>
				
				<s:link beanclass="${actionBean.class}" event="books">
					<s:param name="sortBy" value="Title"/>
					<s:param name="reverse" value="true"/>
					<s:param name="categoryId" value="${actionBean.category.id}"/>
					<img src="css/img/down.png" id="titlereverse"/>
				</s:link>
			</p>
			
			<p>
				<span>Price</span>
				<s:link beanclass="${actionBean.class}" event="books">
					<s:param name="sortBy" value="Price"/>
					<s:param name="categoryId" value="${actionBean.category.id}"/>
					<img src="css/img/up.png" id="price"/>
				</s:link>
				
				<s:link beanclass="${actionBean.class}" event="books">
					<s:param name="sortBy" value="Price"/>
					<s:param name="reverse" value="true"/>
					<s:param name="categoryId" value="${actionBean.category.id}"/>
					<img src="css/img/down.png" id="pricereverse"/>
				</s:link>
			</p>
			
		</div>
		<div id="books">
			<h2>${actionBean.category.name}</h2>
			<ul>
				<c:forEach var="book" items="${actionBean.books}">
				<li class="book">
				<s:link beanclass="ie.books.action.AdminActionBean" event="manageBook">
					<s:param name="bookId" value="${book.id }"/>
					<img src="${book.imageUrl}"/>
					<p>${book.title}</p>
					<p>by ${book.author}</p>
					<p>&#8364;${book.displayPrice}</p>
				</s:link>
				</li>
			</c:forEach>
			</ul>
		</div>
	</s:layout-component>
</s:layout-render>