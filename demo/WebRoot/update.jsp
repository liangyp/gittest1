<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'update.jsp' starting page</title>
    
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
    <form action="update.action" method="post">
    	userid<input type="text" name="us.userid" value="${user.userid }"/><br/>
    	username<input type="text" name="us.username" value="${user.username }"/><br/>
    	birthday<input type="text" name="us.birthday" value="${user.birthday }"/><br/>
    	<c:forEach items="${user.scoreses}" var="sco">
    	<input type="text" name="sc.scid" value="${sco.scid }">
    	score<input type="text" name="sc.score" value="${sco.score }"/><br/>
    	</c:forEach>
    	<input type="submit" value="ok">
    </form>
  </body>
</html>
