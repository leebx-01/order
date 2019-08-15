<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<TITLE>粤嵌西安论坛--发布帖子</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript">
	function check() {
		if (document.postForm.title.value == "") {
			alert("标题不能为空");
			return false;
		}
		if (document.postForm.content.value == "") {
			alert("内容不能为空");
			return false;
		}
		if (document.postForm.content.value.length > 1000) {
			alert("长度不能大于1000");
			return false;
		}
	}
	function show() {
		var d = new Date();
		document.getElementById("date").innerHTML = d.getYear()
				+ "年&nbsp;&nbsp;" + "" + d.getMonth() + 1 + "月" + d.getDate()
				+ "日&nbsp;&nbsp;" + d.getHours() + ":" + d.getMinutes() + ":"
				+ d.getSeconds();
		setTimeout("show()", 1000);
	}
</script>
</HEAD>

<BODY onload="show()">
	<DIV>
		<IMG src="image/logo.png" style="width:200px;height:50px">
		<div style="text-align:right" id="date"></div>
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
		<DIV class="h">欢迎&nbsp;${name}&nbsp;来到此论坛</DIV>

	</c:if>


	<!--      主体        -->
	<DIV>
		<BR />
		<!--      导航        -->
		<DIV>
			&gt;&gt;<B><a href="index.jsp">论坛首页</a> </B>&gt;&gt; <B><a
				href="list.jsp?boardId=${boardId }&boardName=${boardName}">${boardName }</a> </B>
		</DIV>
		<BR />
		<DIV>
			<FORM name="postForm" onsubmit="return check()"
				action="PublishServlet?boardId=${boardId }&boardName=${boardName}&memberId=${memberId}" method="POST">
				<INPUT type="hidden" name="boardId" value="4" /> <INPUT
					type="hidden" name="topicId" value="" />
				<DIV class="t">
					<TABLE cellSpacing="0" cellPadding="0" align="center">
						<TR>
							<TD class="h" colSpan="3"><B>发表帖子</B></TD>
						</TR>

						<TR class="tr3">
							<TH width="20%"><B>标题</B></TH>
							<TH><INPUT class="input"
								style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1"
								size="60" name="title"></TH>
						</TR>

						<TR class="tr3">
							<TH vAlign=top>
								<DIV>
									<B>内容</B>
								</DIV>
							</TH>
							<TH colSpan=2>
								<DIV>
									<span><textarea style="WIDTH: 500px;" name="content"
											rows="20" cols="90" tabIndex="2"></textarea> </span>
								</DIV> (不能大于:<FONT color="blue">1000</FONT>字)</TH>
						</TR>
					</TABLE>
				</DIV>

				<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
					<INPUT class="btn" tabIndex="3" type="submit" value="提 交">
					<INPUT class="btn" tabIndex="4" type="reset" value="重 置">
				</DIV>
			</FORM>
		</DIV>
	</DIV>
	<!--      声明        -->
	<BR />
	<CENTER class="gray">版权所有 2005-2011 西安粤嵌科技有限公司</CENTER>

</BODY>
</HTML>
