<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<TITLE>粤嵌西安论坛--看贴</TITLE>
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
		<br />
		<!--      导航        -->
		<DIV>
			&gt;&gt;<B><a href="index.jsp">论坛首页</a> </B>&gt;&gt; <B><a
				href="list.jsp?boardId=${boardId }&boardName=${boardName}">${boardName
					}</a> </B>
		</DIV>
		<br />
		<!--      回复、新帖        -->
		<DIV>
			<c:if test="${name==null }">
				<A href="login.jsp"><IMG src="image/reply.gif" border="0"
					id=td_post> </A>
			</c:if>
			<c:if test="${name!=null }">
				<A href="huifu.jsp?boardName=${boardName }&boardId=${boardId}"><IMG
				
					src="image/reply.gif" border="0" id=td_post> </A>
			</c:if>
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
			<a href="detail.jsp">上一页</a>| <a href="detail.jsp">下一页</a>
		</DIV>
		<!--      本页主题的标题        -->
		<DIV>
			<TABLE cellSpacing="0" cellPadding="0" width="100%">
				<TR>
					<TH class="h">本页主题: ${theme }</TH>
				</TR>
				<TR class="tr2">
					<TD>&nbsp;</TD>
				</TR>
			</TABLE>
		</DIV>

		<!--      主题        -->

		<DIV class="t">
			<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed"
				cellSpacing="0" cellPadding="0" width="100%">
				<TR class="tr1">
					<TH style="WIDTH: 20%"><B>t</B><BR /> <img
						src="image/head/2.gif" /><BR /> 注册:2007-07-27<BR /></TH>
					<c:forEach var="t" items="${list4 }">
						<c:if test="${t.topicId==topicId }">
							<TH>
								<H4>${t.topicCaption }</H4>
								<DIV>${t.topicContent }</DIV>
								<DIV class="tipad gray">发表：[${t.publishTime }] &nbsp;
									最后修改:[${t.modifyTime }]</DIV></TH>
						</c:if>
					</c:forEach>
				</TR>
			</TABLE>
		</DIV>

		<!-- 回帖 -->
		<c:forEach var="r" items="${list }">
			<c:if test="${r.borderId==boardId }">
				<c:if test="${r.topicId==topicId }">
					<DIV class="t">
						<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed"
							cellSpacing="0" cellPadding="0" width="100%">
							<TR class="tr1">
								<c:forEach var="m" items="${list2 }">
									<c:if test="${m.memberId==r.memberId }">
										<TH style="WIDTH: 20%"><B>${m.memberName }</B><BR /> <img
											src="image/head/${m.memberIcon }" /><BR /> 注册:${m.regDate }<BR />
										</TH>
									</c:if>
								</c:forEach>
								<TH>
									<DIV>${r.topicContent }</DIV>
									<DIV class="tipad gray">发表：[${r.publishTime }] &nbsp;
										最后修改:[${r.modifyTime }]</DIV>
								</TH>
							</TR>
						</TABLE>
					</DIV>
				</c:if>
			</c:if>
		</c:forEach>
	</DIV>

	<!--      声明        -->
	<BR>
	<CENTER class="gray">版权所有 2005-2011 西安粤嵌科技有限公司</CENTER>
</BODY>
</HTML>
