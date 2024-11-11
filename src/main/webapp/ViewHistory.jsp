<%@page import="com.history.SoldProductHistoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product History</title>
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
</style>
</head>
<body>
<nav>
<a href="view">View Product</a>
<a href="logout">Logout</a>
</nav>
<div class="container">
    <h2>Sold Product History</h2>
    <table>
        <tr>
            <th>Product Code</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Customer Name</th>
            <th>Mail ID</th>
            <th>Phone No.</th>
            <th>Holder Name</th>
            <th>Account No.</th>
            <th>Quantity</th>
            <th>Total Payment</th>
        </tr>
    <%
    ArrayList<SoldProductHistoryBean> hlist = (ArrayList<SoldProductHistoryBean>)request.getAttribute("hlist");
    if (hlist != null) {
        for(SoldProductHistoryBean sb : hlist) {
    %>
        <tr>
            <td><%= sb.getPcode() %></td>
            <td><%= sb.getPname() %></td>
            <td><%= sb.getPrice() %></td>
            <td><%= sb.getCname() %></td>
            <td><%= sb.getMail() %></td>
            <td><%= sb.getPhno() %></td>
            <td><%= sb.getHolderName() %></td>
            <td><%= sb.getAccno() %></td>
            <td><%= sb.getQty() %></td>
            <td><%= sb.getTotAmt() %></td>
        </tr>
    <%
        }
    }
    %>
    </table>
</div>
</body>
</html>
