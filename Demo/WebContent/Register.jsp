<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>注册</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		body{
			padding-top: 70px;
		}
	</style>

</head>

<body>
	<div class="container">
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
			</div>
			</div><!-- /.container -->
		</nav><!--导航条结束-->

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">登录账号</h4>
					</div>
					<div class="modal-body">
						<!-- 模态框中的主体内容 -->
						<form class="form-horizontal">
							<div class="form-group">
								<label for="inputEmail1" class="col-sm-2 control-label">账号</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="inputEmail1" placeholder="Email">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">密码</label>
								<div class="col-sm-8">
									<input type="password" class="form-control" id="inputPassword1" placeholder="Password">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">登录</button>
					</div>
				</div>
			</div>
		</div>    


		<div class="jumbotron">
			
			<form class="form-horizontal" style="margin:70px auto" action="register" method="Get">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">昵称</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name = "name" id="inputEmail" placeholder="Name">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" name = "pass" id="inputPassword" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-4">
						<input type="email" class="form-control" name = "mail" id="confirmPassword" placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-7">
						<button type="submit" class="btn btn-default">注册</button>
					</div>
				</div>
			</form>
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
