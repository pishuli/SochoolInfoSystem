<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="lynn_pee.Student.*"%>
<%@ page import="org.apache.commons.beanutils.BeanUtils"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
    This is my JSP page. <br>
   <jsp:useBean id = "student" class="lynn_pee.Student.CStudentInfo"></jsp:useBean>
   <%out.write(student.getName());
     BeanUtils.populate(student, request.getParameterMap());
     %>
   <table border="1">
       <tr>
           <th>
                                             姓名
           </th>
           <th>
                                        电话
           </th>      
       </tr>
       <tr>
	       <td>
	           <%-- <jsp:setProperty name = "student" property="name" param="userName"></jsp:setProperty>--%>
	           <jsp:getProperty name = "student" property="name"></jsp:getProperty>
	       </td>
	       <td>
	           <%--<jsp:setProperty name = "student" property="phone" param="phoneNum"></jsp:setProperty>--%>
	           <jsp:getProperty name = "student" property="phone"></jsp:getProperty>
	       </td>
	   </tr>
   </table>
  </body>
</html>
