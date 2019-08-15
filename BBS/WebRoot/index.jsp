<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<TITLE>欢迎访问粤嵌西安论坛</TITLE>
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
	<DIV class="t">
		<TABLE cellSpacing="0" cellPadding="0" width="100%">
			<TR class="tr2" align="center">
				<TD colSpan="2">主题</TD>
				<TD style="WIDTH: 10%;">数量</TD>
				<TD style="WIDTH: 30%">最后发表</TD>
			</TR>
			<!--       主版块       -->
			<c:forEach var="m" items="${list }">
				<TR class="tr3">
					<TD colspan="4">${m.forcumName }</TD>
				</TR>

				<!--       子版块       -->
				<c:forEach var="m2" items="${list2 }">
					<c:if test="${m.forcumId==m2.forcumId }">
						<TR class="tr3">
							<TD width="5%">&nbsp;</TD>
							<TH align="left"><IMG src="image/board.gif"> <A
								href="list.jsp?boardId=${m2.boardId }&boardName=${m2.boardName}">${m2.boardName }</A></TH>
							<c:forEach var="a" items="${list4 }">
								<c:if test="${a.boardId==m2.boardId }">
									<TD align="center">
									<f:formatNumber value="${a.total }" pattern="0"></f:formatNumber>
									</TD>
								</c:if>
							</c:forEach>
							</c:if>
							<c:forEach var="m3" items="${list3 }">
								<c:if test="${m2.boardId==m3.borderId && m.forcumId==m2.forcumId}">
									<TH><SPAN> <A
											href="detail.jsp?boardId=${m2.boardId }&boardName=${m2.boardName}&topicId=${m3.topicId}">${m3.topicCaption
												} </A> </SPAN> <BR /> <SPAN>accpt</SPAN> <SPAN class="gray">[
											${m3.publishTime } ]</SPAN></TH>
								</c:if>
							</c:forEach>
						</TR>
					
				</c:forEach>

			</c:forEach>


		</TABLE>
	</DIV>

	<BR />
	<CENTER class="gray">版权所有 2005-2011 西安粤嵌科技有限公司</CENTER>
</BODY>
</HTML>