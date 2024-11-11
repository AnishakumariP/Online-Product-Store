<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
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
    .details {
        margin-top: 20px;
    }
    .details p {
        font-size: 1.1em;
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
    <h1>Order Details</h1>
    <div class="details">
        <%
        String pcode = (String)request.getAttribute("pCode");
        String pname = (String)request.getAttribute("pName");
        int qty = (int)session.getAttribute("Qty");
        double totAmount = (double)session.getAttribute("totalBill");
        out.println("<p>Product Code: " + pcode + "</p>");
        out.println("<p>Product Name: " + pname + "</p>");
        out.println("<p>Quantity: " + qty + "</p>");
        out.println("<p>Total Bill: " + totAmount + "</p>");
        %>
    </div>
    <a href="payment.html">Payment</a>
</div>
</body>
</html>
