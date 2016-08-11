<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register.jsp' starting page</title>
    
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
  	<div>
  	 <%--<form action="/LoginPrj/testJavaBean.jsp" method="post">--%>
     <form action="/LoginPrj/CRegisterServlet" method="post">
        <table>
            <tr><th align="center">用户注册</th></tr>
        	<tr>
        	    <td>用户名：</td>
        	    <td><input type="text" name="userName"></td>
        	</tr>
    	    <tr>
    	        <td>密 码:</td>
    	        <td><input type="password" name="passwd"></td>
    	    </tr>
    	    <tr>
    	    	<td>确认密码：</td>
    	    	<td><input type="password" name="confirmPasswd"></td>
    	    </tr>
    	    <tr>
    	    	<td>手机号：</td>
    	    	<td><input type="text" name="phoneNum"></td>
    	    </tr>
    	    <tr>
    	    	<td></td>
    	    	<td><input type="submit" name="confirm" value="确定" align="right"></td>
    	    </tr>
        </table>
    </form>
    </div>
    <br>
    ${registerMsg}
    <div id = "toolTip">
    </div>
    <script type="text/javascript">
	var xmlhttp;
    function createRequest(url)
    {
    	if (window.XMLHttpRequest)
    	{// code for IE7+, Firefox, Chrome, Opera, Safari
    		xmlhttp=new XMLHttpRequest();
    	}
    	else
    	{// code for IE6, IE5
    		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    	}
    	xmlhttp.onreadystatechange = getResult;
    	xmlhttp.open("GET", url,true)
    }
    
    function getResult()
    {
    	if (xmlhttp.readyState == 4)
    	{
    		if (xmlhttp.status == 200)
    		{
    			document.getElementById("toolTip").innerHTML = xmlhttp.responseText;
    			document.getElementById("toolTip").style.display = "block";
    		}
    	}
    	else
    	{
    		alert("你请求的页面有问题");
    	}
    }
    function checkUser(userName)
    {
    	if (userName.value == "")
    	{
    		alert("请输入用户名");
    		userName.focus();
    	}
    	else
    	{
    		createRequest("/LoginPrj/CRegisterServlet?user="+userName);
    	}
    }
    </script>
  </body>
</html>
