<%@page import="com.customer.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
    }
    nav {
        background-color: #343a40;
        padding: 10px;
    }
    nav a {
        color: white;
        text-decoration: none;
        margin-right: 10px;
    }
    .container {
        margin: 20px;
    }
    h1 {
        color: #343a40;
    }
    .message {
        color: #28a745;
        font-weight: bold;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 15px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
    }
    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<nav><a href="logout">Logout</a></nav>
<div class="container">
    <%
    CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
    String msg = (String)request.getAttribute("msg");
    out.println("<p class='message'>" + msg + "</p>");
    out.println("<h1>" + cb.getFname() + ", Your order is confirmed!!</h1>");
    %>
    <a href="prodView">View Products</a>
</div>
</body>
</html>
