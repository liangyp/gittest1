<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  </head>
  
  <body>
    	<table>
    		<tr>
    			<td>用户编号</td>
    			<td>用户名</td>
    			<td>生日</td>
    			<td>成绩</td>
    			<td>修改</td>
    			<td>删除</td>
    		</tr>
    		<c:forEach items="${users}" var="usr">
    			<fmt:formatDate value="${usr.birthday}" var="da" pattern="yyyy年MM月dd日"/>
    			<tr>
    				<td>${usr.userid }</td>
    				<td>${usr.username }</td>
    				<td>${da }</td>
    				<td>
    					<c:forEach items="${usr.scoreses}" var="sc">
    						${sc.score }
    					</c:forEach>
    				</td>
    				<td><a href="single.action?userid=${usr.userid }">update</a></td>
    				<td><a href="delete.action?userid=${usr.userid }">delete</a></td>
    			</tr>
    		</c:forEach>
    	</table>
    	<a href="save.jsp">save</a>
  </body>
</html>
