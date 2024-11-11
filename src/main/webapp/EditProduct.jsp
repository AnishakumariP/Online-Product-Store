<%@page import="com.product45.ProductBean"%>
<%@page import="com.admin.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Update</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    h1 {
        color: #333;
    }
    form {
    width: 50%;
        background: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    input[type="text"], input[type="number"] {
        width: 70%;
        padding: 10px;
        margin: 10px 0;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        background: #007BFF;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background: #0056b3;
    }
</style>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ProductBean pb = (ProductBean)session.getAttribute("bean");
out.println("Page belongs to "+ab.getFname()+"<br>");
%>
<h1>Update Product</h1>
<form action="update" method="post">
    <input type="hidden" name="pcode" value="<%=pb.getPcode() %>"><br>
    Product price: <input type="text" name="price" value="<%=pb.getPrice() %>"><br>
    Product Qty: <input type="number" name="qty" value="<%=pb.getQty() %>"><br>
    <input type="submit" value="Update Product"><br>
</form>
</body>
</html>
