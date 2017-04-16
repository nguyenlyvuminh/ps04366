<%-- 
    Document   : editProduct
    Created on : Oct 7, 2016, 10:25:26 AM
    Author     : NLVM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Product</h1>
        <form action="ControllerProducts">
        Code:${SP.code}<br/>
        <input type="text" name="txtCode" value="${SP.code}"/>
        Name:<input type="text" name="txtName" value="${SP.name}"/><br/>
        Price:<input type="text" name="txtPrice" value="${SP.price}"/><br/>
        <input type="submit" name="action" value="Update"/>
        </form>
 </body>
</html>
