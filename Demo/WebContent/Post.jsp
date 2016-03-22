<%@page import="com.Control.BarCtrl"%>
<%@ page import="com.Control.PostCtrl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//CN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>贴子内容</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script language="javascript">
	function login(){
		window.location.href="Login.jsp";
	}
	function Register(){
		window.location.href="Register.jsp";
	}
	</script>
	<style type="text/css">
		body{
			padding-top: 50px;
		}
	</style>
	<!-- 数据准备 -->
	<%
		String post_id =(String)request.getAttribute( "post_id");
		String page_num =(String)request.getAttribute( "page");
		String poster = (String)request.getAttribute( "poster");
		String teacher = (String)request.getAttribute( "teacher");
		PostCtrl postCtrl = new PostCtrl(post_id,page_num,poster,teacher);	//实例化控制器
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
				<a class="navbar-brand" href="Search.jsp">一纸贴吧系统</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

				<!--表单和按钮-->
				<form class="navbar-form navbar-left" role="search" role='search' action = 'search'>
					<div class="form-group">
						<input type="text" name = 'name'; class="form-control" placeholder="Search"></input>
					</div>
					<button type="submit" class="btn btn-primary">进入贴吧</button>
				</form>

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
									+"		<li><a href='user?user_id=" + postCtrl.getUserID1(UserName) + "'>用户中心</a></li>"
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

	

	<!--贴吧主体-->
	<div class="container">
		<!--贴吧头-->	
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-md-1 col-sm-2 col-xs-3">
				<a href="#" class="thumbnail">
					<img src="images/006.jpg" alt="thumbnail">
				</a>
				</div>
				<p>
					<!-- 获取贴吧名字 -->
					<%
						out.print(postCtrl.getBarname());
					%>
				</p>
			</div>
		</div>

		<div class="container col-md-9 col-sm-9 col-xs-9" style="float:left;padding: 0">
			<!--帖子标题-->
			<div class="panel panel-default">
				<div class="panel-body" style="color:red;">
					<h5 class="col-md-8 col-sm-8 col-xs-8">
						<!-- 获取帖子名字   -->
						<%
							out.print(postCtrl.getFirstName());
						%>
					</h5>
					<div class="col-md-4 col-sm-4 col-xs-4">
						<%
							if(poster == null)
								out.print("<a type='submit' class='btn btn-default' href=post?post_id=" + post_id + "&page=1&poster=1>只看楼主</a>");
							else
								out.print("<a type='submit' class='btn btn-default' href=post?post_id=" + post_id + "&page=1>取消只看楼主</a>");
							if(teacher == null)
								out.print("<a type='submit' class='btn btn-default' href=post?post_id=" + post_id + "&page=1&teacher=1>只看老师</a>");
							else
								out.print("<a type='submit' class='btn btn-default' href=post?post_id=" + post_id + "&page=1>取消只看老师</a>");
						%>
					</div>
				</div>
			</div>

			<!--帖子主体-->
			<% 
				out.print("<div class='panel panel-default'>");
					out.print("<div class='panel-body'>");
						out.print("<div class='col-md-2 col-xs-2 col-sm-2'><!--楼主头像-->");
							out.print("<p><strong>楼主</strong></p>");
							out.print("<a href=user?user_id=" + postCtrl.getFirstUserId() + " class='thumbnail'>");
								out.print("<img src='images/006.jpg' alt='头像'>");
							out.print("</a>");
							out.print("<a href=user?user_id=" + postCtrl.getFirstUserId() + "><p><!-- 楼主名 -->"+postCtrl.getFirstUserName()+"</p></a>");
						out.print("</div>");
						out.print("<div class='col-md-10 col-sm-10 col-xs-10'>");
							out.print("<p>"+postCtrl.getFirstFloorMsg()+"</p>");
						out.print("</div>");
					out.print("</div>");
					out.print("<div class='panel-footer'>");
						out.print("<p class='text-right'>");
							out.print("<span>1楼</span>&nbsp;&nbsp;");
							out.print("<span><!-- 发帖时间  -->"+postCtrl.getFirstDate()+"</span>&nbsp;&nbsp;");
						out.print("</p>");
					out.print("</div>");
				out.print("</div>");
			%>
			<%
				for(int i = 0;i<postCtrl.getFloorNum();i++){
					out.print("<div class='panel panel-default'>");
						out.print("<div class='panel-body'>");
							out.print("<div class='col-md-2 col-xs-2 col-sm-2'>");
								//如果是楼主，输出楼主
								if(postCtrl.getFirstUserName().equals(postCtrl.getFloorUserName(i))){
									out.print("<p><strong>楼主</strong></p>");
								}
								//如果是老师，输出老师
								else{
									if(postCtrl.checkTeacher(postCtrl.getUserID1(postCtrl.getFloorUserName(i))))
										out.print("<p><strong>老师</strong></p>");
								}
								out.print("<a href=user?user_id=" + postCtrl.getFloorUserId(i) + " class='thumbnail'><img src='images/006.jpg' alt='头像'></a>");
								out.print("<a href=user?user_id=" + postCtrl.getFloorUserId(i) + "><p>"+postCtrl.getFloorUserName(i)+"</p></a>");
							out.print("</div>");
							out.print("<div class='col-md-10 col-sm-10 col-xs-10'>");
								out.print("<p>"+postCtrl.getFloorMsg(i)+"</p>");
							out.print("</div>");
						out.print("</div>");
						out.print("<div class='panel-footer'>");
							out.print("<p class='text-right'>");
								out.print("<span>" + (i+2) + "楼</span>&nbsp;&nbsp;");
								out.print("<span>"+postCtrl.getFloorDate(i)+"</span>&nbsp;&nbsp;");
							out.print("</p>");
						out.print("</div>");
					out.print("</div>");
				}
			%>

			<div class="container well">
				<%
					if(UserName.equals("")||UserName.length() == 0){
						out.print("<div class='col-md-9'>");
						out.print("<label><span class='glyphicon glyphicon-pencil'></span>回复请先登陆</label>");
						out.print("</div>");
					}
					else{
						out.print("<form role='reply' action = 'reply' method = 'get'>");
						out.print("<input type='text' name = 'post_id' style='display:none' value ="+postCtrl.getPostId()+" >" );
						out.print("<input type='text' name = 'bar_id' style='display:none' value ="+postCtrl.getBarId()+" >" );
						out.print("<div class='col-md-9'>");
						out.print("<label><span class='glyphicon glyphicon-pencil'></span>发表回复</label>");
						out.print("<div style='margin-top: 10px;'>");
						out.print("<textarea class='form-control' name = 'reply_msg' rows='3'></textarea>");
						out.print("</div>");
						out.print("<button type='submit' class='btn btn-primary' style='margin-top: 10px'>发表</button>");
						out.print("</form>");
					}
				%>
			</div>
		</div>
	</div>


	<!--这里的顺序不能打乱，不然下拉菜单不显示-->
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/npm.js" type="text/javascript"></script>
</body>
</html>