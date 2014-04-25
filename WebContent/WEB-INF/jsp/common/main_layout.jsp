<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:useActionBean beanclass="ie.books.action.CategoryActionBean" id="categoryBean"/>
<s:layout-definition>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/Books/css/style.css">
		<title>Welcome to Books.ie</title>
	</head>
	<body>
		<div id="header">
			<div id="headerContent">
			<a href="/Books/"><img src="/Books/css/img/logo.png" alt="books.ie"/></a>
	
			<div id="searchBar">			
				<s:form beanclass="ie.books.action.BookActionBean">
					<s:text name="searchTerm"/><s:submit name="search" value="Search"/>
				</s:form>
			</div>
	
			<div id="accountSection">
				
				
				<c:choose>
					<c:when test="${actionBean.context.admin != null}">
						<s:link id="logOut" beanclass="ie.books.action.LogoutActionBean">Log Out</s:link>
						<s:link id="myAccount" beanclass="ie.books.action.AdminActionBean">Admin</s:link>
					</c:when>
					<c:when test="${actionBean.context.customer == null}">
						<s:link id="logIn" beanclass="ie.books.action.LoginActionBean">Log In</s:link>
						<s:link id="signUp" beanclass="ie.books.action.RegistrationActionBean">Sign Up</s:link>
					</c:when>
					<c:otherwise>
						<s:link id="cartIcon" beanclass="ie.books.action.ShoppingCartActionBean"><img src="css/img/cart.png"/>
						
						
						<c:if test="${actionBean.context.customer.shoppingCart.size() > 0 }">
							<span>${actionBean.context.customer.shoppingCart.size()}</span>
						</c:if>
						
						
						</s:link>
						<s:link id="logOut" beanclass="ie.books.action.LogoutActionBean">Log Out</s:link>
						<s:link id="myAccount" beanclass="ie.books.action.AccountActionBean">${actionBean.context.customer.firstName}</s:link>
					</c:otherwise>
				</c:choose>
			</div>
			</div>
		</div>
		
		<div id="container">
			<div id="navSidebar">
			<s:layout-component name="sidebar">
				<ul>
					<li><s:link beanclass="ie.books.action.BookActionBean" event="bestSellers">Best Sellers</s:link></li>
					<li><s:link beanclass="ie.books.action.BookActionBean" event="promotions">Promotions</s:link></li>
				</ul>
				<ul>
					<li><s:link beanclass="ie.books.action.BookActionBean">All Books</s:link></li>
					<c:forEach var="category" items="${categoryBean.categories}">
						<li>
						<s:link beanclass="ie.books.action.BookActionBean">
							<s:param name="categoryId" value="${category.id }"/>
							${category.name}
						</s:link>
						</li>
					</c:forEach>
				</ul>
				</s:layout-component>
			</div><div id="content">
				<s:layout-component name="content">
				</s:layout-component>
			</div><div id="promoSidebar">
				<h3>On Sale</h3>
				<c:forEach var="book" items="${actionBean.discountedBooks}">
					<div class="promoLink">
					<s:link beanclass="ie.books.action.BookActionBean" event="viewBook">
						<s:param name="bookId" value="${book.id }"/>
						<img src="${book.imageUrl}" />
					</s:link>
					<span>${book.discountPercentage} % off</span>
					</div>
				</c:forEach>
			
			
			
			</div>
			</div>
			
			<div style="clear:both;"></div>
			<div id="footer">
			<span>
			<s:link beanclass="ie.books.action.BookActionBean">Books</s:link>
			<s:link beanclass="ie.books.action.BookActionBean" event="bestSellers">Best Sellers</s:link>
			<s:link beanclass="ie.books.action.BookActionBean" event="promotions">Promotions</s:link>
				<c:choose>
					<c:when test="${actionBean.context.admin != null}">
						<s:link beanclass="ie.books.action.LogoutActionBean">Log Out</s:link>
					</c:when>
					<c:when test="${actionBean.context.customer != null}">
					<s:link beanclass="ie.books.action.ShoppingCartActionBean">Shopping Cart</s:link>
						<s:link beanclass="ie.books.action.LogoutActionBean">Log Out</s:link>
					</c:when>
					<c:otherwise>
						<s:link beanclass="ie.books.action.LoginActionBean">Log In</s:link>
						<s:link beanclass="ie.books.action.RegistrationActionBean">Sign Up</s:link>
					</c:otherwise>
				</c:choose>
			<s:link beanclass="ie.books.action.AdminActionBean">Admin</s:link>
			</span>
			</div>
	</body>
	</s:layout-definition>
</html>