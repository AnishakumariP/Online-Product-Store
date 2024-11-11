<%@page import="com.customer.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
        color: #343a40;
    }
    .container {
        width: 80%;
        margin: auto;
        padding: 20px;
        background-color: #ffffff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-top: 50px;
    }
    nav {
        background-color: #343a40;
        padding: 10px;
        display: flex;
        justify-content: flex-end;
    }
    nav a {
        color: #ffffff;
        text-decoration: none;
        padding: 8px 16px;
        margin-left: 10px;
        transition: background-color 0.3s;
    }
    nav a:hover {
        background-color: #495057;
    }
    .welcome {
        font-size: 1.5em;
        margin-top: 20px;
    }
</style>
</head>
<body>
<nav>
    <a href="prodView">View Products</a>
    <a href="logout">Logout</a>
</nav>
<div class="container">
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
if (cb != null) {
	out.println("Logged in successfully..<br>");
    out.println("<div class='welcome'>Page belongs to " + cb.getFname() + "</div>");
} else {
    response.sendRedirect("customerLogin.html"); // Redirect to login if not logged in
}
%>
</div>

</body>
</html>
