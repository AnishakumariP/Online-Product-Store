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
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
        color: #343a40;
    }
    .container {
        width: 70%;
        margin: auto;
        padding: 20px;
        background-color: #ffffff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-top: 50px;
        text-align: center;
    }
    nav {
        background-color: #007bff;
        padding: 10px;
        display: flex;
        justify-content: space-around;
    }
    nav a {
        color: #ffffff;
        text-decoration: none;
        padding: 8px 16px;
        margin-left: 10px;
        transition: background-color 0.3s;
    }
    nav a:hover {
        background-color: #0056b3;
    }
    h2 {
        color: #007bff;
    }
</style>
</head>
<body>

<div class="container">
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
if (ab != null) {
    out.println("<h2>Welcome " + ab.getFname() + "</h2>");
} else {
    response.sendRedirect("adminLogin.html"); // Redirect to login if not logged in
}
%>
<nav>
    <a href="product.html">Add Product</a>
    <a href="view">View All Products</a>
    <a href="history">View History</a>
    <a href="logout">Logout</a>
</nav>
</div>
</body>
</html>
