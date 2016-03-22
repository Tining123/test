<%@ page import="com.Control.BarCtrl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>贴吧页面</title>
	<!-- 数据准备 -->
	<%
		String name =(String)request.getAttribute( "name");
		String page_num =(String)request.getAttribute( "page");
		BarCtrl barCtrl = new BarCtrl(name,page_num);
		String UserName = "";
		Cookie[] cook =request.getCookies();//用一个Cookie数组来接收
		if(cook != null){
			for(int j=0;j<cook.length;j++){	//通过循环来打印Cookie  
				if(cook[j].getName().equals("name"))	//取cookie的名 
					UserName = cook[j].getValue();	//取cookie的值  
			}
		}
	%>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script language="javascript">
	function login(){
		window.location.href="Login.jsp";
	}
	function Register(){
		window.location.href="Register.jsp";
	}
	</script>
	<script language="javascript">
	//////ajax
	//1.创建对象
    var oAjax = null;
    if(window.XMLHttpRequest){
        oAjax = new XMLHttpRequest();
    }else{
        oAjax = new ActiveXObject("Microsoft.XMLHTTP");
    }
    <%
     	out.print("url='chat?bar_id=" + barCtrl.getBarId() + "'");
    %>
     function getInfo(){
	    //2.连接服务器  
	    oAjax.open('GET', url, true);   //open(方法, url, 是否异步)
	      
	    //3.发送请求  
	    oAjax.send();
	    
	  //4.接收返回
	    oAjax.onreadystatechange = function(){  //OnReadyStateChange事件
	        if(oAjax.readyState == 4){  //4为完成
	            if(oAjax.status == 200){    //200为成功
	                document.getElementById('change').innerHTML = oAjax.responseText;
	            }else{
	                if(fnFaild){
	                    fnFaild();
	                }
	            }
	        }
	    };
     }
    
    setInterval("getInfo()", 500);  
    
	</script>
	
	<style type="text/css">
		body{
			padding-top: 50px;
		}
	</style>
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
									+"		<li><a href='user?user_id=" + barCtrl.getUserID1(UserName) + "'>用户中心</a></li>"
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
						out.print(barCtrl.getBarName() + "吧");
					%>
				</h2>
				<h4>
					<%
						out.print(barCtrl.getBarType());
					%>
				</h4>
				<% 
					if(!(UserName.equals("")||UserName.length() == 0)){
						//若没有关注贴吧，输出关注按钮
						if(!barCtrl.checkStarBar(barCtrl.getUserID(UserName))){
							out.print("<form role='star_bar' action = 'star_bar' method = 'get'>");
								out.print("<input type='text' name = 'bar_id' style='display:none' value ="+barCtrl.getBarId()+" >");
								out.print("<button class='btn btn-danger' type='submit'><span class='glyphicon glyphicon-plus'></span>关注</button>");
							out.print("</form>");
						}
						//如果关注了，输出取关按钮
						else{
							out.print("<form role='unstar_bar' action = 'unstar_bar' method = 'get'>");
							out.print("<input type='text' name = 'bar_id' style='display:none' value ="+barCtrl.getBarId()+" >");
							out.print("<button class='btn btn-danger' type='submit'><span class='glyphicon glyphicon-plus'></span>取消关注</button>");
						out.print("</form>");
						}
					}
				%>
				<%
					//若没登陆，不输出
					if(!(UserName.equals("")||UserName.length() == 0)){
						//若没有关注贴吧，不输出签到按钮
						if(barCtrl.checkStarBar(barCtrl.getUserID(UserName))){
							//若没签到，输出
							if(!barCtrl.checkSign(barCtrl.getUserID(UserName))){
								out.print("<form role='sign' action = 'sign' method = 'get'>");
									out.print("<input type='text' name = 'bar_id' style='display:none' value ="+barCtrl.getBarId()+" >");
									out.print("<button class='btn btn-info' type='submit'><span class='glyphicon glyphicon-pencil'></span>签到</button>");
								out.print("</form>");
							}
							else{
								out.print("<button class='btn btn-info' disabled = 'disabled' type='button'><span class='glyphicon glyphicon-pencil'></span>已签到</button>");					
							}
						}
					}
				%>
			</div>
		</div>

		<!--贴子主体部分-->
		<div class="container" style="padding:0">
			<div class="panel panel-default">
					<div class="panel-body">
						<%
							String TString = "";
							if(barCtrl.getTeacherNum()!=0){
								TString += "指导老师:";
							}
							for(int i = 0;i<barCtrl.getTeacherNum();i++){
								TString += ("<a href=user?user_id=" + barCtrl.getTeacherId(i) + ">");
								TString += (barCtrl.getTeacherName(i));
								TString += ("</a>&nbsp&nbsp");
							}
							out.print("<h5 class='col-md-8 col-sm-8 col-xs-8'>吧主:<a href=user?user_id=" + barCtrl.getBarOwnerId() + ">" + barCtrl.getBarOwnerName() + "</a>&nbsp&nbsp&nbsp" + TString + "</h5>");
							//如果没登陆就不输出
							if(!(UserName.equals("")||UserName.length() == 0)){
								//如果用户是老师，则输出，否则不,如果老师数量大于等于2，不输出
								if(barCtrl.checkTeacher(UserName) && barCtrl.getTeacherNum()<2){
									//如果用户已经是本吧老师，不输出
									if(!barCtrl.checkBarTeacher(barCtrl.getBarId(), barCtrl.getUserID1(UserName))){
										out.print("<form role='bar_techer' action = 'bar_techer' method = 'get'>");
											out.print("<input type='text' name = 'bar_id' style='display:none' value ="+barCtrl.getBarId()+" >");
											out.print("<input type='text' name = 'ask' style='display:none' value ="+barCtrl.getBarId()+" >");
											out.print("<div class='col-md-4 col-sm-4 col-xs-4'>");
												out.print("<button type='submit' class='btn btn-default'>申请老师</button>");
											out.print("</div>");
										out.print("</form'>");
									}
								}
							}
						%>
					</div>
			</div>
			
			<!-- 聊天版 -->
			<% 
				//如果没登陆就不输出
				if(!(UserName.equals("")||UserName.length() == 0)){
					out.print("<div id='change' style='margin: 10px;height: 150px;' class='pre-scrollable'><!--聊天内容框-->");
					out.print("</div>");
					out.print("<div style='margin: 10px;'>");
						out.print("<form role='chating' action = 'chating' method = 'get'>");
							out.print("<input type='text' name = 'bar_id' style='display:none' value ="+barCtrl.getBarId()+" >" );
							out.print("<input name='msg' type='text' class='form-control' placeholder='说点什么'>");							
							out.print("<button class='btn btn-info' type='submit' style='margin-top:5px;'>发送</button>");
							
						out.print("</form>");
					out.print("</div><!-- /input-group -->");
				}
			%>
			<%
			int postNum = barCtrl.getPostNum();
			String replyId = "";
			for(int i = 0; i < postNum ; i ++){
				//判断是否不存在回帖
				if(barCtrl.getLastId(i).equals("0")){
					replyId = barCtrl.getPosterId(i);
				}
				else replyId = barCtrl.getLastId(i);  
				out.print(
						"<div class='panel panel-default'>"
							+"<div class='panel-heading'>"
							+"<a href='post?post_id=" + barCtrl.getPostId(i) + "&page=1'><h3 class='panel-title'>" +barCtrl.getPostName(i) + "</h3></a>"		//输出帖子名
							+"</div>"
							+"<div class='panel-body'>"
							+	"<p>"
							+		barCtrl.getPostMsg(i)		//输出帖子内容
							+	"</p>"
							+"</div>"
							+"<div class='panel-footer container-fluid'>"
							+	"<div class='col-md-10 col-sm-10 col-xs-10' style='padding:0'>"
							+		"<a href='user?user_id=" + barCtrl.getPosterId(i) + "'><span class='glyphicon glyphicon-user'><span>" + barCtrl.getUserName((barCtrl.getPosterId(i))) + "</span></span></a>"		//输出楼主
							+		"<a href='user?user_id=" + barCtrl.getReplyer(replyId) + "'><span class='glyphicon glyphicon-user pull-right'><span style='color:gray'>" +  barCtrl.getUserName(barCtrl.getReplyer(replyId)) +  "</span></span></a>"				//输出最后回复人名
							+	"</div>"
							+	"<div class='col-md-2 col-sm-2 col-xs-2'>"
							+		"<span style='color:gray'>" + barCtrl.getLastDate(i) + "</span>"		//输出最后回复时间
							+	"</div>"
							+"</div>"
						+"</div>"
						);
			}
			%>
			</div>
	

			<div class="container well">
			<%
				if(UserName.equals("")||UserName.length() == 0){
					out.print("<div class='col-md-9 col-sm-9 col-xs-9'>");
					out.print("<label><span class='glyphicon glyphicon-pencil'></span>发帖请先登录</label>");
					out.print("</div>");
				}
				else{
					out.print("<form role='posting' action = 'posting' method = 'get'>");
					out.print("<div class='col-md-9 col-sm-9 col-xs-9'>");
					out.print("<input type='text' name = 'bar_id' style='display:none' value ="+barCtrl.getBarId()+" >" );
					out.print("<label><span class='glyphicon glyphicon-pencil'></span>发表新帖</label>");
					out.print("<div style='margin-top:10px'>");
					out.print("<input type='text' class='form-control' id='inputTitle' name = 'post_name' placeholder='填写标题'>");
					out.print("</div>");
					out.print("<div style='margin-top: 10px;'>");
					out.print("<textarea class='form-control' rows='3' name = 'post_msg'></textarea>");
					out.print("</div>");
					out.print("<button type='submit' class='btn btn-primary' style='margin-top: 10px'>发表</button>");
					out.print("</div>");
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