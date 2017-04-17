<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="UTF-8">
	<title>Werun俱乐部人员管理系统</title>
	<link rel="stylesheet" href="./resources/css/font-awesome-4.1.0/css/font-awesome.min.css">
	<link rel='stylesheet' href='./resources/css/jquery-ui.css'>
	<link rel='stylesheet prefetch' href='./resources/css/bootstrap.min.css'>
	<link rel="stylesheet" href="./resources/css/style.css" media="screen" type="text/css" />
	<link rel="stylesheet" href="./resources/css/login.css" media="screen" type="text/css" />
	<script src="./resources/js/modernizr.js"></script>
	<script src="./resources/js/login.js"></script>
	<script src="./resources/js/jquery-1.7.1.min.js"></script>
	<script src="./resources/js/jquery-md5.js"></script>
</head>

	<body class="login-page">
		
		<div id="login-title">
			<span> Template · 登录 </span>
		</div>
	
		<div class="login-form">
		
			<div class="login-content">
				
				<form method="post" action="login.do" id="form_login">

					<div class="form-group">

						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-user"></i>
							</div>

							<input type="text" class="form-control" name="username" id="username" placeholder="Username" autocomplete="off" />
						</div>

					</div>

					<div class="form-group">

						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-key"></i>
							</div>

							<input type="password" class="form-control" name="password" id="password" placeholder="Password" autocomplete="off" />
						</div>

					</div>

					<div class="form-group">
						<button onclick="loginFormSubmit()" class="btn btn-primary btn-block btn-login">
							<i class="fa fa-sign-in"></i>
							Login In
						</button>
						<button onclick="loginFormSubmit()" class="btn btn-primary btn-block btn-login">
							<i class="fa fa-sign-in"></i>
							Register
						</button>
					</div>
			
				</form>
				<c:if test="${result != null}">
					<div class="form-login-error">
						<h3>登录失败</h3>
						<p>失败原因：${result.message}</p>
					</div>
				</c:if>
			</div>

		</div>
		
		<div id="copyright">
			<span> Copyright 2006-2016,WerunClub Powered by Du </span>
		</div>

	</body>

</html>