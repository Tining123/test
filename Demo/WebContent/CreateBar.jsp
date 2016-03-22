<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>创建贴吧</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		body{
			padding-top: 70px;
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
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container -->
	</nav><!--导航条结束-->




	<div class="container">
		
		<div class="page-header" style="margin-top:70px" >
			<label>创建贴吧</label>
		</div>

		<!--创建贴吧表单-->
		<form class="form-horizontal"  action = "create" method = "get">
			<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Name：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name" id="inputEmail3" placeholder="Name">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Type：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="type" id="inputPassword3" placeholder="Type">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Sign in</button>
				</div>
			</div>
		</form>

	</div>
	
	<!--这里的顺序不能打乱，不然下拉菜单不显示-->
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/npm.js" type="text/javascript"></script>
</body>
</html>