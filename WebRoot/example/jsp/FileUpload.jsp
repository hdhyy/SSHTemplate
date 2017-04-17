<%--
  Created by IntelliJ IDEA.
  User: Du
  Date: 2016-12-27
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件测试</title>
</head>
<body>
    <form action="/example/other" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="上传" />
    </form>
</body>
</html>
