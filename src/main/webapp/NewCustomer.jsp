<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message and Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 100vh;
        margin: 0;
        padding-top: 20px;
    }
    .message {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
        margin-bottom: 20px;
    }
</style>
</head>
<body>
<%
String msg = (String)session.getAttribute("msg");
if (msg != null) {
%>
<div class="message">
    <%= msg %>
</div>
<%
}
%>
<%@include file="customerLogin.html" %>
</body>
</html>
