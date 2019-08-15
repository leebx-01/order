<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <TITLE>粤嵌西安论坛--登录</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<Link rel="stylesheet" type="text/css" href="style/style.css"/>
<script language="javascript">
function check() {
 if(document.loginForm.uName.value==""){
    alert("用户名不能为空");
    return false;
 }
 if(document.loginForm.uPass.value==""){
    alert("密码不能为空");
    return false;
 }
}
function show(){
		var d=new Date();
		document.getElementById("date").innerHTML=
		d.getYear()+"年&nbsp;&nbsp;"+""+
		d.getMonth()+1+"月"+
		d.getDate()+"日&nbsp;&nbsp;"+
		d.getHours()+":"+
		d.getMinutes()+":"+
		d.getSeconds();
		setTimeout("show()",1000);
	}
</script>
</HEAD>

<BODY onload="show()">
	<DIV>
		<IMG src="image/logo.png" style="width:200px;height:50px">
		<div style="text-align:right" id="date">
			
		</div>
	</DIV>
	<c:if test="${name==null }">
		<!--      用户信息、登录、注册        -->
		<DIV class="h">
			您尚未 <a href="login.jsp">登录</a> &nbsp;| &nbsp; <A href="reg.jsp">注册</A>
			|
		</DIV>
	</c:if>
	<c:if test="${name!=null }">
		<!--      用户信息、登录、注册        -->
		<DIV class="h">欢迎&nbsp;${name}&nbsp;来到此论坛
		
		</DIV>

	</c:if>


<BR/>
<!--      导航        -->
<DIV>
	&gt;&gt;<B><a href="index.jsp">论坛首页</a></B>
</DIV>
<!--      用户登录表单        -->
<DIV class="t" style="MARGIN-TOP: 15px" align="center">
	<FORM name="loginForm" onSubmit="return check()" action="MemberServlet?flag=login" method="post">
		<br/>用户名 &nbsp;<INPUT class="input" tabIndex="1"  type="text"l      maxLength="20" size="35" name="uName">
		<p/>密　码 &nbsp;<INPUT class="input" tabIndex="2"  type="password"  maxLength="20" size="40" name="uPass">
		<p/><INPUT class="btn"  tabIndex="6"  type="submit" value="登 录">
	</FORM>
</DIV>
<!--      声明        -->
<BR/>
<CENTER class="gray">版权所有 2005-2011　西安粤嵌科技有限公司</CENTER>
</BODY>
</HTML>
