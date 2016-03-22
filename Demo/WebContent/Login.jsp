<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN"> 
<head>
	<script language="javascript">
		function register(){
			window.location.href="Register.jsp";
		}
	</script>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>登录</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		body{
			padding-top: 50px;
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
					<a class="navbar-brand" href="#">一纸贴吧系统</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

					<!--表单和按钮-->
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search"></input>
						</div>
						<button type="submit" class="btn">搜索贴吧</button>
						<button type="submit" class="btn btn-primary">进入贴吧</button>
					</form>
				</div><!-- /.navbar-collapse -->
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
								<label for="inputEmail1" class="col-sm-2 col-md-2 col-xs-2 control-label">用户名</label>
								<div class="col-sm-8 col-md-8 col-xs-8">
									<input type="email" class="form-control" id="inputEmail1" placeholder="Email">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 col-md-2 col-xs-2 control-label">密码</label>
								<div class="col-sm-8 col-md-8 col-xs-8">
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


		<div>
			
			<form class="form-horizontal" style="margin:70px auto" action = "login" method = "get">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 col-md-2 col-xs-2 control-label">用户名</label>
					<div class="col-sm-8 col-md-6 col-xs-8">
						<input type="text" name = "name" class="form-control" id="inputEmail" placeholder="Name">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 col-md-2 col-xs-2 control-label">密码</label>
					<div class="col-sm-8 col-md-6 col-xs-8">
						<input type="password" name = "pass" class="form-control" id="inputPassword" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7 col-xs-offset-2 col-xs-7">
						<button type="submit" class="btn btn-info">登录</button>
						<button onClick="register()" type="button" class="btn btn-default">注册</button>
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

