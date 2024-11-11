<%@page import="com.admin.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background-color: #fff;
        padding: 30px 50px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 300px;
    }
    h2 {
        margin-top: 0;
    }
    p {
        margin: 10px 0;
    }
    a {
        display: block;
        margin: 10px 0;
        padding: 10px;
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        border-radius: 5px;
        transition: background-color 0.3s;
    }
    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
if (ab != null) {
    out.println("<h2>Page belongs to " + ab.getFname() + "</h2>");
} else {
    response.sendRedirect("adminLogin.html"); // Redirect to login if not logged in
}
String msg = (String)session.getAttribute("msg");
if (msg != null) {
    out.println("<p>" + msg + "</p>");
}
%>
    <a href="product.html">Add Product</a>
    <a href="view">View All Products</a>
    <a href="logout">Logout</a>
</div>
</body>
</html>
