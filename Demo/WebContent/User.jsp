<%@ page import="com.Control.UserCtrl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN"> 
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>个人资料</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		body{
			padding-top: 50px;
		}
	</style>
	<script language="javascript">
		function login(){
			window.location.href="Login.jsp";
		}
		function Register(){
			window.location.href="Register.jsp";
		}
	</script>
	<!-- 数据准备 -->
	<%
		String user_id =(String)request.getAttribute( "user_id");
	
		String UserName = "";
		Cookie[] cook =request.getCookies();//用一个Cookie数组来接收
		if(cook != null){
			for(int j=0;j<cook.length;j++){	//通过循环来打印Cookie  
				if(cook[j].getName().equals("name"))	//取cookie的名 
					UserName = cook[j].getValue();	//取cookie的值  
			}
		}
		UserCtrl userCtrl = new UserCtrl(UserName,user_id);
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
				<<a class="navbar-brand" href="Search.jsp">一纸贴吧系统</a>
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
									+"		<li><a href='user?user_id=" + userCtrl.getUserId(UserName) + "'>用户中心</a></li>"
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
		<div class="jumbotron" style="height: 250px">
			<div class="col-md-2 col-sm-4 col-xs-4">
				<a href="#" class="thumbnail">
					<img src="images/006.jpg" alt="thumbnail">
				</a>
			</div>
			<div class="col-md-10 col-sm-8 col-xs-8">
				<h2>
					<%
						out.print(userCtrl.getUserName());				
					%>
				</h2>
					<%
						//如果登陆了才考虑输出
						if(!(UserName.equals("")||UserName.length() == 0)){
							//如果不是本人输出 
							if(!user_id.equals(userCtrl.getUserId(UserName))){
								//如果还没有关注他，就输出关注
								if(!userCtrl.checkStarUser(userCtrl.getUserId(UserName))){
									out.print("<form role='star_user' action = 'star_user' method = 'get'>");
										out.print("<input type='text' name = 'user_id' style='display:none' value ="+user_id+" >");
										out.print("<button class='btn btn-danger' type='submit'><span class='glyphicon glyphicon-plus'></span>关注</button>");
									out.print("</from>");
								}
								//否则输出取消关注
								else{
									out.print("<form role='unstar_user' action = 'unstar_user' method = 'get'>");
										out.print("<input type='text' name = 'user_id' style='display:none' value ="+user_id+" >");
										out.print("<button class='btn btn-danger' type='submit'><span class='glyphicon glyphicon-plus'></span>取消关注</button>");
									out.print("</from>");
								}
								out.print("<a href='message?user_id=" + user_id + "' class='btn btn-info' type='button'><span class='glyphicon glyphicon-pencil'></span>私信</a>");
							}
						}
					%>
			</div>
		</div>

		<!--吧内导航-->
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="#tab1"  data-toggle="tab">我的关注</a></li>
			<li role="presentation"><a href="#tab2"  data-toggle="tab">我的帖子</a></li>
			<li role="presentation"><a href="#tab3"  data-toggle="tab">我的回复</a></li>
			<%
				if(UserName!=null)
					if(UserName.length() != 0)
						if(userCtrl.getUserId(UserName).equals(user_id)){
							out.print("<li role='presentation'><a href='#tab4'  data-toggle='tab'>我的私信</a></li>");
						}
			%>
		</ul>
		<div class="tab-content">
			<div id="tab1" class="tab-pane fade in active">
				<div class="panel panel-default">
					<div class="panel-body">
						<p><strong>关注的吧</strong></p>
						<table class="table">
							<%
								for(int i = 0; i < userCtrl.getBarNum();i++){
									out.print("<tr>");
									for(int j = 0; j<4 ;j++,i++){
										if(i >= userCtrl.getBarNum())
											break;
										out.print("<td>");
										out.print("<a type='button' class='btn btn-info' href = bar?name=" + userCtrl.getBarName(i) + "&page=1>"+ userCtrl.getBarName(i) + "(" + userCtrl.getSignNum(userCtrl.getBarId(i)) + ")" + "</a>");
										out.print("</td>");
									}
									out.print("<tr>");
								}
							%>
						</table>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-body">
						<p><strong>我关注的人</strong></p>
						<%
							for(int i = 0;i<userCtrl.getStarNum();i++){
								out.print("<div class='row'>");
								for(int j=0;j<12;j++,i++){
									if(i>=userCtrl.getStarNum())
											break;
									out.print("<div class='col-md-1 col-sm-2 col-xs-2'>");
									out.print("<a href='user?user_id=" + userCtrl.getStarId(i) + "' class='thumbnail'>");
									out.print("<img src='images/006.jpg' alt=''...''>");
									out.print("<p>" + userCtrl.getStarName(i) + "</p>");
									out.print("</a>");
									out.print("</div>");
								}
								out.print("</div>");
							}
						%>
						
						<p><strong>关注我的人</strong></p>
												<%
							for(int i = 0;i<userCtrl.getFansNum();i++){
								out.print("<div class='row'>");
								for(int j=0;j<12;j++,i++){
									if(i>=userCtrl.getFansNum())
										break;
									out.print("<div class='col-md-1 col-sm-2 col-xs-2'>");
									out.print("<a href='user?user_id=" + userCtrl.getFansId(i) + "' class='thumbnail'>");
									out.print("<img src='images/006.jpg' alt=''...''>");
									out.print("<p>" + userCtrl.getFansName(i) + "</p>");
									out.print("</a>");
									out.print("</div>");
								}
								out.print("</div>");
							}
						%>
					</div>
				</div>

			</div>
			<div id="tab2" class="tab-pane fade">
				<div class="pane pane-default">
					<div class="pane-body">
						<table class="table">
							<%
								for(int i = 0;i<userCtrl.getPostNum();i++){
									out.print("<tr>");
										out.print("<td>");
											out.print("<p>在&nbsp;&nbsp;<a href='bar?bar_id=" + userCtrl.getBarId(i) + "'>" 
												+ userCtrl.getMyBarName(i) + "吧" + "</a>&nbsp;&nbsp;发布帖子&nbsp;&nbsp;<a href='user?user_id=" + userCtrl.getPostId(i) + "'>" + userCtrl.getPostName(i) 
												+ "</a>&nbsp;&nbsp;回复（<span>" + userCtrl.getReplyNum(userCtrl.getPostId(i)) +  "</span>）</p>");
										out.print("</td>");
										out.print("<td>");
											out.print("<span>time " + userCtrl.getPostDate(i) + "</span>");
										out.print("</td>");
									out.print("</tr>");
								}
								
							%>
						</table>
					</div>
				</div>
			</div>
			<div id="tab3" class="tab-pane fade">
				<div class="pane pane-default">
					<div class="pane-body">
						<table class="table">
							<%
								for(int i = 0;i<userCtrl.getReplyNum();i++){
									out.print("<tr>");
										out.print("<td>");
										out.print("<p>在&nbsp;&nbsp;<a href='bar?bar_id=" + userCtrl.getReplyBarId(i) + "'>" 
												+ userCtrl.getReplyBarName(i) + "吧" + "</a>&nbsp;&nbsp;发布帖子&nbsp;&nbsp;<a href='user?user_id=" + userCtrl.getReplyId(i) + "'>" + userCtrl.getReplyMsg(i) 
												+ "</a>&nbsp;&nbsp;回复（<span>" + userCtrl.getReplyReplyNum(i) +  "</span>）</p>");
										out.print("</td>");
										out.print("<td>");
										out.print("<span>time " + userCtrl.getReplyDate(i) + "</span>");
										out.print("</td>");
									out.print("</tr>");
								}
							%>
						</table>
					</div>
				</div>
			</div>
			<!-- 我的私信 -->
			<div id="tab4" class="tab-pane fade">
				<div class="pane pane-default">
					<div class="pane-body">
						<table class="table">
							<%
								for(int i = 0;i<userCtrl.getMsgNum();i++){
									out.print("<tr>");
										out.print("<td>");
										if(userCtrl.getMsgType(i).equals("1")){
											out.print("<p>&nbsp;&nbsp;<a href='user?user_id=" + userCtrl.getMsgSenderId(i) + "'>" 
													+ userCtrl.getUserName1(userCtrl.getMsgSenderId(i)) + "</a>&nbsp;&nbsp;对你说&nbsp;&nbsp;<a href='message?msg_id=" + userCtrl.getMsgId(i) + "&user_id=" + userCtrl.getMsgSenderId(i) + "'>" + userCtrl.getMsgMsg(i) 
													+ "</p>");
										}else if(userCtrl.getMsgType(i).equals("2")){
											out.print("<p><a href=user?user_id=" + userCtrl.getMsgSenderId(i) + ">" 
												+ userCtrl.getUserName1(userCtrl.getMsgSenderId(i)) + "</a>申请成为<a href=bar?page=1&name=" 
													+ userCtrl.getBarName1(userCtrl.getMsgMsg(i)) + ">" + userCtrl.getBarName1(userCtrl.getMsgMsg(i)) 
															+ "</a>吧的指导老师&nbsp;&nbsp;&nbsp;<a href=bar_techer?yes=1&msg_id=" + userCtrl.getMsgId(i) + "&bar_id=" + userCtrl.getMsgMsg(i) + "&user_id="+userCtrl.getMsgSenderId(i)+">同意</a>&nbsp;&nbsp;<a href=bar_techer?msg_id=" + userCtrl.getMsgId(i) + ">拒绝</a></p>");
										}
										out.print("</td>");
										out.print("<td>");
										out.print("<span>time " + userCtrl.getMsgDate(i) + "</span>");
										out.print("</td>");
									out.print("</tr>");
								}
							%>
						</table>
					</div>
				</div>
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