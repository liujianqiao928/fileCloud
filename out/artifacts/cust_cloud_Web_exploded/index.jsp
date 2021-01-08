<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CUST云盘-登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eminent Login Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- font files -->
<!--<link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>-->
<!--<link href='//fonts.googleapis.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>-->
<!-- /font files -->
<!-- css files -->
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
	<script type="text/javascript" src="/js/jquery-1.4.4.min.js"></script>
<!-- /css files -->
</head>

<body>

<script type="text/javascript">
	var sysMsg = "${msg}"
	if(sysMsg != "")
		alert(sysMsg);
</script>
<h1>CUST</h1>
<div class="form-w3ls">
    <ul class="tab-group cl-effect-4">
        <li class="tab active"><a href="#signin-agile">登录</a></li>
		<li class="tab"><a href="#signup-agile">注册</a></li>        
    </ul>
    <div class="tab-content">
        <div id="signin-agile">   
			<form action="login.do" method="post">
				<p class="header">用户名</p>
				<input type="text" name="usercode" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
				<p class="header">密码</p>
				<input type="password" name="password" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
				<span class="header">验证码</span>  <img type="image" src="auth/authCode.do" id="codeImage" name="codeImage" style="cursor:pointer;"/>
				<input type="text" id="authCode" name="authCode">


				<input class="register" type="submit" id="submitBtn" name="submitBtn" value="登录" onclick="submitForm()"/>
			</form>
		</div>
		<script type="text/javascript">
            function submitForm() {
                var inputCode=$("#authCode").attr("value");
                var list={"inputCode":inputCode};
                $.ajax({
                    //请求方式
                    type : "POST",
                    //请求的媒体类型
                    contentType: "application/x-www-form-urlencoded",
                    //请求地址
                    url : "auth/checkCode.do",
                    //数据，json字符串
                    data :list,
                    dataType:"json",
                    //请求成功
                    success : function(result) {
                        alert(result);
                        if(result=="1"){
                            alert("验证通过");
                        }else{
                            alert("验证失败，重新刷新验证码");
                            flushAuthCode();
                        }
                    },
                    //请求失败，包含具体的错误信息
                    error : function(e){
                        alert("验证成功 点击确定登录主页面");
                    }
                });
            }
            function flushAuthCode() {
                //重新刷新验证码
                $("#codeImage").attr("src","auth/authCod.doe?abc="+Math.random());
            }

		</script>
		<div id="signup-agile">   
			<form action="/register.do" method="post">
				
				<p class="header">用户名(登录名)</p>
				<input id="usercode" type="text" name="usercode"  value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
				
				<p class="header">邮箱</p>
				<input id="email" type="text" name="email" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" >
				
				<p class="header">密码</p>
				<input id="password" type="password" name="password"  value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
				<p class="header">是否激活</p>
				 <input id="state" type="checkbox" name="state" value="1" class="input-check" @click="checkValue">				
				<input type="submit" class="register" value="注册" />
			</form>
		</div> 
    </div>
</div> 
<p class="copyright"></p>
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
<script type="text/javascript">
</script>


</body>
</html>