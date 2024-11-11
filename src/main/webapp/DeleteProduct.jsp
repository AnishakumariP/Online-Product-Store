<%@page import="com.admin.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    h1, p {
        color: #333;
    }
    a {
        display: inline-block;
        margin: 10px 0;
        padding: 10px 20px;
        text-decoration: none;
        color: #fff;
        background-color: #007BFF;
        border-radius: 5px;
    }
    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
String msg = (String)request.getAttribute("msg");
out.println("<h1>Page belongs to " + ab.getFname() + "</h1>");
out.println("<p>" + msg + "</p>");
%>
<a href="product.html">Add Product</a>
<a href="view">View Products</a>
<a href="logout">Logout</a>
</body>
</html>
