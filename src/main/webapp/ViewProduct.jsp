<%@page import="com.product45.ProductBean"%>
<%@page import="java.util.List"%>
<%@page import="com.admin.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    a {
        text-decoration: none;
        color: #007BFF;
    }
    a:hover {
        text-decoration: underline;
    }
    .button-container {
        margin-top: 20px;
    }
    .button-container a {
        display: inline-block;
        margin-right: 10px;
        padding: 10px 20px;
        background-color: #007BFF;
        color: #fff;
        border-radius: 5px;
        text-align: center;
    }
    .button-container a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("<h2>Page belongs to " + ab.getFname() + "</h2>");
List<ProductBean> pb = (List<ProductBean>)session.getAttribute("pbean");
%>
<table>
    <tr>
        <th>Product Code</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Actions</th>
    </tr>
<%
for(ProductBean p : pb){
%>
    <tr>
        <td><%= p.getPcode() %></td>
        <td><%= p.getPname() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getQty() %></td>
        <td>
            <a href="edit?pcode=<%= p.getPcode() %>">Edit</a> |
            <a href="delete?pcode=<%= p.getPcode() %>">Delete</a>
        </td>
    </tr>
<%
}
%>
</table>
<div class="button-container">
    <a href="product.html">Add Product</a>
    <a href="logout">Logout</a>
</div>
</body>
</html>
