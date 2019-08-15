<%@ page language="java" import="java.util.*,com.jspsmart.upload.*"
	pageEncoding="gbk"%>

<title>My JSP 'doUpload.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		request.setCharacterEncoding("gbk");
		try {
			SmartUpload su = new SmartUpload();
			su.initialize(pageContext);
			su.setMaxFileSize(1024 * 1024 * 2);
			su.setAllowedFilesList("txt,jpg,zip");
			su.upload();
			if (su.save("/uploadfile") > 0) {
				String fileName = su.getFiles().getFile(0).getFileName();
				out.print(fileName);
				out.print("上传成功！");
			} else {
				out.print("上传失败！");
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>
