<%@ page import="com.Control.SearchCtrl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script language="javascript">
	function login(){
		window.location.href="Login.jsp";
	}
	function Register(){
		window.location.href="Register.jsp";
	}
	</script>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>搜索</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		body{
			padding-top: 50px;
		}
	</style>
	<!-- 数据准备 -->
	<%
		SearchCtrl searchCtrl = new SearchCtrl();	//实例化控制器
		String UserName = "";
		Cookie[] cook =request.getCookies();//用一个Cookie数组来接收
		if(cook != null){
			for(int j=0;j<cook.length;j++){	//通过循环来打印Cookie  
				if(cook[j].getName().equals("name"))	//取cookie的名 
					UserName = cook[j].getValue();	//取cookie的值  
			}
		}
	%>
</head>
<body>
	
	<!--导航条-->
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand">一纸贴吧系统</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<%
						if(UserName.equals("")||UserName.length() == 0)
							out.print("<li>"
							+"	<form action = 'login' class='navbar-form'>"
							+"		<button onClick='login()' href='Login.jsp' type='button' class='btn ' data-toggle='modal' data-target='#myModal'>登录</button>"
							+"	</form>"
							+"</li>"
							+"<li><a href='Register.jsp' onClick='Register()'>注册</a></li>");
						else{
							out.print("<li class='dropdown'>"
									+"	<a href='#' class='dropdown-toggle' data-toggle='dropdown'>" + UserName + "<span class='caret'></span></a>"
									+"	<ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1'>"
									+"		<li><a href='user?user_id=" + searchCtrl.getUserID(UserName) + "'>用户中心</a></li>"
									+"		<li><a href='logout'>注销</a></li>"
									+"		<li role='separator' class='divider'></li>"
									+"	</ul>"
									+"</li>");
						}
					%>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container -->
	</nav><!--导航条结束-->




	<div class="container">
		<div class="page-header">
			<h1>搜索</h1>
		</div>

		<!--表单和按钮-->
		<form role="search" action = "search" method = "get">
			<div class="form-group col-md-6">
				<input type="text" name = "name" class="form-control" placeholder="Search"></input>
			</div>
			<button type="submit" class="btn btn-primary">进入贴吧</button>
		</form><!--表单结束-->

	<!--这里的顺序不能打乱，不然下拉菜单不显示-->
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/npm.js" type="text/javascript"></script>
</body>
</html>