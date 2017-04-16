<%-- 
    Document   : customer
    Created on : Sep 26, 2016, 7:05:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer,</title>
    </head>
    <body>
        <h1>Wellcome, ${sessionScope.USER}</h1>
        <form action="ControllerCustomers">
            <a href="products.jsp"> Smartphone </a>
            </br>
            <a href="indexkhachhang.jsp">Danh sach khach hang </a>
        </form>
    </body>
</html>
