<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<h1 class="navbar-brand"><a  href="index.jsp">Yummy</a></h1>
				</div>
				<!--navbar-header（菜单）-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="index.jsp" class="active">BY</a></li>
		
						<c:forEach items="${typelist }" var="t1">
							<li class="dropdown">	<!-- 一级菜单 -->
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">${t1.typename }<b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-4">	<!-- 二级菜单 -->
								<c:forEach items="${t1.childTypes }" var="t2">
									<div class="row">
									<!-- 加入超链接 -->
									<a href="productsController?typeid=${t2.typeid }">
										<div class="col-sm-3">
											<h4>${t2.typename }</h4>
										</div>	
									</a>																	
									</div>
								</c:forEach>
								</ul>
							</li>
							
						</c:forEach>								
					</ul> 
					<!--/.navbar-collapse-->
				</div>
				<!--//navbar-header-->
			</nav>
			<!-- 搜索框 -->
			<div class="header-info">
				<div class="header-right search-box">
					<a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>				
					<div class="search">
						<form action="productsController" class="navbar-form">
							<input type="text" class="form-control" name="cakename" value="${cakename }"/>
							<button type="submit" class="btn btn-default" aria-label="Left Align">
								Search
							</button>
						</form>
					</div>	
				</div>
				<!-- 登录注册 -->
				<div class="header-right login">
					<a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
					<div id="loginBox">      
					<c:if test="${empty name}">          
						<form id="loginForm" action="loginController" method="post">
							<fieldset id="body">
								<fieldset>
									<label for="email">Email Address</label>
									<input type="text" name="email" id="email">
								</fieldset>
								<fieldset>
									<label for="password">Password</label>
									<input type="password" name="password" id="password">
								</fieldset>
								<input type="submit" id="login" value="Sign in">
								<label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
							</fieldset>
							<p>New User ? <a class="sign" href="account.jsp">Sign Up</a> <span><a href="#">Forgot your password?</a></span></p>
						</form>
					</c:if>
						<form id="loginForm" >
						<c:if test="${not empty name }">
							你好，${name }
						</c:if>	
						</form>
					</div>
						
				</div>
			</div>
		
				<!-- 购物车 -->
				<div class="header-right cart">
					<a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
					<div class="cart-box">
						<h4><a href="checkout.jsp">
							<span> 查看购物车 </span>
						</a></h4>
						<p><a href="javascript:;" class="simpleCart_empty">Empty cart</a></p>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>