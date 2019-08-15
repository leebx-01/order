<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<TITLE>粤嵌西安论坛--帖子列表</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<Link rel="stylesheet" type="text/css" href="style/style.css" />
<script type="text/javascript">
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
		<!--      导航        -->
		<br />
		<DIV>
			&gt;&gt;<B><a href="index.jsp">论坛首页</a> </B>&gt;&gt; <B> <a
				href="#">${boardName }</a> </B>
		</DIV>
		<br />
		<!--      新帖        -->
		<DIV>
			<c:if test="${name==null }">
				<a href="login.jsp"> <IMG src="image/post.gif" name="td_post"
					border="0" id=td_post> </a>
			</c:if>
			<c:if test="${name!=null }">
				<A href="post.jsp?boardName=${boardName }&boardId=${boardId}"><IMG
					src="image/post.gif" name="td_post" border="0" id=td_post> </A>
			</c:if>
		</DIV>
		<!--         翻 页         -->
		<DIV>
			<a href="list.jsp">上一页</a>| <a href="list.jsp">下一页</a>
		</DIV>

		<DIV class="t">
			<TABLE cellSpacing="0" cellPadding="0" width="100%">
				<TR>
					<TH class="h" style="WIDTH: 100%" colSpan="4"><SPAN>&nbsp;</SPAN>
					</TH>
				</TR>
				<!--       表 头           -->
				<TR class="tr2">
					<TD>&nbsp;</TD>
					<TD style="WIDTH: 80%" align="center">文章</TD>
					<TD style="WIDTH: 10%" align="center">作者</TD>
					<TD style="WIDTH: 10%" align="center">回复</TD>
				</TR>
				<!--         主 题 列 表        -->
				<c:forEach var="l" items="${list }">
					<c:if test="${l.borderId==boardId }">
						<TR class="tr3">
							<TD><IMG src="image/topic.gif" border=0></TD>
							<TD style="FONT-SIZE: 15px"><A
								href="detail.jsp?boardId=${boardId }&boardName=${boardName }&topicId=${l.topicId}">${l.topicCaption
									}</A>
							</TD>
							<c:forEach var="n" items="${list2 }">
								<c:if test="${n.memberId==l.memberId }">
									<TD align="center">${n.memberName }</TD>
								</c:if>
							</c:forEach>
							
							<c:set var="flag" value="true"></c:set>
							
							<c:forEach var="r" items="${list3 }">
								<c:if test="${l.topicId==r.topicId }">
									<TD align="center">
									<f:formatNumber value="${r.replies }" pattern="0"></f:formatNumber>
									</TD>
									
									<c:set var="flag" value="false"></c:set>
									
								</c:if>
							</c:forEach>
							
							<c:if test="${flag }">
								<TD align="center">无回复</TD>
							</c:if>
						</TR>
					</c:if>
				</c:forEach>
			</TABLE>
		</DIV>
		<!--            翻 页          -->
		<DIV>
			<a href="list.jsp">上一页</a>| <a href="list.jsp">下一页</a>
		</DIV>
	</DIV>
	<!--             声 明          -->
	<BR />
	<CENTER class="gray">版权所有 2005-2011 西安粤嵌技有限公司</CENTER>

</BODY>
</HTML>
