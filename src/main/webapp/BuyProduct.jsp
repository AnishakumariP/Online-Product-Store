<%@page import="com.product45.ProductBean"%>
<%@page import="com.customer.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
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
    form {
        margin-top: 20px;
    }
    input[type="number"]{
    padding: 5px;
        margin-top: 10px;
    } 
    input[type="submit"] {
    background: navy;
    color: white;
    border:none;
    font-size: 13px;
    border-radius: 7px;
        padding: 13px;
        margin-top: 10px;
        transition: 0.3s;
    }
    input[type="submit"]:hover {
	background: blue;
	
}
</style>
</head>
<body>
<nav>
    <a href="logout">Logout</a>
</nav>
<div class="container">
    <%
    CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
    ProductBean pb = (ProductBean)session.getAttribute("bean");
    out.println("<h1>Page belongs to " + cb.getFname() + "</h1>");
    out.println("<p>Product code: " + pb.getPcode() + "</p>");
    out.println("<p>Product Name: " + pb.getPname() + "</p>");
    out.println("<p>Product price: " + pb.getPrice() + "</p>");
    out.println("<p>Available Product Qty: " + pb.getQty() + "</p>");
    %>
    <form action="bill" method="post">
        <label for="qty">Require Quantity:</label>
        <input type="number" name="qty" id="qty" min="0"><br>
        <input type="submit" value="Generate Bill"><br>
    </form>
</div>
</body>
</html>
