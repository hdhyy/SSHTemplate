<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Integer item = 0; 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'exampleJsp.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="cache-control" content="no-cache">
	<!-- Js不可省略 -->
	<script type="text/javascript" src="<%=basePath%>/resources/js/json2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/resources/js/jquery.serializeObject.js"></script>
	
  </head>
  <!-- 这里比如后端传过来一个List类型的Model，那么假设这里用表单的方式来展现 -->
  <body>
  	<table>
  		<thead> 
  			<tr>
	  			<th> 编号 </th>
	  			<th> 内容 </th>
  			</tr>
  		</thead>
  		<tbody>
  			<!-- JSP标签，${exampleModel.habbit} 是后端传来的名为exampleModel的Model中的habbit属性
  				 var="habbitItem" 为iterator重命名，类似于 for(Integer item : itemList) 的item -->
		    <c:forEach items="${exampleModel.habbit}" var="habbitItem">
		    	<!-- 这里就可以用重命名的iterator了 -->
		    	<tr><td><%=item ++ %></td><td>${habbitItem}<td></tr>
		    </c:forEach>
	    </tbody>
    </table>
    <!-- 后端传来的Model对象 username password -->
    username:${username}<br/>
    password:${password}<br/>
    <!-- 两种方式提交表单 -->
    <form id="userSubmit" method="get" action="./example/jsp">   
		用户名：<input type="text" value="" name="username"/>  <br>   
		密 码：<input type="text" value="" name="password"/> <br>   
    	<!-- 传统form的submit方式 -->
		<input type="submit" value="注册" name="testSubmit"/>   
		<!-- ajax方式，直接向后端传递Model对象 -->
		<input type="button" value="注册ajax" id="submit-by-ajax"/>   
	</form>  
	<script type="text/javascript">
	//配置监听
	$("#submit-by-ajax").click(function() {
		//首先使用serializeObject将数据组装成jsObject
		var model = $("#userSubmit").serializeObject();
		//转换成Json形式
		var jsonmodel = JSON.stringify(model);
		alert("使用ajax提交");
		$.ajax({
			type : "post",//提交方式
			contentType : "application/json",//必填，后端指定ContentType为application/json
			url : "./example/ajax",//URL
			data : jsonmodel,//ajax的data
			dataType : "json",//dataType为Json
			success : function onSucc(resp) {//成功回调
				alert("success:" + resp.success);
				alert("data: " + resp.data.message);
			},
	
			error : function onErr(resp) {//失败回调
				alert('error:' + resp);
			}
		});
	});
	</script>
  </body>
</html>
