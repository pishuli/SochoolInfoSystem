<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	div
	{
	    backgroud-color:#DDDDDD;
	}
	</style>
	<script type="text/javascript">
	function changeVCode(){
		var imgVCode = document.getElementById("imgVCodeId");
		imgVCode.src = "/LoginPrj/VerifyCodeServlet?a="+new Date().getTime();
	}
	</script>
  </head>
  
  <%-- <body background="pic/login_bk.jpg">--%>
  <body>
    This is my JSP page. <br>
    <div class="loginFrame" align = "center">
    <form action="/LoginPrj/CLoginServlet" method="post">
    <table>
        <tr>
        	<td>用户名:</td> <td><input type="text" name="userId"></td>
    	</tr>
    	<tr>
    		<td>密码:</td> <td><input type="password" name="passwd"></td>
        </tr>
        <tr>
        </tr>
        <tr>
            <td>
                       验证码:
            </td>
            <td>
            <input type="text" name="vcode">
            </td>
            <td>
            </td>
            <td>
                <img id="imgVCodeId" src="/LoginPrj/VerifyCodeServlet">
                <a href="javascript:changeVCode()">换一张</a>
            </td> 
        </tr>
        <tr>
          <td align = "right">
            	<input type="submit" name = "login" value="login">
          </td>
        </tr>
    </table>
    </form>
    <a href="/LoginPrj/Register.jsp"><button>register</button></a>
    <br>
    ${loginMessage}
    </div>
  </body>
</html>
