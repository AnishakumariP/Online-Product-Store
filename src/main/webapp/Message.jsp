<%@page import="java.awt.geom.Path2D"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
        display: flex;
        align-items: center;
        justify-content: center; 
        flex-direction: column;
    }
   .message{
   
   margin:20px auto;
   color:red;
   
   }
</style>
</head>
<body>
<div class="message">
<%
String msg = (String)request.getAttribute("msg");
//out.println( msg );

%>
<h2><%=msg %></h2>
</div>
<%@include file="home.html" %>
</body>
</html>
