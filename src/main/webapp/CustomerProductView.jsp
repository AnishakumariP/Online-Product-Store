<%@page import="com.customer.CustomerBean"%>
<%@page import="com.product45.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Products Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }
    nav {
        background-color: #333;
        padding: 10px;
    }
    nav a {
        color: white;
        text-decoration: none;
        padding: 8px 16px;
        display: inline-block;
    }
    nav a:hover{
    color: red;
    }
    .container {
        width: 80%;
        margin: auto;
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-top: 20px;
    }
    h2 {
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        text-align: left;
    }
    td {
        padding: 10px;
        text-align: left;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    a {
        color: #4CAF50;
        text-decoration: none;
    }
</style>
</head>
<body>
<nav><a href="logout">Logout</a></nav>
<div class="container">
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
if (cb != null) {
    out.println("<h2>Page belongs to " + cb.getFname() + "</h2>");
} else {
    response.sendRedirect("customerLogin.html"); // Redirect to login if not logged in
}
List<ProductBean> pb = (List<ProductBean>)session.getAttribute("pbean");
%>
<table>
    <tr>
        <th>Product Code</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
<%
if (pb != null) {
    for(ProductBean p : pb){
%>
    <tr>
        <td><%= p.getPcode() %></td>
        <td><%= p.getPname() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getQty() %></td>
        <td>
            <a href="buy?pcode=<%= p.getPcode() %>">Buy</a>
        </td>
    </tr>
<%
    }
}
%>
</table>
</div>
</body>
</html>
