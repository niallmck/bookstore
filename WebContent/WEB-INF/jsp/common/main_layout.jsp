<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-definition>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="/Books/css/style.css">
		<title>Welcome to Books.ie</title>
	</head>
	<body>
		<div id="header">
			<div id="headerContent">
			<img src="/Books/css/img/logo.png" alt="books.ie"/>
	
			<div id="searchBar">
				<form action="" method="post">
					<input type="text" name="searchTerm" /><input type="submit" name="submit" value="Search"/>
					<br>
				</form>
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
					<li><a href="">Top Sellers</a></li>
					<li><a href="">Featured</a></li>
					<li><a href="">Promotions</a></li>
				</ul>
				<ul>
					<li><a href="">Academic</a></li>
					<li><a href="">Art &amp; Photography</a></li>
					<li><a href="">Biography</a></li>
					<li><a href="">Business &amp; Law</a></li>
					<li><a href="">Coming Soon</a></li>
					<li><a href="">Educational</a></li>
					<li><a href="">Entertainment</a></li>
				</ul>
				</s:layout-component>
			</div><div id="content">
				<s:layout-component name="content">
				</s:layout-component>
			</div><div id="promoSidebar">
			<div style="clear:both;"></div>
			</div>
		</div>
	</body>
	</s:layout-definition>
</html>