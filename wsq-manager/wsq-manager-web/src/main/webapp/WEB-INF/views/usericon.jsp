<%--
  Created by IntelliJ IDEA.
  User: qijiangtao
  Date: 2019/5/9
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>icon</title>
</head>
<body>
${pageContext.request.contextPath}
<br>
<form action="${pageContext.request.contextPath}/fileupload" enctype="multipart/form-data" method="post">
    文件上传: <input type="file" name="file">
    <input type="submit" value="提交">
</form>
</body>
</html>
