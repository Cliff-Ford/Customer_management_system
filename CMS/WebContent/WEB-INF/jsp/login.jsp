<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>登录</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
	
</head>
<body>
	
	<div class="container">
		<div class="row up_box">
	  		<div class="logo_box">
	  			<img src="${pageContext.request.contextPath }/img/mi-logo.png">
	  		</div>
	  		<div class="up_right_box">
	  			<p class="title_1">小米商城</p>
	  			<p class="title_2">让每个人都享受生活的乐趣</p>
	  		</div>	  		
	  	</div>	  	
	</div>
	<div class="down_box">
		<img class="match_parent_width" src="${pageContext.request.contextPath }/img/login_bgp.jpg" />
		<div class="log">
			<div class="my_row">
				<span class="log_span1 orange">账号登录</span><span class="log_span2">扫码登录</span>
			</div>
			<div class="my_row">
				<form action="${pageContext.request.contextPath }/login" role="form" onsubmit="return check_login()" method="post">
					<div class="form-group">
						<input class="form-control" placeholder="账号" type="text" name="user_code"/>
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="密码" type="password" name="user_password"/>
					</div>
					<input type="submit" class="my_btn" value="登录"/>
				</form>
			</div>
			<div class="my_row">
				<span class="orange pointer">手机短信登录/注册</span>
				<span class="sign_or_forget pointer">
					<a href="sign_before_login.html">立即注册</a> |
					<a>忘记密码?</a>
				</span>
				
			</div>
			<div class="my_row other_login">
				<img src="${pageContext.request.contextPath }/img/other_login.png" />
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function check_login(){
			let user_code = $("input[name='user_code']").val();
			let user_password = $("input[name='user_password']").val();
			if(user_code == '' || user_password == ''){
				alert("账号或密码不能为空！");
				return false;
			}
			return true;
		}
	</script>
		
</body>
</html>


